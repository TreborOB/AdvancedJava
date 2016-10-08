package com.commands


import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class DeleteHubCommand extends Base implements Command {


    def execute() {
        delete()
    }

    /**
     * Prompts the user to select a carrier
     *
     */
    def delete() {
        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? hub(carrierName) : notExists(carrierName)
    }

    /**
     * Prompts the user to select a hub to delete
     *
     * @param carrierName
     */
    def hub(String carrierName) {
        listHubs(carrierName)
        def hubName = input('Enter the hubs name: ')
        doesHubExist(carrierName, hubName) ? deleteHub(carrierName, hubName) : notExists(hubName)
    }

    /**
     * Deletes the specified hub from the network
     *
     * @param carrierName, hubToDelete
     */
    def deleteHub(String carrier, String hubToDelete) {

        Network.carrierMap.get(carrier).hubs.remove(hubToDelete)
        println "$hubToDelete deleted"
    }
}
