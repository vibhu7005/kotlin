package kt.iokotlin

import java.io.File

fun main() {
    val xt = null
    xt ?: println("hello")
    File(".").walkBottomUp().forEach { println(it) }
}