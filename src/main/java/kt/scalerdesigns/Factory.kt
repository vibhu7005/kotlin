package kt.scalerdesigns

import javax.sql.rowset.spi.TransactionalWriter

interface Database {
    fun getConnections(): Int
    fun getDatabaseElements() : DatabaseElements
}

interface DatabaseElements {
    fun getTransaction(): Transaction
    fun getQuery(): Query
}

interface Transaction

interface Query

class MySQlTransaction : Transaction
class MySqlQuery : Query

class PostGreySqlTransaction : Transaction
class PostGreySqlQuery : Query

class PostGreySqlElements : DatabaseElements {
    override fun getTransaction() = PostGreySqlTransaction()
    override fun getQuery() = PostGreySqlQuery()
}

class MySqlDbElements : DatabaseElements {
    override fun getTransaction() = MySQlTransaction()
    override fun getQuery() = MySqlQuery()
}

class MySqlDb : Database {
    override fun getConnections(): Int = 2
    override fun getDatabaseElements() = MySqlDbElements()

}

class PostgreySqlDb : Database {
    override fun getConnections() = 3
    override fun getDatabaseElements() = PostGreySqlElements()
}

class DatabaseFactory {
    companion object {
        fun getDatabaseFromUrl(url: String): Database {
            return if (url.contains("my")) {
                MySqlDb()
            } else {
                PostgreySqlDb()
            }
        }
    }
}

fun main() {
    val x : Database = DatabaseFactory.getDatabaseFromUrl("my")
    val query = x.getDatabaseElements().getQuery()
}