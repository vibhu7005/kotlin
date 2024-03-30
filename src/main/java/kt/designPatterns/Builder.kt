package kt.designPatterns

class Network private constructor(builder: Builder) {
    var networkGateWay: String? = null
    var networkProvider: String? = null
    var host: String? = null

    init {
        networkGateWay = builder.networkGateWay
        networkProvider = builder.networkProvider
        host = builder.host
    }

    class Builder {
        var networkGateWay: String? = null
        var networkProvider: String? = null
        var host: String? = null
        fun setNetworkGateway(input: String) = apply { networkGateWay = input }
        fun setNetworkProvider(input: String) = apply { networkProvider = input }
        fun setNetworkHost(input: String) = apply { host = input }
        fun build() = Network(this)
    }
}

fun main() {
    val network = Network.Builder().setNetworkGateway("fdfd")
            .build()
    println(network.networkGateWay)
}