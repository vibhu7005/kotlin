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
}

fun rest(lam : (Int) -> Int) {
    lam(3)
}