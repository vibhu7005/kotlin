package kt.designPatterns

object NetworkDriver {
    init {
        println("hello $this")
    }
    fun show() = apply { println("network : $this") }
}

fun main() {
    val networkDriver1 = NetworkDriver.show()
    val networkDriver2 = NetworkDriver.show()
}