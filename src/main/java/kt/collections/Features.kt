package kt.collections

fun main() {
    val carMap = mapOf(
        1 to Car("Maserati", 1999), 2 to Car("Porche", 2005),
        3 to Car("Lexus", 2020)
    )
    val filteredCarMap = carMap.filter { it.value.year > 2005 }
    val carProductionYearList = carMap.map { it.value.year }
    println(filteredCarMap)
    println(carProductionYearList)

    val ints = arrayOf(1,2,3,4,5)
    val add10ToList = ints.map {it + 10}
    println(add10ToList)
    val cars = carMap.filter { it.value.year > 2004 }.
            map { it.value.name }
    println(cars)

    val carsList = carMap.values
    println(carsList)
    println(carsList.find { it.year > 2004 })

    println( carsList.groupBy { "Jordiee " + it.name })
}

