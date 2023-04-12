package kt.oop

class Employee (val firstname : String, private var isFullTime :Boolean = true) {
    fun isEmpFullTime() : Boolean {
        return isFullTime
    }

}