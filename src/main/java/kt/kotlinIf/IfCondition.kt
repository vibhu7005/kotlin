package kt.kotlinIf

fun main() {
    val condition = 45 < 23
    val x = if (condition) 23 else 45
    println(x.javaClass)
    val o = true
    println(o.javaClass)
    val k =
        if (condition) {
            println("something")
            true
        } else {
            println("something else")
        }
}