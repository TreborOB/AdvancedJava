package com.commands

import com.main.Base
import com.main.Hub
import com.main.Network

/**
 * Created by robertobrien on 14/09/2016.
 */
class AddHubCommand extends Base implements Command {


    def execute() {
        hub()
    }


    /**
     * Prompts the user to enter the new carriers name
     */
    def hub() {
        listCarriers()
        def carrierName = input("Enter the carriers name: ")
        doesCarrierExist(carrierName) ? nextHub(carrierName) : notExists(carrierName)
    }


    /**
     * Prompts the user to enter the new hubs name
     *
     * @param carrierName
     */
    def nextHub(String carrierName) {
        listHubs(carrierName)
        def hubName = input("Enter the new hubs: ")
        doesHubExist(carrierName, hubName) ? exists(hubName) : hubId(carrierName, hubName)

    }

    /**
     * Prompts the user to enter the new hubs ID
     *
     * @param carrierName, hubName
     */
    def hubId(String carrierName, String hubName) {
        def hubID = input("Enter the ID for the hub: ")
        doesHubIDExist(carrierName, hubName) ? addHub(carrierName, hubName, hubID) : exists('Carrier ' + carrierName + ' already has a hub with that id')
    }

    /**
     * Adds the hub to the network
     *
     * @param carrierName, hubName, hubID
     */
    def addHub(String carrierName, String hubName, String hubID) {

        Hub hub = new Hub(hubName, hubID)
        hubName ? (Network.carrierMap.get(carrierName).hubs.put(hub.getName(), hub.println("Hub $hubName with an ID of $hubID added"))): println('No hub entered')
    }


}

