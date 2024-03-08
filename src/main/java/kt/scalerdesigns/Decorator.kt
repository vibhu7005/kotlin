package kt.scalerdesigns

interface IceCream {
    fun getPrice(): Int
}

class ChocolateCone constructor() : IceCream {
    var iceCream: IceCream? = null

    constructor(iceCream: IceCream) : this() {
        this.iceCream = iceCream
    }

    override fun getPrice() = iceCream?.let { it.getPrice() + 50 } ?: 50
}

class VanillaCone constructor() : IceCream {
    var iceCream: IceCream? = null

    constructor(iceCream: IceCream) : this() {
        this.iceCream = iceCream
    }

    override fun getPrice() = iceCream?.let { it.getPrice() + 40 } ?: 40
}

class ChocolateScoob(private val iceCream: IceCream) : IceCream {
    override fun getPrice() = 100 + iceCream.getPrice()
}

fun main() {
    val iceCream = ChocolateScoob(ChocolateCone (VanillaCone()))
    println(iceCream.getPrice())
}

