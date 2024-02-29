package kt.academy.learnprogramming.challenge2.oop

 sealed class Resulti {
    data class Success(val data: String) : Resulti()
    data class Error(val message: String) : Resulti()
}

fun handleResult(result: Resulti) {
    when (result) {
        is Resulti.Success -> println("Success: ${result.data}")
        is Resulti.Error -> println("Error: ${result.message}")
    }
}

class Dama {
    object DamaInstance {
    }

    fun callme() {
        println("hi thanks for calling")
    }
}

fun main() {
//    val successResult = Success("Data fetched successfully")
//    val errorResult = Error("Failed to fetch data")
//
//    handleResult(successResult)
//    handleResult(errorResult)
//    Dama.DamaInstance.callMe()
}