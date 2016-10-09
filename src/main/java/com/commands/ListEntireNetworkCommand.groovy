package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class ListEntireNetworkCommand extends Base implements Command {


    def execute() {

        if (!Network.carrierMap) {
            println 'Network is empty'
        } else {
            Network.carrierMap.each { k1, v1 ->
                println "\n${k1}"
                println '--------'

                Network.carrierMap.get(k1).hubs.each { k2, v2 ->
                    println Network.carrierMap.get(k1).hubs.get(k2).name

                    Network.carrierMap.get(k1).hubs.get(k2).nodes.each { k3, v3 ->
                        println Network.carrierMap.get(k1).hubs.get(k2).nodes.get(k3).name
                        println ''

                    }
                }
            }
        }
    }
}
