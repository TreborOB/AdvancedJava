package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class StatusOfNetworkCommand extends Base implements Command {


    def execute() {
        viewAlarmStatusOfNetwork()
    }

    /**
     * Prints out the number of alarms on each carrier
     *
     */
    def viewAlarmStatusOfNetwork() {

        if(!Network.carrierMap){
            println 'Network is empty'
        }else {
            Network.carrierMap.each { k1, v1 ->
                println "${k1}"
                println '--------'

                Network.carrierMap.get(k1).hubs.each { k2, v2 ->
                    println "No of alarms on $k2: " +  Network.carrierMap.get(k1).hubs.get(k2).hubAlarms.size()

                    Network.carrierMap.get(k1).hubs.get(k2).nodes.each { k3, v3 ->
                        println "No of alarms on $k3: " + Network.carrierMap.get(k1).hubs.get(k2).nodes.get(k3).nodeAlarms.size()
                        println ''

                    }
                }
            }
        }
    }
}
