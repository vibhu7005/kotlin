package kt.academy.learnprogramming.challenge2.oop

sealed class Result
data class Success(val data: String) : Result()
data class Error(val message: String) : Result()


fun handleResult(result: Result) {
    when (result) {
        is Success -> println("Success: ${result.data}")
        is Error -> println("Error: ${result.message}")
    }
}

fun main() {
    val successResult = Success("Data fetched successfully")
    val errorResult = Error("Failed to fetch data")

    handleResult(successResult)
    handleResult(errorResult)
}