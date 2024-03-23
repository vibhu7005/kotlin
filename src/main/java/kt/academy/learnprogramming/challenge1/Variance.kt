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
    var producer = Producer<Any>(2)
    val producer2 = Producer<String>("rat")
    producer = producer2

    var consumer = Consumer<Int>()
    var consumer2 = Consumer<Any>()
    consumer = consumer2

}