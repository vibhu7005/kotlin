package kt.sequences

import kt.collections.Car
import kotlin.system.measureTimeMillis


fun main() {
    val carMap = mapOf(
        1 to Car("Maserati", 1999), 2 to Car("Porche", 2005), 3 to Car("Lexus", 2020)
    )

//    println(carMap.filter { it.value.year > 2000}
//        .map { it.value.name })


    //intermeddiate collection creation

    //Can be avoided using kotlin sequences
    //similar to java streams
    //can be used when we have no idea of how large the result is.
    //Entries in sequnce are enumerated one by one
    val time = measureTimeMillis {
        println(carMap.asSequence().filter {
            println("filering ${it.value.name}")
            it.value.year > 2000
        }.map {
                println("mapping ${it.value.name}")
                it.value.name
            }.find { it[0] == 'P' }
        )
    }
    println("Execution time is $time")
    // intermeddiate and terminal operations
    // intermeddiate operations are lazy they are never evaluated without using a terminal operation
    //each intermeediate step returns a sequence

}

