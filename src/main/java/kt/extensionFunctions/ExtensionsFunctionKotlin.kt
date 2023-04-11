package extensionFunctions

fun String.toFistAndLastUppercase() = substring(0,1) + substring(1, this.length-1) + substring(this.length - 1).uppercase()
class ExtensionsFunctionKotlin {
    fun toFirstAndLastUppercase(s : String) = s.substring(0,1).uppercase() +
            s.substring(1, s.length - 1) + s.substring(s.length - 1).uppercase()
}