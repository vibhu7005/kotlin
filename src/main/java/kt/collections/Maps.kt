package kt.collections

import java.lang.Exception
import java.lang.NumberFormatException

fun main() {
    val map = mapOf(1 to Car("Maserati", 2001), 2 to Car("BMW", 2019))
    println(map)
    //way 1
    for (entry in map) {
        println(" ${entry.key} ${entry.value} ")
    }
    //using destructuring decalrations
    for ((k,v) in map) {
        println(" $k $v ")
    }
}