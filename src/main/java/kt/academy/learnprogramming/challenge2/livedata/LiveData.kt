package kt.academy.learnprogramming.challenge2.livedata

class LiveData<E> {
    private var observers = HashMap<String, (E?) -> Unit>()
    var value: E? = null
        set(value) {
            for ((owner,observer) in observers) {
                observer.invoke(value)
            }
            field = value
        }
    fun observe(owner : String, observer : (E?) -> Unit) {
        observers.put(owner, observer)
    }

    fun removeObserver() {
//        observers.remove()
    }


}


fun main() {
    val liveData = LiveData<Int>()

//    liveData.observe ({
//        println("value is updated to $it")
//    }, "dwr")
//    liveData.value = 3
//    liveData.removeObserver {
//        println("value is removed from $it")
//    }
//    liveData.value = 4
//    liveData.value = 5
}