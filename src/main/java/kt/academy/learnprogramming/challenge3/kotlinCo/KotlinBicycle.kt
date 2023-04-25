package kt.academy.learnprogramming.challenge3.kotlinCo

fun main() {
//    val bicycle = KotlinBicycle(10, 34)
//    bicycle.printDesc()
//
//    val roadBike = KotlinRoadBike(23, 12,56, 8)
//    roadBike.printDesc()
//
//    val mountainBike = KotlinMountainBike(43, 22,45, 23)
//    mountainBike.printDesc()

    val mountainBike2 = KotlinMountainBike("blue",12,3,4)
    mountainBike2.printDesc()
    println("Available Colors for mountain Bike are ")
    for (color in KotlinMountainBike.availableColors) {
        print("$color ")
    }
}
open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {
    fun applyBrakes(decrement : Int) {
        speed -= decrement
    }

    fun speedUp(increment : Int) {
        speed += increment
    }

    open fun printDesc() {
        println("""Bike is in gear $gear
            |with a cadence of $cadence
            |travelling at a speed of $speed
            """.trimMargin())
    }
}
