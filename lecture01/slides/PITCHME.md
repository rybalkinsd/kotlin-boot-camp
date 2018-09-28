---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 1
#### Introduction


---
<!-- .slide: class="center" -->
@title[Sign in]

Please [**sign in**](https://sphere.mail.ru/)
 
*For off-line students only*


---
@title[Agenda]
1. About this course
1. Introduction to Kotlin
1. Introduction to Git
1. Introduction to Gradle
1. Introduction to Travis-CI
1. Assignment 1


---
@title[Agenda]
1. @css[highlight](About this course)
1. Introduction to Kotlin
1. Introduction to Git
1. Introduction to Gradle
1. Introduction to Travis-CI
1. Assignment 1


---
@title[About me]
<img src="lecture01/slides/assets/images/me.jpeg" alt="me" class="small" align="left"/>  
- Principal Engineer @ Alibaba Group
- Former Yandex @fa[yandex], Mail.Ru Group @fa[at] 
- [https://github.com/rybalkinsd](https://github.com/rybalkinsd) @fa[github]
- Kotlin ~ 2 years
- Java ~ 9 years @fa[js]

**My favorite hub is GitHub**


---
<!-- .slide: class="center" -->
@title[Course target]

In this course you will learn how to use Kotlin and it's ecosystem for @css[highlight](backend) development.

You should treat course materials as a @css[highlight](practical minimum) 
for Kotlin and it's present backend environment. 

---
@title[Technology stack]
- Kotlin 1.2 (1.3)
    - jvm target
- Java 11 (8)
- Spring Framework
    - boot
    - mvc, webflux
    - data
- Transport 
    - http 
    - websocket
- PostgreSQL


---
@title[Technology stack. Tooling]
- Gradle
    - Kotlin DSL
- Docker @fa[docker]
- CI/tooling 
    - Travis-CI
    - Codecov
    - Codacy
- Git @fa[code-branch]
 

---
@title[Syllabus]
1. Kotlin basics
1. Kotlin advanced topics
1. Web
1. Storage
1. Infrastructure
1. Course Project

---
@title[Course links]

[**Course web page**](https://github.com/rybalkinsd/kotlin-boot-camp) @fa[link]

[**Kotlin official site**](https://kotlinlang.org/) @fa[link] 

[**Kotlin boot camp**](https://t.me/joinchat/AAISfEea7uAktmNMqKiJmw) @fa[telegram] 

[**atom java** - our java group](https://t.me/joinchat/AAISfEF63F8ntU5UtUZOyw) @fa[telegram] 


---
@title[How to get certificate]
- Intermediate control & Hackathon = 40 
- Assignments = 30  
- Final Project = 30  
- \+ extra points for several tasks  
- \+ extra points for course improvements (PR, fixes, etc)

**Certificate:**  
get @css[highlight](70+ points) and pass @css[highlight](Final Project) 

**Marks:**  
**3**: 70+  
**4**: 80+  
**5**: 95+  


---
@title[Final Project]
You will develop a replica of @css[highlight](bomberman) game.

We inspired by [bombergirl](http://bombergirl.matousskala.cz/)  

We already built a [JS fronted](https://github.com/rybalkinsd/atom-bomberman-frontend) for you.  

Project should be done in small groups of 2-3 students.  

**No project - No certificate**


---
@title[Agenda]
1. About this course
1. @css[highlight](Introduction to Kotlin)
1. Introduction to Git
1. Introduction to Gradle
1. Introduction to Travis-CI
1. Assignment 1


---
@title[Setup]
1. Install Oracle jdk 8 [link](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. Install Intellij Idea CE or UE [link](https://www.jetbrains.com/idea/download/index.html#section=mac)
1. Configure IDE Kotlin Plugin

*We will start using kotlin compiler within IDE. In the next lectures we will learn how to build & run code without IDE*  


---?code=lecture01/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/helloworld.kt&title=Hello, World!
<!-- .slide: class="center" -->

@[3,5](function `main` is an entry point of application)

@[4](`println` prints the given message and newline to the standard output stream)


---
@title[Types]

| Type          | Range             |
| ------------- | -----------------:|
| Boolean       | true/false        |
| Byte          | -128-127          |
| Char          | \u0000-\uffff     |
| Short         | -32768 - 32767    |
| Int           | -2^31 - (2^31)-1  |
| Long          | -2^63 - (2^63)-1  |
| Float         | IEEE 754          |
| Double        | IEEE 754          |


---?code=lecture01/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/basics/valvar.kt&title=`val` and `var`
<!-- .slide: class="center" -->

@[3](Assigning a value)
@[5](Assigning a list)
@[7](Assigning an array)
@[10-14](variable could be modified)


---?code=lecture01/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/basics/if.kt&title=`if` expression
<!-- .slide: class="center" -->

@[3](Assigning a value)
@[5-8](Plain old useage)
@[10-13](`if` is an expression in kotlin)
@[15-17](... and after some simplification)


---?code=lecture01/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/basics/when.kt&title=`when` expression
<!-- .slide: class="center" -->

@[3-9](when conditions)
@[11-15](... and after some simplification)


---?code=lecture01/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/basics/loop.kt&title=`for`
<!-- .slide: class="center" -->

@[3-11](Plain old `for` loop)
@[13-17](Functional approach)
@[19-22](`repeat` construction)

---
@title[Agenda]
1. About this course
1. Introduction to Kotlin
1. Introduction to Git
1. @css[highlight](Introduction to Gradle)
1. Introduction to Travis-CI
1. Assignment 1


---
@title[Gradle]

[**Gradle**](https://gradle.org/) - build automation system

[User Manual](https://docs.gradle.org/current/userguide/userguide.html)

Our project gradle version: `4.0.1+`

You can install and configure gradle or just use *gradle wrapper (gradlew)* from lecture root directory.
 

---
@title[Gradle. Why?]
- build/test/package ... your project
- support custom build stages, configurable with **Kotlin** and Groovy 
- manage **dependencies** (automatically download)
- manage project structure  


---
@title[Gradle. Concept]

Everything in Gradle sits on top of two basic concepts: **projects** and **tasks**.

Gradle build = 1+ projects (build, deploy, publish, etc)

Project = 1+ tasks (compile class, create jar, generate javadoc)

[tutorial](https://docs.gradle.org/current/userguide/tutorial_using_tasks.html)


---
@title[build.gradle]

`build.gradle.kts` - is a build configuration script written with Gradle Kotlin DSL.

It is a kotlin script
- compilable
- statically typed
- good code completion in IDE 


---?code=lecture01/build.gradle.kts&title=build.gradle.kts
<!-- .slide: class="center" -->

@[3-4](Standard project versioning)

@[6-8](Plugin section configures the plugin dependencies for this project)

@[10-12](`KotlinCompile` task with target jvm version configured)

@[18-21](Project dependencies)

@[14-16](Dependencies repo configuration)


---
@title[Gradle. Usage]

**Windows:**
```shell
gradlew.bat [your-task/s]
```

**linux/macOS:**
```shell
./gradlew [your-task/s]
```

---
@title[Agenda]
1. About this course
1. Introduction to Kotlin)
1. Introduction to Git
1. Introduction to Gradle
1. @css[highlight](Introduction to Travis-CI)
1. Assignment 1


---
@title[Travis-CI]
Continuous Integration Tool
[https://travis-ci.org/](https://travis-ci.org/)

When you push to repository - Travis automatically runs gradle build on server
It tracks all branches and pull requests

[kotlin boot camp on travis](https://travis-ci.org/rybalkinsd/kotlin-boot-camp/pull_requests)

**Check your pull requests there!**

**All tests should pass!**


---
@title[Agenda]
1. About this course
1. Introduction to Kotlin)
1. Introduction to Git
1. Introduction to Gradle
1. Introduction to Travis-CI
1. @css[highlight](Assignment 1)


---
@title[Assignment 1]
1. Fix tests in branch **assignment01** and push it to **your fork**  
[[Github branch]](https://github.com/rybalkinsd/kotlin-boot-camp/tree/assignment01)
[[Travis build]](https://travis-ci.org/rybalkinsd/kotlin-boot-camp)
2. Make pull request to the [**course repository**](https://github.com/rybalkinsd/kotlin-boot-camp)  
(from your branch **assignment01** to ours **assignment01**)
3. Write your **first name** and **family name** in description of pull request
4. Make sure **tests** and **checkstyle** are passing in **Travis**  


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
