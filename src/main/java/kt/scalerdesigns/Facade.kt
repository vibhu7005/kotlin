package kt.scalerdesigns

interface Daoo {
    fun create()
    fun update()
    fun delete()
}

class DaooFacade(val daoo: Daoo) {
    fun openDatabasa() {
        daoo.create()
        daoo.update()
    }
}