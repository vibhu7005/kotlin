package kt.loops

fun main() {
    val range = 1..5
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"
    val reverseRange = 5.downTo(1)
    println(5 in reverseRange)
    println()
    println('r' in charRange)
    println()
    println("HHH" in stringRange)
    println()
    // for (i in range) println(i)
    val reversedRange = range.reversed()
    val stepRange = range.step(2)
    for (i in range) println(i)
    println()
    for (i in reversedRange) println(i)
    println()
    for (i in stepRange) println(i)
    println()
    for (i in "String") println(i)
    println()
    for (i in 1..20 step (4)) println(i)
    println()
    for (i in 5 downTo 1) println(i)

    for (i in 1 until 10) println(i)
    println()
    val seasons = arrayOf("summer", "winter", "rainy")
    for (season in seasons) println(season)
    println()
    for (index in seasons.indices) {
        println(seasons[index])
    }

    val check = "snow" !in seasons
    println(check)
    println()
    seasons.forEach { println(it) }
    println()
    seasons.forEachIndexed { index, value ->
        println("$value is at $index")
    }
    println()
    for (i in 1..5) {
        println(i)
        jLoop@ for (j in 5..10) {
            println(j)
            for (k in 10..15) {
                println(k)
                if (k == 13) {
                    break@jLoop
                }
            }
        }
    }

}