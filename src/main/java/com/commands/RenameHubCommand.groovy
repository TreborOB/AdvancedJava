package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class RenameHubCommand extends Base implements Command {

    def execute() {

        rename()
    }


    def rename() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? renameHub(carrierName) : notExists(carrierName)
    }


    def renameHub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Enter the name of the hub you want to rename: ')
        doesHubExist(carrierName, hubName) ? newName(carrierName, hubName) : notExists(hubName)

    }


    def newName(String carrierName, String hubName) {

        def newHubName = input('Enter a new name for the hub: ')
        doesHubExist(carrierName, hubName) ? exists(newHubName) : renameHub(carrierName, hubName, newHubName)
    }

    def renameHub(String carrier, String hub, String newHubName) {

        def b = Network.carrierMap.get(carrier).hubs.remove(hub)
        b.setName(newHubName)
        Network.carrierMap.get(carrier).hubs.put(newHubName, b)

    }
}


