package com.commands

import com.main.Base
import com.main.Network

/**
 * Created by robertobrien on 14/09/2016.
 */
public class RenameCarrierCommand extends Base implements Command {


    def execute() {
        rename()
    }

    def rename() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? newName(carrierName) : notExists(carrierName)
    }


    def newName(String carrierName) {

        def newName = input('Enter a new name for the carrier: ')
        doesCarrierExist(carrierName) ? renameCarrier(carrierName, newName) : exists(newName)
    }


    def renameCarrier(String carrier, String newCarrierName) {

        def c = Network.carrierMap.remove(carrier)
        c.setName(newCarrierName)
        Network.carrierMap.put(newCarrierName, c)
        println ''
        println 'Carrier renamed'
    }
}
