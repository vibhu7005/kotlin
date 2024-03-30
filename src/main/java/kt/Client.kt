import kt.enum.Department
import kotlin.properties.Delegates

class A {
    var x by Delegates.notNull<Boolean>()
}
fun main() {
    val s = A()
    s.x = false
    println(s)
}

open class M {
    fun doo() {
        println("lol")
    }
}

