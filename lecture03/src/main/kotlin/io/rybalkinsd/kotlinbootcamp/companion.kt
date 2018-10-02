package io.rybalkinsd.kotlinbootcamp

class Regular(val a: Int, val b: Int) {

    override fun toString(): String =
        "Regular class with logger: $log"

    companion object {
        val log: String = Regular::class.java.simpleName
    }
}

fun `usage outside of class scope`() {
    println(Regular.log)
}
