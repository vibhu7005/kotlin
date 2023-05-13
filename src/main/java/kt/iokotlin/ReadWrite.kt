package kt.iokotlin

import java.io.File

fun main() {
    //don't use readlines for huge files
    val lines = File("src/TestFile.txt").reader().readText().lines()
    for (line in lines) println(line)
    println()
    val allLines = File("src/TestFile.txt").bufferedReader().use { it.readText() }
    println(allLines)
    println()
    File("src/TestFile.txt").reader().forEachLine { println(it) }
    println()
    File("src/TestFile.txt").reader().useLines { it.forEach { println(it)} }
}