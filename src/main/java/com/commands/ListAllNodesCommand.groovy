package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class ListAllNodesCommand extends Base implements Command {


    def execute() {
        nodes()
    }

    /**
     * Prompts the user to select to a carrier
     *
     */
    public nodes() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? hub(carrierName) : notExists(carrierName)

    }

    /**
     * Prompts the user to select a hub
     *
     * @param carrierName
     */
    def hub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Which hubs nodes would you like to view? ')
        doesHubExist(carrierName, hubName) ? listAllNodes(carrierName, hubName) : notExists(hubName)
    }

    /**
     * Lists all nodes for the selects hub
     *
     * @param carrierName, hubName
     */
    def listAllNodes(String carrierName, String hubName) {
        Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.each { k, v -> println "\n${k}"}
    }
}
