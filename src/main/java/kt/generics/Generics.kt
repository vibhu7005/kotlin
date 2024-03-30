package kt.generics

import java.math.BigDecimal



//extension function for all non null list
fun <T : Any> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}

fun <T : Number> List<T>.convertToInt() {
    for (item in this) {
        println(item.toInt())
    }
}

fun <T> appendAll(string1: T, string2: T): String where T : CharSequence, T : Appendable {
    val s = string2.append(string1)
    return s.toString()
}

class Rest<T> {
    fun perform(obj : T) {

    }
}

fun main() {
    val k = Rest<Int>()
}

fun<E> timelineOf(vararg x : E) {

}