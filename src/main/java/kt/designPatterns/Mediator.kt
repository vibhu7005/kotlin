package kt.designPatterns

interface IAuctionMediator {
    fun addBidder(bidder: IBidder)
    fun sendBidNotification(bidder: IBidder)
}

interface IBidder {
    fun getBidderName(): String
    fun sendBid()
    fun receiveBid()
}

class Mediator() : IAuctionMediator {
    var biddersList: MutableList<IBidder> = mutableListOf()
    override fun addBidder(bidder: IBidder) {
        biddersList.add(bidder)
    }

    override fun sendBidNotification(sBidder: IBidder) {
        for (bidder in biddersList) {
            if (bidder.getBidderName() != sBidder.getBidderName()) {
                bidder.receiveBid()
            }
        }
    }

}

class Bidder(val name: String, val mediator: IAuctionMediator) : IBidder {
    init {
        mediator.addBidder(this)
    }

    override fun getBidderName() = name

    override fun sendBid() {
        mediator.sendBidNotification(this)
    }

    override fun receiveBid() {
        println("bid received by $this")
    }
}