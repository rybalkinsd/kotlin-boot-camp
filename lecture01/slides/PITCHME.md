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
1. Homework


---
@title[Agenda]
1. @css[highlight](About this course)
1. Introduction to Kotlin
1. Introduction to Git
1. Introduction to Gradle
1. Introduction to Travis-CI
1. Homework


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
 

`---
@title[Syllabus]
1. Kotlin basics
1. Kotlin advance topics
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
- Homework = 30  
- Final Project = 40  
- \+ extra points for several tasks  
- \+ extra points for course improvements (PR, fixes, etc)

**Certificate:**  
get @css[highlight](50+ points) and pass @css[highlight](Final Project) 

**Marks:**  
**3**: 50-69  
**4**: 70-90  
**5**: 90+  


---
@title[Final Project]
We will develop a replica of @css[highlight](bomberman) game.
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
1. Homework


---
@title[Setup]
1. Install Oracle jdk 8 [link](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. Install Intellij Idea CE or UE [link](https://www.jetbrains.com/idea/download/index.html#section=mac)
1. Configure IDE Kotlin Plugin

*We will start using kotlin compiler within IDE. In the next lectures we will learn how to build & run code without IDE*  


---?code=lecture01/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/main.kt&title=HW
<!-- .slide: class="center" -->

@[3,5](function `main` is an entry point of application)

@[4](`println` prints the given message and newline to the standard output stream)



---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*