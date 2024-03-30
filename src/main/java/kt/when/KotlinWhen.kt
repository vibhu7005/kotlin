package kt.`when`

fun main() {
    val num = 90
    val x = when (num) {
        in 20..23 -> {
            println("20..23")
            10
        }
        in 20..30 -> {
            println("20..30")
            20
        }
        in 25..30 -> {
            println("25..30")
            30
        }
        else -> 50
    }
    println(x)
}