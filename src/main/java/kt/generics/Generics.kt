package kt.generics

import java.math.BigDecimal

fun main() {
    val stringList = listOf("abc", "xyz")
    stringList.printCollection()
    val bdList = listOf(BigDecimal(34), BigDecimal(32))
    val nullList = listOf(null, null)
    val nonNullList = listOfNotNull(3, 4, null, 3, 2)
    nonNullList.printCollection()
    val floatList = listOf(23f, 45f, 32f)
    floatList.convertToInt()
    val doubleList = listOf(34.0, 34.5)
    doubleList.convertToInt()
    println(appendAll(StringBuilder("df"), StringBuilder("dfdf")))
    val list: MutableList<String> = mutableListOf("dsd", "sdfdd")
    println(list is List<String>)
}

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