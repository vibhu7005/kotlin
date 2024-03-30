package kt.oop

data class Employee (val firstname : String, private var isFullTime :Boolean = true, val yearOfJoining: Int) {
    fun isEmpFullTime() : Boolean {
        return isFullTime
    }

}