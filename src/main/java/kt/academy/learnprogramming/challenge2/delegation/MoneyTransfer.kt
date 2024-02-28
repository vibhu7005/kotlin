package kt.academy.learnprogramming.challenge2.delegation

class MoneyTransfer(aeps : Aeps, upi : UpiInterface) : Aeps by AepsProvider(),UpiInterface by UpiProvider() {
    lateinit var x : String
    val list : List<String> by lazy {
        println("hello")
        mutableListOf()
    }
    var s : String? = null
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
    lateinit var moneyTransfer: MoneyTransfer
//    if (moneyTransfer != null) {
//        println( moneyTransfer.x)
//    }
}