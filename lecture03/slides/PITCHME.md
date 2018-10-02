---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 3
#### OOP & friends


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
git checkout -b lecture03 upstream/lecture03
cd lecture03
```

open as new project


---
@title[Agenda]
1. @css[highlight](Classes and Types #2)
1. Practice. Encoding
1. Collections


---
@title[Varargs]

```kotlin
/**
 * Returns a new read-only list of given elements.  The returned list is serializable (JVM).
 * @sample samples.collections.Collections.Lists.readOnlyList
 */
fun <T> listOf(vararg elements: T): List<T> = 
    if (elements.size > 0) elements.asList() 
    else emptyList()

// ...

val list = listOf(1, 2, 3, 4)

// ...

fun main(args: Array<String>) {
    val list = listOf(*args)
}
```


---
@title[Enum]

```kotlin
enum class Color(
        val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), 
    YELLOW(255, 255, 0), 
    GREEN(0, 255, 0), 
    BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b
}
```

---
@title[Enum. When]
```kotlin
fun isSimple(): Boolean = when(color) {
    RED, GREEN, BLUE -> true
    else -> false
}
```


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/infix.kt&title=infix function
@[3](`val result = 16 mutliply 7`)


---?code=lecture03/src/test/kotlin/io/rybalkinsd/kotlinbootcamp/InfixTest.kt&title=infix function usage 
@[8-11](old-style call)
@[13-16](pure infix call)


---
@title[Pair]
```kotlin
val pair: Pair<String, Int > = "key" to 12

val mapping: Pair<Double, Any?> = 7.2 to null
```


---
@title[Inheritance & polymorphism]

```kotlin
open class Parent {
    open fun foo() = "parent"  
}

class Successor: Parent() {
    override fun foo() = "successor"
} 
```

#### Sea also `abstract`, `final` modifiers 


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/companion.kt&title=Companion object
@[8-10](Companion object declaration)
@[5,6](Usage inside class scope)
@[13-15](Usage outside class scope)
@[6](using value right inside string `$log`)


---
@title[Equality]

@css[highlight](`==`) is the default way to compare two objects: it compares their values by 
calling @css[highlight](`equals`).

You can use @css[highlight](`===`) for reference comparision


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/comparator.kt&title=Singleton
@[3-5]()
@[7-10]()


---?code=lecture03/src/test/kotlin/io/rybalkinsd/kotlinbootcamp/ComparatorTest.kt&title=Singleton usage
@[7-14]()
@[11-13](`fun <T> T.also(block: (T) -> Unit): T`)


---?code=lecture03/src/src/kotlin/io/rybalkinsd/kotlinbootcamp/anonymous.kt&title=Anonymous class
@[3-8]()
@[10]()
@[13-21]()


---
@title[Agenda]
1. Classes and Types #2
1. @css[highlight](Practice. Encoding)
1. Collections


---
@title[Practice. Encoding]
![](lecture03/slides/assets/images/alpha.png)

Implement functions in `io.rybalkinsd.kotlinbootcamp.practice.encoding.kt`

Fix all tests in `io.rybalkinsd.kotlinbootcamp.practice.EncodingTest.kt`


---
@title[Agenda]
1. Classes and Types #2
1. Practice. Encoding
1. @css[highlight](Collections)


---
@title[Collections]
<!-- .slide: class="center" -->

Collections in Kotlin are the same classes as in Java, but with an extended API


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
