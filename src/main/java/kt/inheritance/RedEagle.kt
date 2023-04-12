package inheritance

class RedEagle : Eagle() {
    init {
        println("red eagle initialized")
    }
    override fun fly() = println("red eagle flying")

    override fun eat() = println("red eagle eating")
}