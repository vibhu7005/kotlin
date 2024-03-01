package kt.designPatterns


data class DatabaseeData(val index: Int, val rating: Int)

fun displayData(list: List<DisplayData>) {
    for (item in list) println(item)
}

data class DisplayData(val position: String, val rating: Float)

class DatabaseDataGenerator {
    fun generateData() {
        var list = mutableListOf<DatabaseeData>()
        list.add(DatabaseeData(2, 4))
    }
}

interface DataConverter {
    fun convertData(list: List<DatabaseeData>): List<DisplayData>
}

class DisplayDataAdapter() : DataConverter {
    override fun convertData(list: List<DatabaseeData>): List<DisplayData> {
        val resultList = mutableListOf<DisplayData>()
        for (item in list) {
            resultList.add(DisplayData(item.index.toString(), item.rating.toFloat()))
        }
        displayData(resultList)
        return resultList
    }
}