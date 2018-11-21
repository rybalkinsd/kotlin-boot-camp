---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 9
#### Threading model


---
@title[Sign in]
<!-- .slide: class="center" -->

Please [**sign in**](https://sphere.mail.ru/)
 
*For off-line students only*


---
@title[Get ready]
<!-- .slide: class="center" -->
```bash
git fetch upstream
git checkout -b lecture09 upstream/lecture09
cd lecture09
```

open as new project

---
@title[Agenda]
1. @css[highlight](Threads and processes)
1. Parallelism and Concurrency
1. Challenges of concurrent programs
1. Game threading scheme

---
@title[Parallelism]
Why we need parallelism?

---
@title[How parallelism is possible?]
- A cluster of machines
- Several processes within single machine
- Several Threads within single process

---
@title[Process vs Thread]
- **Process** has dedicated resources (memory)
- **Threads** share memory space

---
@title[Process vs Thread]
<img src="lecture09/slides/assets/images/process.png" alt="process" style="width: 450px;"/>

---
@title[Threads and processes. OS Role]
Operating System
- provides API (**system calls**) for creating and running threads and processes. Normally a **program** is represented by single **process**.
- schedules threads and processes (**context switch**)
- provides API for managing threads

Famous Threads and Processes API from UNIX world:
- [**fork**](https://linux.die.net/man/2/fork) (creates process)  
- [**clone**](http://man7.org/linux/man-pages/man2/clone.2.html) (creates thread)  
  
---
@title[Kotlin Threads]
Kotlin provide it's own API for managing threads and processes, it uses system calls under the hood

In @css[highlight](Kotlin) we have @css[highlight](Thread) class and @css[highlight](Runnable) interface

---
@title[interface Runnable]
```java
@FunctionalInterface
interface Runnable {
    public abstract void run();
}
```


---
@title[class Thread]
```java
class Thread implements Runnable {  
    void start() {}
    void interrupt() {} 
    void join() {}
    
    static sleep(long time) {}
    // ...
}
```


---
@title[Start and Run]
```java
new Thread( runnable ).start();
```

---
@title[jstack]
You can see kotlin threads with standard java util @css[highlight](jstack)  
(in case of running kotlin on JVM, of course)
 
```bash
# show all java processes
jcmd
# get report
jstack <pid>
```

---
@title[Agenda]
1. Threads and processes
1. @css[highlight](Parallelism and Concurrency)
1. Challenges of concurrent programs
1. Game threading scheme

---
@title[What does it mean that threads share memory?]
They read and write to shared mutable variable (**shared mutable state**)
> @see billing

---
@title[Concurrency vs parallelism]
**Concurrency** - contention on shared resources (memory, shared state)  
**Parallelism** - is possible without concurrency  

---
@title[Examples?]
Any examples of task that can be executed in parallel without concurrency?

---
@title[Bomberman server is concurrent]
Different threads change and read game state  
Examples of game state in Bomberman?  
Is it **shared mutable state**?

---
@title[Agenda]
1. Threads and processes
1. Parallelism and Concurrency
1. @css[highlight](Challenges of concurrent programs)
1. Game threading scheme

---
@title[What if we just write concurrent program as single-threaded?]
**Many things will go wrong**
> @see billing


---
@title[Billing example]
This simple example shows how you can loose money when using bad synchronization Oo  
Billing service allow to transfer money between users  
```bash
curl -XPOST localhost:8080/billing/addUser -d "user=sasha&money=100000"
curl -XPOST localhost:8080/billing/addUser -d "user=sergey&money=100000"
curl localhost:8080/billing/stat
curl -XPOST localhost:8080/billing/sendMoney -d "from=sergey&to=sasha&money=1"
```
Start server and emulate fast money transfer with **jmeter**. Then look at stat again:
```bash
curl localhost:8080/billing/stat
```
> @see billing

---
@title[You've lost your money (or gained)]
Technically, the invariant was broken:
> Total amount of money in system must be preserved during **sendMoney**

Why we loose money?  
Because in multithreaded systems **guarantees are weaker** than in single-threaded.  
Multithreaded systems **without proper synchronization** have some problems.

---
@title[1. Race condition]
Race condition (состояние гони, гонка)
program behaviour where the output is dependent on the
sequence or timing of other uncontrollable events  
  
Behaviour of multithreaded program is (inter alia) dependent on **OS scheduling**  
  
**Uncontrollable races are almost always erroneous**  
> @see randomrun

---
@title[2. Data races]
**Data race** - when several processes communicate via **shared mutable state** and at least one is writing **without proper synchronization**  
 (Not the same as race conditions)

Is **Bomberman** prone to data races?  
> @see volatileexample

---
@title[3. Locking problems]
Standard way to handle multi-threaded problems is using critical sections (on locks)
Locking misuse can lead to common problems:
- deadlocks
- livelocks

---
@title[4. Performance]
Reasoning about performance of concurrent programs is tricky
> @see https://shipilev.net/ about java

---
@title[How different languages support concurrency]
Some languages and platforms have support for concurrency:  
- java have memory model as part of language specification
- c (concurrency provided by **pthreads** library)
- c++ (before C++11)
Some just avoid concurrency
- Python (GIL)
- Ruby (GIL, Introduced Guild Locks)

---
@title[Kotlin concurrency support]
Unfortunately, Kotlin does not have @css[highlight](memory model) now  
Yet it may have it in future  
  
This means that memory model is dependent by underlying platform:
- JVM
- JS Engine
- ...
  
If we target kotlin to JVM only, we can reason in terms of JMM

---
@title[Java concurrency]
Lecture from Java course 2018:  
[slides](https://gitpitch.com/rybalkinsd/atom/lecture11?grs=github&t=white&p=lecture11%2Fpresentation#/)  
[video](https://www.youtube.com/watch?v=lVtMjcZyAgI)

---
@title[Can we make it easier?]
@css[highlight](Avoid concurrency!)  
@css[highlight](Avoid shared mutable state!)
- be stateless
- use val
- use ThreadLocal

In our game we will use simple scheme that allow to @css[highlight](almost) forget about concurrency

---
@title[Agenda]
1. Threads and processes
1. Parallelism and Concurrency
1. Challenges of concurrent programs
1. @css[highlight](Game threading scheme)

---
## Threading scheme in game server
<img src="lecture09/slides/assets/images/GameThreads.png" alt="exception" style="width: 850px;"/>

---

@title[How different threads can communicate?]
Nothing new - they can communicate via public variables, via mutable objects.  
### How threads communicate in our game  
0. **Only game-mechanics thread** communicate with **GameSession** (so game mechanics is single-threaded)
0. WS threads communicate with game mechanics via **thread-safe queue**
---
@title[Game state]
**GameSession** - mechanics state (players, position)  
**InputQueue** - input data from users  
**ConnectionPool** - connected players  


---
## Practice
> @see billing

In this example we have billing service that can send money from user to user

---
## Billing API
Create user with money
```bash
> curl -X POST localhost:8080/billing/addUser -d 'user=sergey&money=100000'
```
Show money for all users
```bash
> curl localhost:8080/billing/stat
```
Send money from one user to another
```$xslt
> curl -X POST 'localhost:8080/billing/sendMoney' -d 'from=sasha&to=sergey&money=1'
```
One-liner to reset default users
```bash
> curl -X POST localhost:8080/billing/addUser -d 'user=sergey&money=100000'; curl -X POST localhost:8080/billing/addUser -d 'user=sasha&money=100000'; curl localhost:8080/billing/stat
```

---
## Task
The implementation is **not thread safe**. Make it correct any way you like  
When you are done, ask for check and name your **IP address**  
I will use **JMeter** for load-testing your service  
http://jmeter.apache.org/  
(you can use it too, testing scenario is located at **lecture11/Test_billing.jmx**)


---
## References
[Java concurrency in practice (signature book for Java Developer)](https://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601)   
[Alexey Shipilev blog (JMM, concurrency, performance, benchmarks for people, JDK contributor)](https://shipilev.net/)  
[Doug Lea-s home page (java.util.concurrent father and famous spec in concurrency and allocators)](http://g.oswego.edu/)  
[Java Memory Model Pragmatics (best explanation of JMM - available in russian)](https://shipilev.net/#jmm)  
[JMM Under the hood (deep explanation of JMM)](http://gvsmirnov.ru/blog/tech/2014/02/10/jmm-under-the-hood.html)  
[What Every Dev Must Know About Multithreaded Apps (Common knowledge)](https://lyle.smu.edu/~coyle/cse8313/handouts.fall06/s04.msdn.multithreading.pdf)  
Lecture from Java course 2018: 
[slides](https://gitpitch.com/rybalkinsd/atom/lecture11?grs=github&t=white&p=lecture11%2Fpresentation#/])
[video](https://www.youtube.com/watch?v=lVtMjcZyAgI)
  

---
## Practice. Billing problem
> @see billing

Need to solve a classic task about money transfer sync.

API:
```
curl -X POST 
     -H "Content-Type: application/x-www-form-urlencoded" 
     -d 'user=bob&money=42' 
 "http://localhost:8080/billing/addUser"
 
curl -X POST 
    -H "Content-Type: application/x-www-form-urlencoded" 
    -d 'from=alice&to=bob&money=12' 
 "http://localhost:8080/billing/sendMoney" 
 
curl -X GET 
 "http://localhost:8080/billing/stat" 
```


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
