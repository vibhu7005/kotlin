package kt.designPatterns

class VendingMachine {
    var state : VendingStates? = null
    val inventory : String? = null
    val cashEnteredByUser : Int? = null
    init {
        state = Idle()
    }

}

fun main() {
    val vm = VendingMachine()
    vm.state?.pressStart(vm)
    vm.state = AcceptMoney()
    vm.state?.enterCoin(vm)

}

interface VendingStates {
    fun pressStart(vm : VendingMachine)
    fun enterCoin(vm : VendingMachine)
    fun cancelOperation(vm : VendingMachine)
    fun refundAmount(vm : VendingMachine)
    fun chooseProduct(vm : VendingMachine)
    fun dispenseItem(vm : VendingMachine)
}

class Idle : VendingStates {
    override fun pressStart(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun enterCoin(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun cancelOperation(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun refundAmount(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun chooseProduct(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun dispenseItem(vm: VendingMachine) {
        TODO("Not yet implemented")
    }
}


class AcceptMoney : VendingStates {
    override fun pressStart(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun enterCoin(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun cancelOperation(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun refundAmount(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun chooseProduct(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun dispenseItem(vm: VendingMachine) {
        TODO("Not yet implemented")
    }
}


class ChooseProduct : VendingStates {
    override fun pressStart(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun enterCoin(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun cancelOperation(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun refundAmount(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun chooseProduct(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun dispenseItem(vm: VendingMachine) {
        TODO("Not yet implemented")
    }
}

class DispenseProduct : VendingStates {
    override fun pressStart(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun enterCoin(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun cancelOperation(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun refundAmount(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun chooseProduct(vm: VendingMachine) {
        TODO("Not yet implemented")
    }

    override fun dispenseItem(vm: VendingMachine) {
        TODO("Not yet implemented")
    }
}