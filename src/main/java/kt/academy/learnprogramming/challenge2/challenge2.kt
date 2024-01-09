package kt.academy.learnprogramming.challenge2

fun main() {
    val string : String? = null
    val response = Response()

    if (response.payload?.res.equals("dds")) {
        println("hello")
    }


    var num1: Float? = -3847.384f
    var num2: Float? = (-3214.384).toFloat()
    val array = ShortArray(5) { i -> (i + 1).toShort() }
    val array2 = shortArrayOf(1, 2, 3, 4, 5)
    val array3 = Array<Int?>(100 / 5) { i -> (i + 1) * 5 }
    val array4 = charArrayOf('a', 'b', 'c')
    Array().method(array4)
    val x: String? = "I AM IN UPPERCASE"
    val y = x?.lowercase() ?: "I give up"
    x?.let {
        val s = it.lowercase().replace("am", "am not")
        print(s)
    }

//    val nonNullVariable: Int? = null
//    nonNullVariable!!.toDouble()
}

data class Response(val payload: Payload? = null)

data class Payload(val res : String)