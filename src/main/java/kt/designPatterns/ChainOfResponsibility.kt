package kt.designPatterns

open abstract class LogProcessor(private val nextLogProcessor: LogProcessor?) {
    companion object {
        val debug = 1
        val error = 2
        val info = 3
    }

    open fun log(type: Int, data: String) {
        nextLogProcessor?.log(type, data) ?: throw Exception("Invalid log")
    }
}

class DebugLogProcessor(nextLogProcessor: LogProcessor?) : LogProcessor(nextLogProcessor) {
    override fun log(type: Int, data: String) {
        if (type == debug) {
            println("debug log : $data")
        } else {
            super.log(type, data)
        }
    }
}

class ErrorLogProcessor(nextLogProcessor: LogProcessor?) : LogProcessor(nextLogProcessor) {
    override fun log(type: Int, data: String) {
        if (type == error) {
            println("error log : $data")
        } else {
            super.log(type, data)
        }
    }
}

class InfoLogProcessor(nextLogProcessor: LogProcessor?) : LogProcessor(nextLogProcessor) {
    override fun log(type: Int, data: String) {
        if (type == info) {
            println("info log : $data")
        } else {
            super.log(type, data)
        }
    }
}

object Logger {
    fun getLogger() = DebugLogProcessor(ErrorLogProcessor(InfoLogProcessor(null)))
}

fun main() {
    val logger = Logger.getLogger().log(2, "jordiee Logging test" )
}