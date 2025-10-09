// Save this as Main.kt or LiveData.kt

interface MyObserver<T> {  // Using different name to avoid conflicts
    fun onChanged(value: T)
}

class LiveData<T> private constructor(){
    private var a: T? = null
    private val list = mutableListOf<MyObserver<T>>()

    fun register(owner : LifecycleOwner, observer: MyObserver<T>) {
        list.add(observer)
    }

    fun unregister(observer: MyObserver<T>) {
        list.remove(observer)
    }

    fun setValue(value: T) {
        a = value
        list.forEach { observer ->
            observer.onChanged(value)
        }
    }



    fun getValue(): T? = a

    companion object {
        private var INSTANCE: LiveData<*>? = null

        @Suppress("UNCHECKED_CAST")
        fun <T> getInstance(): LiveData<T> {
            return INSTANCE as? LiveData<T> ?: synchronized(this) {
                INSTANCE as? LiveData<T> ?: LiveData<T>().also {
                    INSTANCE = it
                }
            } as LiveData<T>
        }
    }
}

class Asd : MyObserver<Int> {
    init {
        LiveData.getInstance<Int>().register(this)
    }
    override fun onChanged(value: Int) {
        println("value changes $value")
    }
}

fun main() {
    val liveData = LiveData.getInstance<Int>()
    val asd = Asd()
    liveData.setValue(45)
}