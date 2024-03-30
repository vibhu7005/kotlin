package kt.designPatterns

interface Visitor {
    fun visit(room: DeluxeRoom)
    fun visit(room: DoubleRoom)
}

interface Room {
    fun accept(visitor: Visitor)
}

class DeluxeRoom : Room {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class DoubleRoom : Room {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class CleanRoom : Visitor {
    override fun visit(room: DeluxeRoom) {
        println("cleaning deluxe room")
    }

    override fun visit(room: DoubleRoom) {
        println("cleaning double room")
    }

}

fun main() {
    val deluxeRoom = DeluxeRoom()
    deluxeRoom.accept(CleanRoom())
}

