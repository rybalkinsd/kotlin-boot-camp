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

@fa[bug] **I like successful builds** @fa[bug]


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
@title[Agenda]
1. About this course
1. @css[highlight](Introduction to Kotlin)
1. Introduction to Git
1. Introduction to Gradle
1. Introduction to Travis-CI
1. Homework


---?code=lecture01/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/main.kt
@title[Hello, World!]

@[3-5](main is an entry point of application)