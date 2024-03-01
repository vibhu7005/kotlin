package kt.designPatterns

interface Data {
    fun getData();
}

class NetworkData : Data {
    override fun getData() {
        println("network data")
    }
}

class DatabaseData : Data {
    override fun getData() {
        println("database data")
    }
}

abstract class DataFactory {
    abstract fun createData(): Data

    companion object {
        inline fun <reified T : Data> createData(): DataFactory = when (T::class) {
            NetworkData::class -> NetworkFactory()
            DataFactory::class -> DatabaseFactory()
            else -> {
                throw Exception()
            }
        }
    }
}

class NetworkFactory : DataFactory() {
    override fun createData(): Data = NetworkData()

}

class DatabaseFactory : DataFactory() {
    override fun createData(): Data = DatabaseData()
}

fun main() {
    DataFactory.createData<NetworkData>().createData().getData()
}