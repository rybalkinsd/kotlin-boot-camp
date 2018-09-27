package io.rybalkinsd.kotlinbootcamp.basics

val number: Int = 42

val list: List<Int> = listOf(1, 2, 3, 4)

val array: Array<Int> = arrayOf(1, 2, 3, 4)

fun modifyVariable(): String {
    var modifiable = "before"
    modifiable = "after"
    return modifiable
}
