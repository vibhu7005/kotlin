package kt.academy.learnprogramming.challenge3.kotlinCo

import kt.academy.learnprogramming.challenge3.Bicycle

class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 15) : KotlinBicycle(cadence, speed, gear) {

    override fun printDesc() {
        super.printDesc()
        println("Bike has a tire width of $tireWidth mm")
    }


}