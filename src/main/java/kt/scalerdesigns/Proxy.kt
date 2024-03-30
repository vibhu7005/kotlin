package kt.scalerdesigns

interface Dao {
    fun createDb()
}

class DaoImpl : Dao {
    override fun createDb() {
        println("db is created")
    }
}

val admin = true

class DaoImplProxy constructor(val daoImpl: DaoImpl): Dao {
    override fun createDb () {
        if (admin) {
            daoImpl.createDb()
        } else {
            throw java.lang.Exception()
        }
    }

}