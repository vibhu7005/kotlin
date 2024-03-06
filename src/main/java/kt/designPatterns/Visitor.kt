package kt.designPatterns

interface IMotor {
    fun accept(visitor: IVisitor)
}

interface IVisitor {
    fun visit(motor: StandardMotor)

    fun visit(motor: PowerMotor)
}

class CleanMotor : IVisitor {
    override fun visit(motor: StandardMotor) {
        println("cleaning standard motor")
    }

    override fun visit(motor: PowerMotor) {
        println("cleaning power motor")
    }
}

class StandardMotor : IMotor {
    override fun accept(visitor: IVisitor) {
        visitor.visit(this)
    }
}

class PowerMotor : IMotor {
    override fun accept(visitor: IVisitor) {
        visitor.visit(this)
    }
}

fun main() {
    val motor = PowerMotor()
    motor.accept(CleanMotor())
}

