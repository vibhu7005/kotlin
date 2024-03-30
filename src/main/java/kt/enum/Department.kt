package kt.enum
enum class Department(val fullname : String,val strength : Int) {
    HR("Hiring", 23), ACCOUNTS("Accounts", 45), TECH("Technical",35), PRODUCT("product managment", 46);
    fun printInfo() {
        println("$fullname department has $strength people")
    }
}