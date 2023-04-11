package inheritance

fun main() {
    val bird = RedEagle()
    bird.eat()
    bird.fly()
    bird.walk()
}

open class Something(val x : Int) {
    var someProperty : String = "default"
    constructor(prop : String, y : Int) : this(y) {
        someProperty = prop
    }
}

class SomethingElse : Something {
    constructor(someOtherProperty : String, x : Int) : super(someOtherProperty, x)
}