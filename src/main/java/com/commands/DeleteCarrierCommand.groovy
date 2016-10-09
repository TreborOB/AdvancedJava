package com.commands


import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
public class DeleteCarrierCommand extends Base implements Command {


    /**
     * Prompts the user to select to a carrier to delete
     *
     */

    def execute() {
        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? deleteCarrier(carrierName)
                : notExists(carrierName)
    }

    /**
     * Deletes the specified carrier from the network
     *
     * @param carrierToDelete
     */
    def deleteCarrier(String carrierToDelete) {
        Network.carrierMap.remove(carrierToDelete)
        println "$carrierToDelete added"
    }
}
