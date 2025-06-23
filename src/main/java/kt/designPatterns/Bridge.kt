package kt.designPatterns


interface  Vehicle {
     fun getHorsePower()
}


fun main() {
    val x : String = "aman"
    var a = 5
    var b = a++
    println(a + b)

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

val risk  = {x : Int -> x + 4}

fun bastard(x : (Int) -> Int)  {
     println(x.invoke(60))
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