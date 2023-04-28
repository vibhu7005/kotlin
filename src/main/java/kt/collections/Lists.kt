package kt.collections

fun main() {
    val list = listOf(1, 2, 3)
    println(list.javaClass)

    val list2 = arrayListOf(1, 2, 3)
    list2[0] = 23

    val list3 = mutableListOf(1,2,4,5)
    println(list3.javaClass)

    val colorArray = arrayOf("red","blue","green")
    val exList = listOf(*colorArray)
    println(exList)
    println(list2)

    val colorList = listOf("Red", "blue", "Green", "Red")
    val seasonsList = listOf("summer","winter","rainy", "winter")
    println(colorList.last())
    println(colorList.asReversed())
    println(colorList.getOrNull(5))
    println(colorList)
    println(colorList.zip(seasonsList))
    val combined = listOf(colorList, seasonsList)
    println(combined)
    val actualCombined = colorList + seasonsList
    println(actualCombined)
    println(colorList.union(seasonsList))
    println(colorList.distinct())
}