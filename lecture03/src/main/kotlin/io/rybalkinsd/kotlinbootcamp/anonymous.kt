package io.rybalkinsd.kotlinbootcamp

class MouseEvent

interface MouseListener {
    fun onLeftButtonClick(e: MouseEvent)
    fun onRightButtonClick(e: MouseEvent)
}

val listeners = mutableListOf<MouseListener>()

fun usage() {
    listeners.add(object : MouseListener {
        override fun onLeftButtonClick(e: MouseEvent) {
            println(e)
        }

        override fun onRightButtonClick(e: MouseEvent) {
            println(e)
        }
    })
}
