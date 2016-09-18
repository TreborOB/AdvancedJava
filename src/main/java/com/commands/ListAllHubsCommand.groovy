package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
public class ListAllHubsCommand extends Base implements Command {

    def execute() {
        hub()
    }

    def hub() {

        listCarriers()

        def carrierName = input('Enter the carriers name: ')

        if (doesCarrierExist(carrierName)) {
            listAllHubs(carrierName)
        } else {
            print 'no such carrier'
        }
    }

    def listAllHubs(String carrierName) {

        println ''
        Network.carrierMap.get(carrierName).hubs.each { k2, v2 ->
            println "${k2}"
            println ''
        }
    }
}

