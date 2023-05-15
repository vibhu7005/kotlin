package kt.academy.learnprogramming.challenge6.JavaToKotlin

fun sayHelloToJava(name : String) {
    println("kotlin says hello to java and $name")
}

object Challenge {
   // @JvmStatic
//    fun doMath(x : Int, y : Int) {
//        (x + y) * (x - y)
//    }
    fun doMath(x : Int, y : Int) {
        (x + y) * (x - y)
    }
}
class Employee (val firstName : String, val lastName : String, var startYear : Int) {
    fun takesDefault(param1 : String, param2 : String = "default") {
        println("$param1 and $param2")
    }
}