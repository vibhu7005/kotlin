package kt.arrays

fun printktx() = println("hello kt")
fun main() {
    val person = Person(2,3)
    with(person) {
        name = 5
        age = 7
    }

    bhu {x->
        x +2
    }

    println(person)

    val s = "shyam"
    s?.apply {

    }
}

fun bhu(xf : (Int) -> Int) {
    xf(8)
}

data class Person (
    var name : Int,
    var age : Int
)