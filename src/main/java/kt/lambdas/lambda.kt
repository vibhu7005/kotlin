package kt.lambdas

import kt.oop.Employee

fun main() {
    fun topLevel() = println("top level fun called")
    run {println("hey I am a lambda") }
    val empList = listOf(Employee("aakash",true,1999),
        Employee("bhasi", false,2005), Employee( "Ken", true, 2008))
    //1st way
    println(empList.minByOrNull { it.yearOfJoining })
    //2nd way using member reference
    println(empList.minByOrNull (Employee::yearOfJoining))
    //lambdas can access local variable
    var num = 10
    run {
        num += 5
        println(num)
    }
    //using member reference
    run (::topLevel)

}