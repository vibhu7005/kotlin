package kt.designPatterns

interface  Vehicle {
     fun getHorsePower()
}


fun main() {
    val x = CopassengerModel(1712899860000L, "a")
    val y = CopassengerModel(1712899980000L, "b")
    val z = CopassengerModel(1712896440000L, "c")
    val a = CopassengerModel(1712896440000L, "d")
    val list = listOf<CopassengerModel>(x, y, z , a)
    val sortedList = getSortedPassengerList(list, "Up")
    println(list)
    println(sortedList)
}

fun getSortedPassengerList(passengerList: List<CopassengerModel>, direction: String?): List<CopassengerModel> {
    return passengerList.sortedBy {
            it.pickupTime
    }
}

class Car : Vehicle {
    override fun getHorsePower() {
        println(100)
    }
}

class Truck : Vehicle {
    override fun getHorsePower() {
        println(200)
    }
}

abstract class Engine(vehicle: Vehicle) {
    abstract fun getMileage()
}

class PetrolEngine(vehicle: Vehicle) : Engine(vehicle) {
    override fun getMileage() {
        println(23)
    }
}


class DieselEngine(vehicle: Vehicle) : Engine(vehicle) {
    override fun getMileage() {
        println(23)
    }
}

abstract class BuildQuality (engine: Engine) {
    abstract fun globalNCapRating() : Int
}

class StrongBuild : BuildQuality(PetrolEngine(Truck())) {
    override fun globalNCapRating(): Int {
        TODO("Not yet implemented")
    }

}