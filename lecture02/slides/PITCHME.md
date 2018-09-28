---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 2
#### Introduction #2


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
git checkout -b lecture02 upstream/lecture02
cd lecture02
```

open as new project


---
@title[Agenda]
1. Practice 1. Functions
1. Classes and Types
1. OOP related stuff
1. Practice
1. Assignment 2


---
@title[Agenda]
1. @css[highlight](Practice 1. functions)
1. Classes and Types


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/practice/basics.kt&title=Practice 1. Functions. Basics
<!-- .slide: class="center" -->


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/practice/producer.kt&title=Practice 1. Functions. Producer
<!-- .slide: class="center" -->


---
@title[Agenda]
1. Practice 1. functions
1. @css[highlight](Classes and Types)
1. Assignment 2


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/point/Point1.kt&title=`class` declaration
<!-- .slide: class="center" -->


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/point/Point2.kt&title=`class` default constructor and `init` block
<!-- .slide: class="center" -->


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/point/Point3.kt&title=simplified `class` declaration
<!-- .slide: class="center" -->


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/point/Point.kt&title=`data class` declaration
<!-- .slide: class="center" -->


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/extension/pointExt.kt&title=`class` declaration
<!-- .slide: class="center" -->

@[5](isZero extension)

@[7](`copy` method usage)


---
@title[Nullability]

class **String** produces two **Types**
- String - not null string
- String? - nullable string


---
@title[Nullability. Example]

```kotlin
val s: String = "abc" // <-- legal
s = null // <-- not legal

val ns: String? = null // <-- legal

```



---
@title[Assignment 2]
1. Fix tests in branch **assignment02** and push it to **your fork**  
[[Github branch]](https://github.com/rybalkinsd/kotlin-boot-camp/tree/assignment02)
[[Travis build]](https://travis-ci.org/rybalkinsd/kotlin-boot-camp/builds/204177834)
2. Make pull request to the [**course repository**](https://github.com/rybalkinsd/kotlin-boot-camp)  
(from your branch **assignment02** to ours **assignment02**)
3. Write your **first name** and **family name** in description of pull request
4. Make sure **tests** and **checkstyle** are passing in **Travis**  


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
