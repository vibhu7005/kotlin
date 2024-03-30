package kt.kotlinobject

fun main() {
    println(Singleton.getMessage())
    println(Singleton.getMessage())
    println(Singleton.getMessage())
    Singleton.getMessage()
    Singleton.getMessage()
    Singleton.getNoOfInvokations()
}

object Singleton {
    fun getMessage() = "Object class is a singleton in kotlin"
    private var count = 0
    init {
        count++
    }
    fun getNoOfInvokations() = println("${javaClass.name} is initialized $count times")
}