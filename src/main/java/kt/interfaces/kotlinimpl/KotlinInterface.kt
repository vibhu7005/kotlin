package kt.interfaces.kotlinimpl

fun main() {
    KotlinClient().print()
    KotlinClient().num1 = 26
    KotlinClient().print()
}
class KotlinClient : SubInterface {
    override var num1: Int = 0
    override fun print() {
        println(num1)
    }

    override fun foo(): String = "jordiee"
}

interface SubInterface : KotlinInterface {
    var num1 : Int
    val num2 : Int
    get() = 20
    fun print()
}

interface KotlinInterface {
    fun foo(): String
}