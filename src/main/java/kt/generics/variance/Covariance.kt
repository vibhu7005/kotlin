package kt.generics.variance

fun main() {
    val list: List<Float> = listOf(1f, 4f)
    convertToInt(list)
    val flowerGarden = Garden<Flower>(Flower())
    val roseGarden = Garden<Rose>(Rose())
   // waterGarden(flowerGarden)
    waterGarden(roseGarden)
}

fun convertToInt(list: List<Number>) {
    for (element in list) {
        println(element.toInt())
    }
}

fun <T  : Flower>waterGarden(garden : Garden<out T>) {
    println("watering garden")
}

open class Flower {}

private class Rose : Flower()

class Garden<T : Flower>(private val flower : T) {
    private fun addFlower(flower : T) {

    }
}






