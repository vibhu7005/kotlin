package kt.academy.learnprogramming.challenge4

import kotlin.coroutines.coroutineContext

fun main() {
//    for (num in 5..5000 step(5)) println(num)
//    println()
//    var a = 0
//    var b = 1
//    println(a)
//    println(b)
//    for (num in 0..12) {
//        val c = a + b
//        println(c)
//        a = b
//        b = c
//    }

    for (i in 1..5) {
        println(i)
        if (i == 2) break
        jLoop@ for (j in 11..20) {
            println(j)
            for (k in 100 downTo 20) {
                if (k < 98) {
                  break@jLoop
                }
                println(k)
            }
        }
    }
    println()

    val num = 56
    val dnum = when {
        num == 100 -> 0.0
        num < 100 -> 4444.555
        else -> -234.567
    }
}