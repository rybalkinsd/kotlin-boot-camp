package io.rybalkinsd.kotlinbootcamp

object ReversedIntComparator : Comparator<Int> {
    override fun compare(o1: Int, o2: Int): Int = o2 - o1
}

object CaseInsensitiveComparator : Comparator<String> {
    override fun compare(o1: String, o2: String): Int =
        o1.toLowerCase().compareTo(o2.toLowerCase())
}
