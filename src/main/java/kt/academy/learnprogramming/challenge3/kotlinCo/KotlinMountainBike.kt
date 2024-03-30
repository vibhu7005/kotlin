package kt.academy.learnprogramming.challenge3.kotlinCo

class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 12) :
    KotlinBicycle(cadence, speed, gear) {

    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10) : this(
        seatHeight,
        cadence,
        speed
    ) {
        println("Bike color is $color")
    }

    override fun printDesc() {
        super.printDesc()
        println("Bike has a seat height of $seatHeight cm")
    }

    companion object {
        val availableColors = listOf("Blue", "Red", "White", "Black", "Green", "Brown")
    }
}