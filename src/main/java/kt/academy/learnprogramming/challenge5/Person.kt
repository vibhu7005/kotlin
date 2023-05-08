package kt.academy.learnprogramming.challenge5

fun main() {
    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 34)
    val mary = Person("mary", "jim", 7)
    val jean = Person("Jean", "kate", 34)

    val people = mapOf(
        joe.lastName to joe, jane.lastName to jane, mary.lastName to mary,
        jean.lastName to jean
    )
    println(people[joe.lastName])

    println((people.filter { it.value.lastName.startsWith("S") }).size)

    val list = people.map { Pair(it.value.firstName, it.value.lastName) }
    println(list)

    val (fName, lName, age) = joe
    println("fName $fName, lName $lName, age $age")
    useLambda { x -> x + 1 }

    people.apply {
        map {
            println(it.value.firstName + " " + it.value.age)
        }
    }

    val list1 = listOf(1, 4, 9, 15, 33)
    val list2 = listOf(4, 55, -83, 22, 101, 15)
    val list3 = (list1.intersect(list2))
    println(list3)
}

class Person(val firstName: String, val lastName: String, val age: Int) {
    operator fun component1() = firstName

    operator fun component2() = lastName

    operator fun component3() = age
}

fun performOperation(a: Int): Int {
    return a + 1
}

fun useLambda(a: (Int) -> Int) {
    println(a(5))
}

