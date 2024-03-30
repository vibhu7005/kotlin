package kt.collections

fun main() {
    val map = mapOf(1 to Caran("Maserati", 2001), 2 to Caran("BMW", 2019))
    println(map.plus(4 to Caran("df",34)))
    //way 1
    for (entry in map) {
        println(" ${entry.key} ${entry.value} ")
    }
    //using destructuring decalrations
    for ((k,v) in map) {
        println(" $k $v ")
    }
}