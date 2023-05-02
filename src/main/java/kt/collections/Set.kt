package kt.collections

fun main() {
    val setInts = mutableSetOf(1,2,3,4)
    setInts.add(34)
    println(setInts)
    setInts.plus(23)
    println(setInts)
    println(setInts.minus(34))
    println(setInts.drop(2))
    println(setInts)
}