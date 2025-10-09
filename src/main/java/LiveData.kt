class LiveData<T> {
    private var value : T?= null
    private val list : MutableList<MyObserver<T>> = mutableListOf()

    fun register(observer: MyObserver<T>) {
        list.add(observer)
    }

    fun unregister(observer: MyObserver<T>) {
        list.remove(observer)
    }

    fun setValue(value : T) {
        this.value = value
        for (observer in list) {
            observer.onChanged(value)
        }
    }


}

class DFG : MyObserver<Int> {
    override fun onChanged(value: Int) {
        println("value arrived $value")
    }
}

interface MyObserver<T> {
    fun onChanged (value: T)
}

fun main() {
    val liveData = LiveData<Int>()
    liveData.register(DFG())
    liveData.setValue(45)
}

