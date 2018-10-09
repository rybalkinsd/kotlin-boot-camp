---
<!-- .slide: class="center" -->
@title[Kotlin]

### Lecture 4
#### Kotlin web


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
git checkout -b lecture05 upstream/lecture05
cd lecture05
```

open as new project


---
@title[Agenda]
1. @css[highlight](From functions to DSL)
1. Http Client Practice
1. Http Server Practice


---
@title[Ultimate goal]
<!-- .slide: class="center" -->

Best possible code readability and maintainability


---
@title[Tool. Extension function]

Now:
```kotlin
s.capitalize()
```

Before:
```java
StringUtil.capitalize(s);
```


---
@title[Tool. Infix function]

Now:
```kotlin
 "kotlin" to "the rescue"
```

Before:
```kotlin
"kotlin".to("the rescue")
```


---
@title[Tool. Operator overloading]

Now:
```kotlin
list += 42
```

Before:
```kotlin
list.add(42)
```


---
@title[Tool. Convention `get`]

Now:
```kotlin
map["key"]
```

Before:
```kotlin
map.get("key")
```


---
@title[Tool. Lambda outside of parenthesis]

Now:
```kotlin
list.filter { it > 0 }
    .map { it * it }

```

Before:
```kotlin
list.filter({ e -> e > 0 })
    .map({ e -> e * e })
```

In the parallel universe:
```java
list.stream()
    .filter(e -> e > 0)
    .map(e -> e * e)
    .collect(Collectors.toList());
```


---
@title[Tool. `with` receiver]

Now:
```kotlin
with(sb) {
    append("first line")
    append("second line")
    append("third line")
}
```

Before:
```kotlin
sb.append("first line")
sb.append("second line")
sb.append("third line")
```


---
@title[Apply]

```kotlin
public inline fun <T> T.apply(block: T.() -> Unit): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
    return this
}
```

See `io.rybalkinsd.kotlinbootcamp.apply.kt` and 

`io.rybalkinsd.kotlinbootcamp.ApplyTest.kt`


---
@title[Kohttp]
[Kohttp](https://github.com/rybalkinsd/kohttp) - DSL-based http client

<img src="lecture05/slides/assets/images/kohttp.png" alt="kohttp" align="center"/>  


---?code=lecture05/build.gradle.kts&title=kohttp dependency
@[28,31,41](kohttp:0.3.1)


---
@title[Agenda]
1. From functions to DSL
1. @css[highlight](Http Client Practice)
1. Http Server Practice


---?code=lecture05/build.gradle.kts&title=Logger
@[28,32,41](kohttp:0.3.1)


---?code=lecture05/main/kotlin/io/rybalkinsd/kotlinbootcamp/util/util.kt&title=Logger


---?code=lecture05/test/kotlin/io/rybalkinsd/kotlinbootcamp/practice/HttpClient.kt&title=Logger
@[13,14,19,20](Declaration in companion object)


---
@title[That's all for today]

Please leave your @css[highlight](feedback).
 
*Offline students will get the link via email*
