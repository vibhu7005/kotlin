@file:JvmName("StaticCar")

package kt.interoperability.kotlinFromJava

import java.io.IOException

fun topLevel() = println("top level funtion called")

fun String.printIt() {
    println(this.uppercase())
}

class Car(color: String, val model: String, val year: Int) {
    object Singelton {
        @JvmField
        val isAuto = false

        @JvmStatic
        fun res() {
            println("hello")
        }
    }

    var color: String
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

    //    fun printMe(str : String) {
//        println("I don't expect null value")
//    }
    @Throws(IOException::class)
    fun doIo() {
        throw IOException()
    }

    @JvmOverloads fun defaultArgs(str : String, str2 : String = "lol") {
        println("default args called")
    }

}