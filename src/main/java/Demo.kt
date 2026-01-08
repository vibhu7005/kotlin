import kotlin.reflect.typeOf

class Demo {
    val df : Int = 56


}

open class Animal
class Dog : Animal()

fun main(args: Array<String>) {
    var a = 256
    var d : Byte = a.toByte()
    println(d)
    val animal : Animal = Dog();
    val lok  = 1000000000000
    val chad = 'a'
    val s : Int = chad.code
//    println(Char.MAX_HIGH_SURROGATE)
}