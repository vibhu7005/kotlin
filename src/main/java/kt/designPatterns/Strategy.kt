package kt.designPatterns


open class Car(val driveStrategy: DriveStrategy) {
    fun drive() {
        driveStrategy.drive()
    }
}

class SportsCar() : Car(SportsDriveStrategy())


fun main() {
    SportsCar().drive()
}
interface DriveStrategy {
    fun drive()
}

class NormalDriveStrategy : DriveStrategy {
    override fun drive() {
        println("normal car driving")
    }
}

class SportsDriveStrategy : DriveStrategy {
    override fun drive() {
        println("sports car driving")
    }
}
