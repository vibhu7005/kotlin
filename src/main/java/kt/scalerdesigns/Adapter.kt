package kt.scalerdesigns

interface BankApi {
    fun upiTransfer();
    fun aepsTransfer();
}

class PaytmBankAdapter : BankApi {
    private val paytmBankApi = PaytmBankApi()
    override fun upiTransfer() {
        paytmBankApi.transferToUpi()
    }

    override fun aepsTransfer() {
        paytmBankApi.transferAeps()
    }
}

class PaytmBankApi {

    fun transferToUpi() {

    }

    fun transferAeps() {

    }

}

fun main() {
    val bankApi : BankApi = PaytmBankAdapter()
    bankApi.upiTransfer()
    bankApi.aepsTransfer()
}



