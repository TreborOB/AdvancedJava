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

    public nodes() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? hub(carrierName) : notExists(carrierName)

    }


    def hub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Which hubs nodes would you like to view? ')
        doesHubExist(carrierName, hubName) ? listAllNodes(carrierName, hubName) : notExists(hubName)
    }


    def listAllNodes(String carrierName, String hubName) {
        println ''
        Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.each { k, v ->
            println "${k}"
            println ''

        }
    }
}
