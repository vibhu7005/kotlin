package kt.designPatterns

interface Command {
    fun execute()
}

class TurnOnAcCommand : Command {
    override fun execute() {
        println("turn on Ac")
    }
}

class CommandController(private val command: Command){
    fun executeCommand() {
        command.execute()
    }
}

fun main() {
    CommandController(TurnOnAcCommand()).executeCommand()
}