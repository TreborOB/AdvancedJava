package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class ListAllCarriersCommand extends Base implements Command {

    /**
     * Prints all carriers within the network
     *
     */
    def execute() {
        !Network.carrierMap ? 'No carriers exist\n'
                : Network.carrierMap.each { k, v -> println "\n${k}\n" }
    }

}