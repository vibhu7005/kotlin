package kt.designPatterns

open class Equipment(open val price: Int)

open class Composite : Equipment(0) {
    val list = mutableListOf<Equipment>()

    fun add(equipment: Equipment) = apply {
        list.add(equipment)
    }

    override val price: Int
        get() = list.sumOf { it.price }
}


fun main() {
    class Car : Composite()
    class Frame : Composite()
    class Engine : Equipment(50)
    class CarBody : Equipment(5)
    class CarAccessory : Equipment(6)

    val frame = Frame().add(CarBody())
            .add(CarAccessory())
    val car = Car().add(frame)
            .add(Engine())
//    println(car.price)
//    val obj = A().B()
//    obj.foos()

}


//class A {
//    private fun foo() {
//        println("foo1")
//    }
//
//    inner class B {
//        fun foos() {
//            println("foo2")
//            this@A.foo()
//        }
//    }
//
//
//}

