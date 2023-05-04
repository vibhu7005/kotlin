package kt.generics

import java.math.BigDecimal

fun main() {
    val stringList = listOf("abc", "xyz")
    stringList.printCollection()
    val bdList = listOf(BigDecimal(34), BigDecimal(32))
    bdList.printCollection()
}

//extension function
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}