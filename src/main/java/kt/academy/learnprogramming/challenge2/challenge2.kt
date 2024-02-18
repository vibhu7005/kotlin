package kt.academy.learnprogramming.challenge2

fun main() {
//    val string : String? = null
//    val response = Response()
//
//    if (response.payload?.res.equals("dds")) {
//        println("hello")
//    }
//
//
//    var num1: Float? = -3847.384f
//    var num2: Float? = (-3214.384).toFloat()
//    val array = ShortArray(5) { i -> (i + 1).toShort() }
//    val array2 = shortArrayOf(1, 2, 3, 4, 5)
//    val array3 = Array<Int?>(100 / 5) { i -> (i + 1) * 5 }
//    val array4 = charArrayOf('a', 'b', 'c')
//    Array().method(array4)
//    val x: String? = "I AM IN UPPERCASE"
//    val y = x?.lowercase() ?: "I give up"
//    x?.let {
//        val s = it.lowercase().replace("am", "am not")
//        print(s)
//    }

//    val nonNullVariable: Int? = null
//    nonNullVariable!!.toDouble()
//    val array = ArrayList<Int>()
//    for(i in 1..100) {
//        array.add((2..100).random())
//    }
//    println()
//    for (el in array.filter { it <= 10 }) print(" $el")
//    lao {it + 4}

//    val data = mapOf(
//            "users1.csv" to listOf(32, 45, 17, -1, 34),
//            "users2.csv" to listOf(19, -1, 67, 22),
//            "users3.csv" to listOf(),
//            "users4.csv" to listOf(56, 32, 18, 44)
//    )
//    println(data.map { xt ->
//        xt.value.filter { it >= 0 }})
//
//    println(data.filter {
//        it.value.any { it < 0 }
//    })

//    val str : String = "abc"
//    str?.let{
//        println(it.length)
//
//    }
//    str?.apply {
//        val x = length
//        val y = trim()
//        val z = x.toString() + y
//    }
//    println(doo("     radar ", {it.uppercase()}, {it.trim()}))


    val person1 = Person("Alice", 30, Address("lol","lop"))
    val person2 = person1.copy() // Shallow copy
    person2.age = 57
    person2.address.city = "lala"
    println(person1.address.city)
//    if (person1 === person2) println(true)
//    else println(false)
}

data class Person(var name: String, var age: Int, var address: Address)
data class Address(var city: String, var country: String)


//fun Person.deepCopy() : Person {
//    return this.copy(name = this.name, age = this.a)
//}

inline fun doo(s : String, operation1 : (String) -> String, operation2 : (String) -> String) : String {
    return operation2(operation1(s))
}


fun oola(x : Int) : Int {
    val s = x
    return s + 2
}

fun lao(fx : (Int)->Int) : Int {
   return fx(5)
}

data class Response(val payload: Payload? = null)

data class Payload(val res : String)