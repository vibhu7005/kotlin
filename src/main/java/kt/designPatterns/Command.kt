package kt.designPatterns

import kt.generics.variance.convertToInt
import java.util.*

interface ICommand {
    fun execute()
    fun undo()
}

class TurnOnCommand() : ICommand {
    override fun execute() {
        println("turn on ac")
    }

    override fun undo() {
        println("turn off ac")
    }
}

class TurnOffCommand() : ICommand {
    override fun execute() {
        println("turn off ac")
    }

    override fun undo() {
        println("turn on ac")
    }
}

class CommandController {
    var command: ICommand? = null
    val stack = Stack<ICommand>()
    fun executeCommand() {
        command?.let {
            it.execute()
            stack.add(it)
        }
    }

    fun undoCommand() {
        val command = stack.pop()
        command.undo()
    }
}

interface Afg {
    val x: Int
        get() = 10
}

fun main() {
    var controller = CommandController()
    controller.command = TurnOnCommand()
    controller.undoCommand()
    controller.executeCommand()
    controller.undoCommand()
}