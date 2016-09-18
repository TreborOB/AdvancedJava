package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class ListEntireNetworkCommand extends Base implements Command {


    def execute() {
        listNetwork()
    }

    def listNetwork() {

        Network.carrierMap.each { k1, v1 ->
            println "${k1}"
            println '--------'

            Network.carrierMap.get(k1).hubs.each { k2, v2 ->
                println "${k2}"
                println ''

                Network.carrierMap.get(k1).hubs.get(k2).nodes.each { k3, v3 ->
                    println "${k3}"
                    println ''

                }
            }
        }
    }
}
