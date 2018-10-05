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
1. Practice. Data analysis


---
@title[Varargs]
<!-- .slide: class="center" -->
```kotlin
/**
 * Returns a new read-only list of given elements.  
 * The returned list is serializable (JVM).
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
<!-- .slide: class="center" -->
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
<!-- .slide: class="center" -->
```kotlin
fun isSimple(): Boolean = when(color) {
    RED, GREEN, BLUE -> true
    else -> false
}
```


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/infix.kt&title=infix function
@[3](`val result = 16 multiply 7`)


---?code=lecture03/src/test/kotlin/io/rybalkinsd/kotlinbootcamp/InfixTest.kt&title=infix function usage 
@[8-11](old-style call)
@[13-16](pure infix call)


---
@title[Pair]
<!-- .slide: class="center" -->
```kotlin
val pair: Pair<String, Int > = "key" to 12

val mapping: Pair<Double, Any?> = 7.2 to null

```


---
@title[Inheritance & polymorphism]
<!-- .slide: class="center" -->

```kotlin
open class Parent {
    open fun foo() = "parent"  
}

class Successor: Parent() {
    override fun foo() = "successor"
} 
```

See also `abstract` & `final` modifiers 


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/companion.kt&title=Companion object
@[8-10](Companion object declaration)
@[5,6](Usage inside class scope)
@[13-15](Usage outside of class scope)
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


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/anonymous.kt&title=Anonymous class
@[3-8]()
@[10]()
@[13-21]()


---
@title[Agenda]
1. Classes and Types #2
1. @css[highlight](Practice. Encoding)
1. Collections
1. Practice. Data analysis


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
1. Practice. Data analysis


---
@title[Collections]
<!-- .slide: class="center" -->
  
Collections in Kotlin are the same classes as in Java, but with an extended API

---

@title[Kotlin Collections hierarchy] 
SEE kotlin.collections.Collections.kt
![Collections hierarchy](lecture03/slides/assets/images/language-design-tradeoffs-kotlin-and-beyond-by-andrey-breslav-21-638.jpg)

---
@title[Mutable/Immutable collections]
Unlike many languages, Kotlin distinguishes between **mutable** and **immutable** collections (lists, sets, maps, etc)  
You can see how kotlin collections hierarchy differs from java's here  
  
Immutable collections is just a compile-time feature. It is delegated to standard mutable Java collections inside.

---
@title[Collections examples]
SEE io.rybalkinsd.kotlinbootcamp.practice.CollectionsTest


---
@title[ArrayList]
Backed by java ArrayList  
[Read about java ArrayList (RU)](https://habrahabr.ru/post/128269/)

---
@title[ArrayList. Internals #1]

```kotlin
val list = ArrayList<Int>()
```
![new array](lecture03/slides/assets/images/newarray.png)


```kotlin
list.add("0");
list.add("1");
```

![array1](lecture03/slides/assets/images/array1.png)

---
@title[ArrayList. Internals #2]
```kotlin
list.addAll(listOf("2", "3", "4", "5", "6", "7", "8"))
list.add("9")
```

![array9](lecture03/slides/assets/images/array9.png)


---
@title[ArrayList. Internals #3]
```kotlin
list.add("10")
```
Not enough capacity. Need (auto)resize.

![arrayresized](lecture03/slides/assets/images/arrayresized.png)
![array10](lecture03/slides/assets/images/array10.png)

---
@title[Quiz]
#### What is the difference between capacity and size in `ArrayList`?

---
@title[ArrayList. Complexity]

|  contains  | add   | get   |  set  | remove | 
|:----------:|:-----:|:-----:|:-----:|:------:|
| O(n)       | O(1)* |  O(1) |  O(1) | O(n)   |


---
@title[Java Lists]
JDK contains a lot of List implementations (mutable):
- ArrayList
- CopyOnWriteArrayList - thread-safe variant of ArrayList
- LinkedList
- Vector - synchronized list
- ...

---
@title[LinkedList. Summary #1]
- Double-linked list implementation of the **List** and **Deque**
interfaces.


---
@title[LinkedList. Summary #2]
- Providing interfaces
    - List
    - Deque
    - Queue
    - Serializable 
    - Cloneable
    - Iterable 
    - Collection


---
@title[LinkedList internals #1]
```kotlin
val list = LinkedList<String>()
```
![linkednew](lecture03/slides/assets/images/linkednew.png)


---
@title[LinkedList internals #2]
```kotlin
list.add("0");
```

Allocation
![linked0](lecture03/slides/assets/images/linked0.png)

---
@title[LinkedList internals #3]
Linking

![linked0linked](lecture03/slides/assets/images/linked0linked.png)


---
@title[LinkedList internals #4]
```kotlin
list.add("1");
```

Allocation

![linked1](lecture03/slides/assets/images/linked1.png)

---
@title[LinkedList internals #5]
Linking

![linked1linked](lecture03/slides/assets/images/linked1linked.png)



---
@title[LinkedList. Complexity]

|  contains  | add   | get   |  set  | remove | 
|:----------:|:-----:|:-----:|:-----:|:------:|
| O(n)       | O(1)  |  O(n) |  O(n) | O(n)   |



---
@title[Interface Set]
-  A collection that contains no duplicate elements.  More formally, sets
   contain no pair of elements **e1** and **e2** such that
    ```kotlin
       e1 == e2
    ```
    
- Implementations
    - HashSet 
    - TreeSet
    - EnumSet 
    - ConcurrentSkipListSet 
    - CopyOnWriteArraySet 
    - LinkedHashSet
    - ...


---
@title[HashSet]
Set interface implementation, backed by a hash table (actually a HashMap instance).
It makes no guarantees as to the iteration order of the set.


---
@title[HashSet. Internals]
![hashset](lecture03/slides/assets/images/hashset.png)


---
@title[General contract]
For objects **a** and **b**:
(a == b) => a.hashCode() === b.hashCode()

if a.hashCode() == b.hashCode()  
          not necessary (a == b)
          
a.hashcode() is the same during object lifetime


---
@title[HashSet. Complexity]

|  contains  | add   | get   | remove | 
|:----------:|:-----:|:-----:|:------:|
| O(1)       | O(1)  |  O(1) |  O(1)  |


---
@title[TreeSet]
The elements are ordered using their **Comparable** natural 
ordering, or by **Comparator** provided at set creation time, 
depending on which constructor is used.


---
@title[TreeSet. Internals]
![treeset](lecture03/slides/assets/images/treeset.png)

[Read more (RU)](https://habrahabr.ru/post/65617/)

---
@title[Functional interface Comparable<T>]
```kotlin
public operator fun compareTo(other: T): Int
```


---
@title[compareTo and ==]
Any type of contract?
```kotlin
(a == b) => a.compareTo(b) == 0
``` 

What about null?


---
@title[HashSet. Complexity]

|  contains  | add   | get   | remove | 
|:----------:|:-----:|:-----:|:------:|
| O(log(n))       | O(log(n))  |  O(log(n)) | O(log(n))  |


---
@title[Map]

```kotlin
interface Map<K, V>
``` 

An object that maps keys to values.
Cannot contain duplicate keys.
Each key map to at most one value.

---
@title[Why, Map?]
Why Map is not a Collection?

---
@title[Why, Map?]
From official java FAQ:
> This was by design.
> We feel that mappings are not collections and collections are not mappings. 
> If a Map is a Collection, what are the elements? 


---
@title[Map implementations]
- HashMap
- TreeMap
- LinkedHashMap
- EnumMap


---
@title[Notes]
1. HashSet is limited version of HashMap
1. TreeSet is limited version of TreeMap 


---
@title[Complexity]
HashMap

|  containsKey  | get   | put   | remove | 
|:----------:|:-----:|:-----:|:------:|
| O(1)       | O(1)  |  O(1) | O(1)  |


TreeMap

|  containsKey  | get   | put   | remove |
|:----------:|:-----:|:-----:|:------:|
| O(log(n))       | O(log(n))  |  O(log(n)) | O(log(n))  |

[Read more](http://infotechgems.blogspot.ru/2011/11/java-collections-performance-time.html)


---
@title[HashMap. Internals] 
![hashmap](lecture03/slides/assets/images/hashmap.png)

---
@title[Sequence]
Kotlin collections are **eager**.  
To make them lazy - use **asSequence()**  
SEE io.rybalkinsd.kotlinbootcamp.practice.CollectionsTest.sequences


---
@title[Agenda]
1. Classes and Types #2
1. Practice. Encoding
1. Collections
1. @css[highlight](Practice. Data analysis)


---
@title[Nullability. `?.Extensions`]
<!-- .slide: class="center" -->
```kotlin
fun String?.isNullOrBlank(): Boolean = 
        this == null || this.isBlank() 
```

---
@title[Nullability. `let`]
<!-- .slide: class="center" -->
```kotlin
fun T.let(block: (T) -> R): R { ... }


val user: User?


user?.let {
    AutorizationUtil.autorize(it)
}
```

if `user != null` invoke lambda block

else do nothing


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/casting.kt&title=Casting. `as` and `as?` operators


---
@title[Practice. Data analysis]
Solve all tasks in `io.rybalkinsd.kotlinbootcamp.practice.DataAnalysis.kt`

Fix tests and add more in `io.rybalkinsd.kotlinbootcamp.practice.DataAnalysisTest.kt`


---?code=lecture03/src/main/kotlin/io/rybalkinsd/kotlinbootcamp/practice/DataAnalysis.kt&title=Practice. Data analysis
@[3](we have a lot of raw data)
@[40-55](here it is)
@[19-23](Task #1)
@[25-29](Task #2)
@[32-37](Task #3)


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
