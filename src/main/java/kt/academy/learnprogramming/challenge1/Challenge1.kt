package academy.learnprogramming.challenge1

import java.util.*

fun main(args: Array<String>) {
    val hello1 = "hello"
    val hello2 = "hello"
    println(hello2 === hello1)
    println(hello2 == hello1)
    var num = 2988
    val x: Any = "The Any type is root of kotlin class hierarchy"
    println((x as String).uppercase())
    println("""    1
          |   11
          |  111
          | 1111""".trimMargin()
    )
}