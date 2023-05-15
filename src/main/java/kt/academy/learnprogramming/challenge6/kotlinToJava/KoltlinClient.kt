package kt.academy.learnprogramming.challenge6.kotlinToJava

import kt.academy.learnprogramming.challenge6.kotlinToJava.javaCode.Employee

fun main() {
    val employee = Employee("jain", "smith", 2000)
    employee.lastName = "Jones"
    employee.salaryLast3Years = floatArrayOf(234445.0f,453434.34f,5454.60f)
}