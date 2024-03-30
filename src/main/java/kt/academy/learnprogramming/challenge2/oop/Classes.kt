package kt.academy.learnprogramming.challenge2.oop

fun main() {
    val e = Being(true, false)
   val an = Animal.Farma
    an.value

//    val p1 = Person("baa", 23)
//    val p2 = Person("baa", 23)
//    println(p1 == p2)
////    p1.component1()
//    val (name, age) = p1
//    println("$name $age")
//    val maa = Ama.MAA()
//    breathe(object : Breathe {
//        override fun breathin() {
//            TODO("Not yet implemented")
//        }
//
//        override fun breatheOut() {
//            TODO("Not yet implemented")
//        }
//    })
    val list : MutableList<Int>? = mutableListOf()
    val s = list?.also {
        it.add(4)
        it.add(4)
    }
    println(s)

    val x = list.apply {
        this?.add(4)
        this?.add(5)
    }
    println(x)

}

open class Animal(open val eat : String) {
    lateinit var  pi : String

     object Farma {
        var value : Int = 2
        fun modifyVal(y : Int) {
            value = y
        }
    }

    open fun drink() {
        val x = listOf(1,"lol")
        pi = "kk"
        println("drink")
    }
}

class Dog(override val eat : String, val bark : String) : Animal(eat) {
    override fun drink() {
        pi = "lkjk"
    }
}




interface A {
    val x : Int

    fun implA() {
        println("A");
    }
}

class Ama {
    val x = 4

    class MAA {
        val y = 6
    }
}

sealed class SMS {
    data class Phone(val name: String)
    data class WhatsApp(val name: String)
}


fun handleResult(result: SMS) {
}

interface B : A {
    override fun implA() {
        println("B")
    }
}

interface C : A {
    override fun implA() {
        println("C")
    }
}




abstract class Dorm(val perp : String)
abstract class Dorms(val perp : String)


interface Dive {
    fun foo() {

    }
    fun getExp() : Int
}

fun breathe(breathe : Breathe) {
    breathe.breathin()
    breathe.breatheOut()
}

interface Breathe {
    fun breathin()
    fun breatheOut()
}

class Being constructor(val isLiving : Boolean) {
    init {
        println("primaryConstructor")
    }
    constructor(isLiving : Boolean, isHuman : Boolean) : this(isLiving) {
        println("constructor")
    }
}

