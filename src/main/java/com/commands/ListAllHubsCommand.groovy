package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
public class ListAllHubsCommand extends Base implements Command {

    /**
     * Prompts the user to select a carrier
     *
     */
    def execute() {
        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? listAllHubs(carrierName)
                : print('no such carrier\n')
    }


    /**
     * Lists all hubs associated with the selected carrier
     *
     * @param carrierName
     */
    def listAllHubs(String carrierName) {

        Network.carrierMap.get(carrierName).hubs.each {
            k, v -> println "\n${k}"
        }
    }
}

