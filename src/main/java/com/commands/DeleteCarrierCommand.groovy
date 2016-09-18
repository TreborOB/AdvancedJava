package com.commands


import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
public class DeleteCarrierCommand extends Base implements Command {


    def execute() {
        delete()
    }

    def delete() {

        listCarriers()

        def carrierName = input('Enter the carriers name: ')

        doesCarrierExist(carrierName) ? deleteCarrier(carrierName) : notExists(carrierName)
    }

    def deleteCarrier(String carrierToDelete) {

        Network.carrierMap.remove(carrierToDelete)
        println "$carrierToDelete added"
    }
}
