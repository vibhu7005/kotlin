package declarations

fun main() {
    val e1 = Employee("samarth jindal", "sde3", 23)
    val e2 = Employee("Parth", "sde1", 25)
    val e3 = Employee("Parth", "sde1", 25)
    println(e1 === e2)
    println(e2 === e3)
    println(e1 == e2)
    println(e2 == e3)
    println(e1)
    println("""all then men are naive  
        |all women are naive as well
        |thinking of naive people didn't left any 
        |unconsidered naive as follish
    """.trimMargin("|"))

}

class Employee(var name: String, var grade: String, private val id: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Employee) {
            return this.name == other.name && this.grade == other.grade &&
                    this.id == other.id
        }
        return false
    }

    override fun toString(): String {
        return "Employee(name=$name, grade=$grade, id=$id)"
    }

}


