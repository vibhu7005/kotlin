package kt.academy.learnprogramming.challenge2.delegation

class UpiProvider : UpiInterface{
    override fun doUpi() {
        println("Upi completed")
    }
}