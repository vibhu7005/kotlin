//package kt.designPatterns
//
//abstract class Vehicle {
//    abstract fun getHorsePower()
//}
//
//class Car : Vehicle() {
//    override fun getHorsePower() {
//        println(100)
//    }
//}
//
//class Truck : Vehicle() {
//    override fun getHorsePower() {
//        println(200)
//    }
//}
//
//abstract class Engine(vehicle: Vehicle) {
//    abstract fun getMileage()
//}
//
//class PetrolEngine(vehicle: Vehicle) : Engine(vehicle) {
//    override fun getMileage() {
//        println(23)
//    }
//}
//
//
//class DieselEngine(vehicle: Vehicle) : Engine(vehicle) {
//    override fun getMileage() {
//        println(23)
//    }
//}
//
//abstract class BuildQuality (engine: Engine) {
//    abstract fun globalNCapRating() : Int
//}
//
//class StrongBuild : BuildQuality(PetrolEngine(Truck())) {
//    override fun globalNCapRating(): Int {
//        TODO("Not yet implemented")
//    }
//
//}