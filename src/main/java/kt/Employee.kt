class Employee (val firstName : String, isFullTime : Boolean) {
    var isFullTime : Boolean = isFullTime
    get() {
        println("custom get")
        return !field
    }
    set(value : Boolean) {
        println("custom set")
        field = isFullTime
    }
}