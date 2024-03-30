package kt.interoperability.javaFromKotlin

fun main() {
    val car = Car("Ford", "Blue", 2015)
    car.name = "benz"
    var model: String? = car.name
    println(model?.javaClass)
    model = null
    println(model)
    println(car)


    //platformType
    val modelCar = car.name
    val task = Thread {
        println("hello I am running from inside thread")
    }
    car.provideVariableArgs("hello", "raman","sudeep")
    val strings = arrayOf("hey", "sam", "ko")
    car.provideVariableArgs(*strings)
    car.requirePrimitiveArray(intArrayOf(1,2,3))
    val sem : Any = "njnj"
    //only equals and hashcode are there for now
    car.requiresObject(sem)
    car.requireRunnable{ println("running from a thread") }
    println(++Car.x)
    calc { i, i2 ->  (i + i2) * (i - i2)}
}


fun calc(exp : (Int, Int) -> Int) {
    println(exp(3,4) + exp(4,5))
}
