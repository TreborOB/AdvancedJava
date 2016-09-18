package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class ListAllCarriersCommand extends Base implements Command {

    def execute() {

        listAllCarriers()
    }


    def listAllCarriers() {

        if (!Network.carrierMap) {
            println 'No carriers exist'
        } else {
            println ''
            Network.carrierMap.each { k, v -> println "${k}" }
        }
    }
}

