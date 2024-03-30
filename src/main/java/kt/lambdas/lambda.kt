package kt.lambdas

import kt.oop.Employee
import java.lang.StringBuilder

fun main() {
    fun topLevel() = println("top level fun called")
    run { println("hey I am a lambda") }
    val empList = listOf(
        Employee("aakash", true, 1999),
        Employee("bhasi", false, 2005), Employee("Ken", true, 2008)
    )
    //1st way
    println(empList.minByOrNull { it.yearOfJoining })
    //2nd way using member reference
    println(empList.minByOrNull(Employee::yearOfJoining))
    //lambdas can access local variable
    var num = 10
    run {
        num += 5
        println(num)
    }
    //using member reference
    run(::topLevel)


    //Lambdas with receivers
    fun printNumbers(): String = with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(",")
        }
        append(100)
        toString()
    }

    fun printNumbers2(): String = StringBuilder().apply {
        for (i in 1..99) {
            append(i)
            append(",")
        }
        append(100)
    }.toString()

    fun findByFirstName(name: String) {
        //lambda labelling
        empList.forEach lambda@{
            if (it.firstname == name) {
                println("$name found")
                return@lambda
            }
        }
        println("name not found")
    }



    println(printNumbers2())
    println(printNumbers())
    findByFirstName("aakash")

    //lamda labelling
    "header".apply header@{
        "subheader".apply {
            println(uppercase())
            println(this@header.uppercase())
        }
    }

}