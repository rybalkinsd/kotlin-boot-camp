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
1. Checkstyle
1. Practice. Functions
1. Classes and Types
1. Assignment 2


---
@title[Agenda]
1. @css[highlight](Checkstyle)
1. Practice. Functions
1. Classes and Types
1. Assignment 2


---
@title[Checkstyle]
<!-- .slide: class="center" -->
We will using [ktlint](https://ktlint.github.io/) for our checkstyle.

ktlint is checking formatting according to [set of rules](https://ktlint.github.io/#rules)


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/build.gradle.kts&title=Checkstyle. Configuration
@[19, 25](Setting ktlint configuration)
@[29-35](Creating ktlint task)
@[37-39](Adding check dependencie on ktlint task)


---
@title[Checkstyle. Local config]
![SAMBA Deployment](lecture02/slides/assets/images/ktlint_config.jpg)


---
@title[Agenda]
1. Checkstyle
1. @css[highlight](Practice. Functions)
1. Classes and Types
1. Assignment 2


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/practice/basics.kt&title=Practice. Functions
<!-- .slide: class="center" -->

@[4-14](min)
@[17-27](concat)


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/practice/producer.kt&title=Practice 1. Functions. Producer
<!-- .slide: class="center" -->


---
@title[Agenda]
1. Checkstyle
1. Practice. Functions
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


---?code=lecture02/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/extension/pointExt.kt&title=`extension` declaration
<!-- .slide: class="center" -->

@[5](isZero extension)

@[7](`copy` method usage)


---
@title[Nullability]

class **String** produces two **Types**:
- @css[highlight](String) - is a *string*
- @css[highlight](String?) - is a *string* or *null*


---
@title[Nullability. Example]
<!-- .slide: class="center" -->

```kotlin
val s: String = "abc" // <-- legal
s = null // <-- not legal

val ns: String? = null // <-- legal
```

---
@title[Nullability. `?.`]

```kotlin
fun length(s: String?): Int? = s?.length
```

`s?.length` is 
`if(s != null) s.length else null`


---
@title[Nullability. `?:`]

```kotlin
val foo: Int?

val bar: Int = foo ?: 42
```

`foo ?: 42` is 
`if(foo != null) foo else 42`


---
@title[Nullability. `!!`]

```kotlin
val foo: String?

val bar: Int = foo!!.length
```

`!!` stands for I KNOW WHAT I'M DOING


---
@title[Agenda]
1. Checkstyle
1. Practice. Functions
1. Classes and Types
1. @css[highlight](Assignment 2)


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
