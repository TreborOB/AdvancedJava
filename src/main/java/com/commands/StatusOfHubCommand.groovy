package com.commands

import com.main.Base
import com.main.Network

/**
 * Created by robertobrien on 14/09/2016.
 */
public class StatusOfHubCommand extends Base implements Command {

    /**
     * Prompts the user to select a carrier
     *
     */
    def execute() {
        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? searchByNameOrID(carrierName) : notExists(carrierName)
    }

    /**
     * Prompts the user to select a hub using either the name or id
     *
     * @param carrierName
     */
    def searchByNameOrID(String carrierName) {

        listHubs(carrierName)
        def nameOrID = input('Enter the name or ID of the hub you wish to search for: ')
        doesHubExist(carrierName, nameOrID) || doesHubIDExist(carrierName, nameOrID) ? search(carrierName, nameOrID)
                : notExists(carrierName)
    }

    /**
     * Prints out the status of the selected hub (if the hub has a unit unavailable then the hub itself is unavailable)
     *
     * @param carrierName , nameOrId
     */
    def search(String carrierName, String nameOrID) {

        def unit = 'Unit Unavailable'
        if (Network.carrierMap.get(carrierName).hubs.get(nameOrID).hubAlarms.alarmType.inject(false) { acc, value -> acc || unit.contains(value) }) {
            println 'Hub is UNAVAILABLE'
        }
    }
}