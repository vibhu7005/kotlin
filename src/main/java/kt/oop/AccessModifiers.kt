package kt.oop
var seret = 3
class AccessModifiers {
    var mode : Int = 0
    fun res () {
        seret = 4
    }
    internal var secretKey : Int = 9

    class Sem {
        private var septum = 5
        fun calc() {
        }
    }
}

fun main() {
    AccessModifiers.Sem().calc()
}



