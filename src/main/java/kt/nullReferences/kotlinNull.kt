package kt.nullReferences

import java.lang.Exception
import java.util.*

fun main() {
    val str: String? = null
   // println(str?.uppercase())
    val str2 = str?.uppercase()
    //println(str2)
    val num: Any = 34
    val sum = num as? Double
    print(sum)

    //if
    var name :String? = null
    //println(name!!.uppercase())

    name?.let {
        printname(it)
    }
    var strArray = Array<Int>(5){i->i+1}

    val arofnulls = arrayOfNulls<Int>(5)
    arofnulls[3] = 56
    print(arofnulls[3].toString())


}

fun printname (data : String) {
    println(data)
}



