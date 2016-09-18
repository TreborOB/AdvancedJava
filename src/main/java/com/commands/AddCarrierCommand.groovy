package com.commands


import com.main.Base
import com.main.Carrier
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class AddCarrierCommand extends Base implements Command {


    def execute() {
        carrier()
    }


    /**
     * Creates an alarm on a hub using the createAlarmOnHub method
     */
    def carrier() {
        def carrierName = input("Enter the new carriers name: ")
        listCarriers()
        doesCarrierExist(carrierName) ? exists(carrierName) : addCarrier(carrierName)
    }

    /**
     * Creates an alarm on a hub using the createAlarmOnHub method
     */
    def addCarrier(String carrierName) {
        def c = new Carrier()
        Network.carrierMap.put(carrierName, c)
        println "$carrierName added"
    }
}

