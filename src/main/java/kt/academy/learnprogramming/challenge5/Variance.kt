package kt.academy.learnprogramming.challenge5

class Box<out T> {}

open class Paper

class RegularPaper : Paper()

class PremiumPaper : Paper()

fun main() {
    val regularPaper = Box<RegularPaper>()
    var paper = Box<Paper>()
    paper = regularPaper
}