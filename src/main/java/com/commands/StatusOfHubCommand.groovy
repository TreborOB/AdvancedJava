package com.commands


import com.main.Base
import com.main.Carrier
import com.main.Hub
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
public class StatusOfHubCommand extends Base implements Command {


    def execute() {
        status()
    }


    def status() {
        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? searchByNameOrID(carrierName) : notExists(carrierName)

    }


    def searchByNameOrID(String carrierName) {

        listHubs(carrierName)
        def nameOrID = input('Enter the name or ID of the hub you wish to search for: ')
        doesHubExist(carrierName, nameOrID) || doesHubIDExist(carrierName, nameOrID) ? search(carrierName, nameOrID) : notExists(carrierName)
    }


    def search(String carrierName, String nameOrID) {

        Hub hub
        String hubs

        for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
            hubs = entry.getKey()

            for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {

                if (entryHub.getKey().equalsIgnoreCase(nameOrID) || entryHub.getValue().getId().equalsIgnoreCase(nameOrID)) {
                    System.out.println("")

                    hub = entryHub.getValue()
                    println 'Name: ' + hub.getName()
                    println 'Id: ' + hub.getId()
                    println 'Alarm count: ' + hub.getHubAlarms().size()

                }
            }
        }
    }
}