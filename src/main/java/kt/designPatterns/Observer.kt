package kt.designPatterns

import java.util.concurrent.Flow.Subscriber

interface Subscribor {
    fun update(event: String, value : Int?)
}

class EventManager(vararg events: String?) {
    private val eventObserverMap = hashMapOf<String, MutableList<Subscribor>>()

    init {
        for (event in events) {
            event?.let {
                eventObserverMap[it] = mutableListOf()
            }
        }
    }

    fun subscribe(event: String, subscriber: Subscribor) {
        eventObserverMap[event]?.let {
            if (!it.contains(subscriber))
                it.add(subscriber)
        }
    }

    fun unsubscribe(event: String, subscriber: Subscribor) {
        eventObserverMap[event]?.remove(subscriber)
    }

    fun notify(event: String, value : Int?) {
        val subscriborList = eventObserverMap[event]
        subscriborList?.let {
            for (subscriber in it) {
                subscriber.update(event, value)
            }
        }
    }
}

class EventGenerator {
    val events = EventManager("updated", "deleted", "modified")
    fun update(value : Int) {
        //update value
        events.notify("updated", value)
    }

    fun delete() {
        events.notify("deleted", null)
    }

    fun modify(value : Int) {
        events.notify("modified", value)
    }
}

class A : Subscribor {
    override fun update(event: String, value :Int?) {
        println("A got to know that value $value is $event")
    }

}

fun main() {
    val eventGenerator = EventGenerator()
    val a = A()
    eventGenerator.events.subscribe("updated" , a)
    eventGenerator.events.subscribe("modified" , a)
    eventGenerator.events.subscribe("deleted" , a)


    eventGenerator.update(3)
    eventGenerator.delete()
    eventGenerator.modify(4)
}