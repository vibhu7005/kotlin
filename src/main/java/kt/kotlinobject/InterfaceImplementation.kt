package kt.kotlinobject

fun main() {
    InterfaceImplementation().requireInterface(object : InterfaceImplementation.Foo{
        override fun operate(num: Int) {
            println(num + 1)
        }
    })
}

class InterfaceImplementation {
    fun requireInterface(foo : Foo) {
        foo.operate(30)
    }


    interface Foo {
        fun operate (num : Int)
    }
}