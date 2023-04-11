package functions

import dataclas.Bag

fun main() {
    println(labelMultiply(3,4,"the product is"))
    val bag1 = Bag("re",189,"skybags")
    val bag2 = Bag("mast", 890, "manhatten")
    val bag3 = Bag("io", 780, "Lapi")
    val bagsArray = arrayOf(bag1, bag2, bag3)
    val bags = arrayOf(*bagsArray, bag2, bag3)
    printInfo(*bags)
}

fun labelMultiply (operand1 : Int , operand2 : Int, expression :String) = "$expression = ${operand1 * operand2}"
fun foo() : Unit = println("hello")
//public and final by default

fun printInfo (vararg bags : Bag) { for (bag in bags) println(bag)}





