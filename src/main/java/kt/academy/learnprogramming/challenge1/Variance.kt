package kt.academy.learnprogramming.challenge1

import kotlin.coroutines.CoroutineContext

class Producer<out T> (private val ret : T) {
    fun produce() = ret
}

class Consumer <in T> {
    fun consume(ret : T) {
        println(ret)
    }
}

fun main() {

   val listOfData = sequence<Int> {
       for (i in 1..10) {
           Thread.sleep(1000)
           yield(i)
       }
   }
    rest {it + 4}

    val map :MutableMap<String,String> = mutableMapOf("ee" to "op", "rr" to "et")
    map["ee"] = "op"
    val k = {a:Int, b: Int -> a+b}

}

tailrec fun mom(jk : Int) : Int {
    if (jk<=1)return 1
    return mom(jk-1)
}

open class Map() {
    open lateinit var y : List<Int>
    companion object : Sur() {
        val x = 4
        fun ger() {

        }
    }
}

open class Sur : Map() {
    fun gor() {
        println(x)
    }


}

fun ret(lam : (Int,Int) -> Int) {
    lam.invoke(3,4)
}
fun rest(lam : (Int) -> Int) {
    lam(3)
}