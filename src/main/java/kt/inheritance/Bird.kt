package inheritance

abstract class Bird(val name : String) {
    init {
        println("Bird initialized")
    }
    constructor(weight : String, name : String) : this(name) {
        println ("Bird weight = $weight")
    }
    open fun fly() = println("bird flying")

    open fun eat() = println("bird eating")

    abstract fun walk()
}