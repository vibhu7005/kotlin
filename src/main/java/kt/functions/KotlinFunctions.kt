package functions

import dataclas.Bag
import java.io.FileReader

fun main() {
    val fileReader = FileReader("example.txt")

}

fun labelMultiply (operand1 : Int , operand2 : Int, expression :String) = "$expression = ${operand1 * operand2}"
fun foo() : Unit = println("hello")
//public and final by default

fun printInfo (vararg bags : Bag) { for (bag in bags) println(bag)}





