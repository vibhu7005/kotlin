package kt.generics
open class Flower(val name : String)

fun main() {
    val roseInterface = object : WateringFlower<Rose> {
        override fun waterFlowers(flower: Flower) {
            println("watering ${flower.name}")
        }
    }

    val flowerInterface = object : WateringFlower<Flower> {
        override fun waterFlowers(flower: Flower) {
            println("watering ${flower.name}")
        }
    }
    val roseGarden = Garden<Rose>(Rose(), flowerInterface)
    val lilyGarden = Garden<Lily>(Lily(), flowerInterface)

   // val roseGarden = Garden<Rose()>()
}
class Rose : Flower("Rose")
class Lily : Flower("Lily")

class Garden<T>(private val flower : Flower, private val wateringInterface : WateringFlower<T>) {
    fun doService() {
        wateringInterface.waterFlowers(flower)
    }
}

interface WateringFlower<in T> {
    fun waterFlowers(flower : Flower)
}
