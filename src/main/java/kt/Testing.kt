package kt

interface Flyable

fun main() {
    val x : MutableList<Int> = mutableListOf(2,3)


    for (i in 0..x.size - 1) {
        x.removeAt(i)
        x.add(i, 50)
    }



}

class A (vararg  x :Int) {

}

class Art(vararg x : Any) {

}