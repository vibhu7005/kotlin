package kt.generics

fun main() {
    val list:List<Any> = mutableListOf(1,23,5,"dfdf","ko",6)
    val resList = getElementsOfType<String>(list)
    println(resList)
    println(add<String>("ko","man"))
}

 inline fun <reified T>getElementsOfType (list : List<Any>) : List<T> {
    var newList : MutableList<T> = mutableListOf("hello" as T)
    for (element in list) {
        if (element is T) {
            newList.add(element)
        }
    }
    return newList
}

inline fun <reified T> add(num1: T, num2: T): T {
    val c = num1.toString() + num2.toString()
    return c as T
}

fun <T>doSomething(list : List<T>) {

}