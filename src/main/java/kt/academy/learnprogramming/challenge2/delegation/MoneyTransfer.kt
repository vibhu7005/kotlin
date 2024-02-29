package kt.academy.learnprogramming.challenge2.delegation
val name : String = " dfd"
private val s = "dfdf"
class MoneyTransfer(aeps : Aeps, upi : UpiInterface) : Aeps by AepsProvider(),UpiInterface by UpiProvider() {
    protected val d : Int = 3
    var x : String = "kok"
    val list : List<String> by lazy {
        println("hello")
        mutableListOf()
    }
    var s : String? = null
    infix fun printName(name : String) {
        println("hi $name")
    }
}

data class Person(var name : String = "rt")

fun main() {
    val x = Person()
    val b = x.also {
        it.name = "fdf"
    }
    var sb : String = "lol"
    val s : String? = null
    s?.let {
        sb = it
    }
    var moneyTransfer = MoneyTransfer(AepsProvider(), UpiProvider())
    println(moneyTransfer printName "rohan")
    println(moneyTransfer.x)
    val mv = listOf(1,2,3)
    val mvm = ArrayList<Int>()
    println(mvm.firstOrNull())
    println(mv.first())
    val sw : MoneyTransfer? = null
    val e = sw?.x?.length
    println(e)
    foo1 {
        println("hello")
        return@foo1
    }
//    foo2 {
//        println("dfdf")
//    }

}



inline fun foo1(crossinline dec : () -> Unit) {
    foo2 {
        dec()
    }
}

fun foo2(jist : () -> (Unit)) {
    jist()

}