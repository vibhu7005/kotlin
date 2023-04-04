package kt.inheritance

open class Animal {
    var name : String? = null

    open fun perform() : String {
        name = "df"
        return "ret"
    }
}