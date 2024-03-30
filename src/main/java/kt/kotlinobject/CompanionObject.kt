package kt.kotlinobject

fun main() {
    Random.initialize()
}
class Random {
    private constructor()
    companion object {
        private var x = 0
        private var random = Random()
        fun initialize() : Random{
            if (random == null) {
                random = Random()
            }
            return random
        }
        fun increment() {
            x++
        }
        fun printValue() {
            println(x)
        }
    }

}