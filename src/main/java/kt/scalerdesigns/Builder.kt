//package kt.scalerdesigns
//
//import kt.academy.learnprogramming.challenge2.delegation.name
//import kt.generics.doSomething
//
//class Student private constructor(val builder: Builder) {
//    private var name: String? = null
//    private var age: Int? = null
//    private var height: Float? = null
//
//    init {
//        name = builder.name
//        age = builder.age
//        height = builder.height
//    }
//
//
//     class Builder private constructor() {
//        companion object {
//            fun getBuilder() = Builder()
//        }
//        var name: String? = null
//        var age: Int? = null
//        var height: Float? = null
//
//        fun setName(name: String) = apply { this@Builder.name = name }
//        fun setAge(age: Int) = apply { this@Builder.age = age }
//        fun setHeight(height: Float) = apply { this@Builder.height = height }
//        fun build() = Student(this)
//    }
//}
//
//fun main() {
//    val student: Student = Student.Builder.getBuilder().setAge(23)
//            .setHeight(34.0f)
//            .setName("lal")
//            .build()
//}