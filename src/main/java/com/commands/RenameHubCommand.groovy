package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class RenameHubCommand extends Base implements Command {



    /**
     * Prompts the user to select a carrier
     *
     */
    def execute() {
        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? renameHub(carrierName)
                : notExists(carrierName)
    }

    /**
     * Prompts the user to select a hub
     *
     * @param carrierName
     */
    def renameHub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Enter the name of the hub you want to rename: ')
        doesHubExist(carrierName, hubName) ? newName(carrierName, hubName)
                : notExists(hubName)

    }

    /**
     * Prompts the user to select a new name for the hub
     *
     * @param carrierName , hubName
     */
    def newName(String carrierName, String hubName) {

        def newHubName = input('Enter a new name for the hub: ')
        doesHubExist(carrierName, hubName) ? renameHub(carrierName, hubName, newHubName)
                : exists(newHubName)
    }

    /**
     * Renames the selected hub
     *
     * @param carrierName , hub, newHubName
     */
    def renameHub(String carrier, String hub, String newHubName) {

        def b = Network.carrierMap.get(carrier).hubs.remove(hub)
        b.setName(newHubName)

        newHubName ? Network.carrierMap.get(carrier).hubs.put(newHubName.print("$hub rename to $newHubName"), b)
                : println('No new hub entered')

    }
}


