package kt.designPatterns

class Business {
    //devops
    //ai
    //android

}

sealed class Employee {
    data class Devops(val data: String, val name: String) : Employee()
    data class AI(val data: String, val name: String) : Employee()
    data class Android(val data: String, val name: String) : Employee()
}

object EmployeeFactory {
    fun createEmployee(type: String): Employee =
            when (type) {
                "Devops" -> Employee.Devops("fdf", "fg")
                "AI" -> Employee.AI("fdf", "dfd")
                else -> Employee.Android("dff", "fd")
            }
}


