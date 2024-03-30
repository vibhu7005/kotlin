package dataclas

import kt.arrays.printktx

fun main() {
    val bag = Bag("Red", 100, "Skybags")
    val bag2 = bag.copy()
    println(bag == bag2)
    println(bag === bag2)
}