import kotlin.reflect.typeOf

class Demo {
    val df : Int = 56


}

fun calc() {
    var x = 34;
    Thread {
        x++
    }
}

abstract class Hulk {
    abstract fun open()
}

open class Animal {
    fun eat() = println("eating")
}
class Dog : Animal() {
    fun bark() = println("barking")
}

enum class Levels {
    _1,_2,_3,_4
}



fun main(args: Array<String>) {
    var a = 256
    var d : Byte = a.toByte()
    println(d)
    val animal : Animal = Dog()
    animal.eat()
}

enum class Stataus {
    Completed, pending, done
}