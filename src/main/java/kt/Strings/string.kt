package Strings

import declarations.Employee

fun main() {
    val e1 = Employee("sat", "sde", 34)
    println(e1)
    val numerator = 45
    val denominator = 34
    println("$numerator divided by $denominator is ${numerator/denominator}")
    println("the ${e1.name} id is ${e1.grade}")
    println("""the name is samarth
        2hellman
        2manhell
    """.trimMargin("2"))


}