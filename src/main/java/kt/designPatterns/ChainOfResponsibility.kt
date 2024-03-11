package kt.designPatterns

open abstract class LogProcessor(private val nextLogProcessor: LogProcessor?) {
    companion object {
        val debug = 1
        val error = 2
        val info = 3
    }

    open fun log(type : Int, log : String) {
       nextLogProcessor?.log(type, log) ?: throw java.lang.Exception()
    }
}

class DebugLogProcessor(nextLogProcessor: LogProcessor?) : LogProcessor(nextLogProcessor) {
    override fun log(type : Int, log : String) {
        if (type == debug) {
            super.log(type, log)
        } else {
            super.log(type, log)
        }
    }
}

class ErrorLogProcessor(nextLogProcessor: LogProcessor?) : LogProcessor(nextLogProcessor) {
    override fun log(type : Int, log : String) {
        if (type == debug) {
            super.log(type, log)
        } else {
            super.log(type, log)
        }
    }
}

class InfoLogProcessor(nextLogProcessor: LogProcessor?) : LogProcessor(nextLogProcessor) {
    override fun log(type : Int, log : String) {
        if (type == debug) {
            super.log(type, log)
        } else {
            super.log(type, log)
        }
    }
}

object Logger {
    fun getLogger() = DebugLogProcessor(ErrorLogProcessor(InfoLogProcessor(null)))
}

fun main() {
    val logger = Logger.getLogger().log(2, "jordiee Logging test" )
}