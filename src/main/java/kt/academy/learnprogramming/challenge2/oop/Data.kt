package kt.academy.learnprogramming.challenge2.oop


class Data<E> {
    private val list : MutableList<E> = mutableListOf()
    fun add(event : E) {
        list.add(event)
    }

    fun addAll(list : Collection<E>) {
        list.forEach {
            add(it)
        }
    }
    fun getLatestEvent() : E = list[list.lastIndex]
}
open class Person(val name : String ="")
class Student(name : String= "", val grade : String = "") : Person(name)

fun main() {


//    val eventList = Data<Int>()
//    eventList.add(3)
//    eventList.add(4)
//    eventList.add(5)
//    println(eventList.getLatestEvent())
//    val listOfData = mutableDataOf("ff","fdf","fdf")
//
//    val listOfPerson = Data<Person>()
//    val students : List<Person> = listOf(Student()) //covariance
//    listOfPerson.addAll(mutableListOf(Student(), Student()))
//
//    val listOfStudents : MutableList<Student> = mutableListOf<Student>(Student(), Student())
//    listOfPerson.addAll(listOfStudents)
//    delaWithPersons()

//    val persons : Data<Person> = listOf<Student>(Student(), Student())
    val person : List<Person> = listOf<Student>(Student())
    //read only collections are covariant
//    persons.add(Student())
//    persons.add(Person())

//    val s : String = "sam"
//    var r = s
//    println(r)
//    r = "lop"
//    println(s)
    val producer = Producer<Int>(2)
    val prod : Producer<Any> = producer

    val consumer = Consumer<Any>()
    val cons : Consumer<Int> = consumer
    cons.consume(90)
}

fun delaWithPersons(list: MutableList<Person>) {

}

fun<E> mutableDataOf(vararg args : E) : Data<E> {
    val data = Data<E>()
    for (arg in args) {
        data.add(arg)
    }
    return data
}

class Producer <out E>(val mat : E) {
    fun produce() : E {
        return mat
    }
}

class Consumer <in E> {
    fun consume(mat : E) {
    }
}