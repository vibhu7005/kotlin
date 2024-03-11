package kt.scalerdesigns

import java.util.concurrent.atomic.AtomicInteger

interface Prototype {
    fun clone(): Prototype?
}

interface IceCream : Prototype {
    fun getPrice(): Int
}

class IceCreamDirectory {
    val iceCreamStoreMap: MutableMap<String, IceCream> = mutableMapOf()
    fun addIceCream(name: String, iceCream: IceCream) {
        iceCreamStoreMap.put(name, iceCream)
    }

    fun getIceCream(key: String) {
        iceCreamStoreMap.get(key)?.clone()
    }
}

class ChocolateCone constructor() : IceCream {
    var iceCream: IceCream? = null

    constructor(iceCream: IceCream) : this() {
        this.iceCream = iceCream
    }

    override fun getPrice() = iceCream?.let { it.getPrice() + 50 } ?: 50
    override fun clone(): Prototype? {
        if (iceCream == null) return null
        return iceCream?.clone()
    }
}

class VanillaCone constructor() : IceCream {
    var iceCream: IceCream? = null

    constructor(iceCream: IceCream) : this() {
        this.iceCream = iceCream
    }

    override fun getPrice() = iceCream?.let { it.getPrice() + 40 } ?: 40
    override fun clone(): Prototype? {
        if (iceCream == null) return null
        return iceCream?.clone()
    }
}

class ChocolateScoob(private val iceCream: IceCream) : IceCream {
    override fun getPrice() = 100 + iceCream.getPrice()
    override fun clone(): Prototype? {
        return iceCream.clone()
    }
}

fun main() {
//    val iceCream = ChocolateScoob(ChocolateCone(VanillaCone()))
//    val directory = IceCreamDirectory()
//    directory.addIceCream("wow", iceCream)
//    println(iceCream.getPrice())
    var x  = AtomicInteger(0)
    x.incrementAndGet()
    x.incrementAndGet()


    Thread {
        for (i in 1..10000) {
            x.incrementAndGet()
        }
    }.start()

    Thread {
        for (i in 1..10000) {
             x.incrementAndGet()
        }
    }.start()

    Thread.sleep(10000)
    println(x)
}

