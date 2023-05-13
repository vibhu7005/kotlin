package kt.iokotlin

import java.io.File

fun main() {
    File(".").walkBottomUp().forEach { println(it) }
}