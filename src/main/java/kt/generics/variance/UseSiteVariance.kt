package kt.generics.variance

open class Car
class Ford : Car()
//Java supports useSite variance only whereas kotlin supports both useSite + declaration site variance
fun main() {
    val fordCarsList = mutableListOf(Ford(), Ford())
    serviceCars(fordCarsList)
    val carsList = mutableListOf(Car(),Car())
    serviceFordCars(carsList)
}

//use site variance
fun serviceCars(carsList: MutableList<out Car>) {
    for (i in 1..carsList.size) {
        println("service completed for car $i")
    }
}

fun serviceFordCars(carsList: MutableList<in Ford>) {
    for (i in 1..carsList.size) {
        println("service completed for car $i")
    }
}