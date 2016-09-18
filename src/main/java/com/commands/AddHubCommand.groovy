package com.commands

import com.main.Base
import com.main.Carrier
import com.main.Hub
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class AddHubCommand extends Base implements Command {


    def execute() {
        hub()
    }


    def hub() {
        listCarriers()
        def carrierName = input("Enter the carriers name: ")
        doesCarrierExist(carrierName) ? nextHub(carrierName) : notExists(carrierName)
    }


    def nextHub(String carrierName) {
        listHubs(carrierName)
        def hubName = input("Enter the new hubs: ")
        doesHubExist(carrierName, hubName) ? exists(hubName) : hubId(carrierName, hubName)

    }


    def hubId(String carrierName, String hubName) {
        def hubID = input("Enter the ID for the hub: ")
        doesHubIDExist(carrierName, hubID) ? addHub(carrierName, hubName, hubID) : exists('Carrier ' + carrierName + ' already has a hub with that id')
    }


    def addHub(String parentCarrier, String hubName, String hubID) {

        Carrier c = Network.carrierMap.get(parentCarrier)
        Hub hub = new Hub(hubName, hubID)
        c.hubs.put(hub.getName(), hub)
        println "Hub $hubName hubName with an ID of $hubID added"
    }


}

