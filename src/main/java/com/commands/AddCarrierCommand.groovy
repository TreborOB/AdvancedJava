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
     * Prompts the user to enter the new carriers name
     */
    def carrier() {
        def carrierName = input("Enter the new carriers name: ")
        listCarriers()
        doesCarrierExist(carrierName) ? exists(carrierName) : addCarrier(carrierName)
    }

    /**
     * Adds carrier to the network
     *
     * @param carrierName
     */
    def addCarrier(String carrierName) {
        def c = new Carrier()
        carrierName ? (Network.carrierMap.put(carrierName, c).println("Carrier $carrierName added")): print('No carrier entered')


    }

}