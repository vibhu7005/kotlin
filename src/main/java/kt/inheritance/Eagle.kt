package inheritance

open class Eagle : Bird {
    constructor() : super("fdf","45")
    init {
        println("Eagle initialized")
    }
    override fun fly() {
       println("eagle flying")
    }

    override fun eat() {
        println("eagle eating")
    }

   final override fun walk() = println("eagle walking")
}

