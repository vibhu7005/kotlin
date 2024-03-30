package kt.scalerdesigns

class PaytmbankApi {
    fun sendMoneyViaUpi() {}
    fun sendMoneyViaAeps() {}
}

interface BankApi {
    fun upiTransfer()
    fun aepsTransfer()
}

class PaytmBankAdapter : BankApi {
    val paytmbankApi = PaytmbankApi()

    override fun upiTransfer() {
        paytmbankApi.sendMoneyViaUpi()
    }

    override fun aepsTransfer() {
        paytmbankApi.sendMoneyViaAeps()
    }

}

fun main() {
    val bankApi : BankApi
    bankApi = PaytmBankAdapter()
    bankApi.upiTransfer()
    bankApi.aepsTransfer()
}



