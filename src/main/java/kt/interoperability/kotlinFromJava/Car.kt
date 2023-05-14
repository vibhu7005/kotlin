@file:JvmName("StaticCar")
package kt.interoperability.kotlinFromJava

fun topLevel() = println("top level funtion called")

fun String.printIt() {
    println(this.uppercase())
}

class Car(color: String, val model: String, val year: Int) {
    object Singelton {
        @JvmStatic
        fun res() {
            println("hello")
        }
    }
    var color :String
        get() {
            return "defaultBlue"
        }
        set(value) {
            color = "defaultBrown"
        }
    fun ride() = println("driving car")

    companion object {
        @JvmField
        var doorCount = 4
        @JvmStatic
        fun getDoorCount() = 4
    }
}