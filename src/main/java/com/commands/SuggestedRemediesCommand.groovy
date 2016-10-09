package com.commands


import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class SuggestedRemediesCommand extends Base implements Command {

    /**
     * Prints out all the suggested remedies for each network element
     *
     */
    def execute() {

        if (!Network.carrierMap) {
            println 'Network is empty'
        } else {
            Network.carrierMap.each { k1, v1 ->
                println "\n${k1}"
                println '--------'

                Network.carrierMap.get(k1).hubs.each { k2, v2 ->
                    println "$k2: " + Network.carrierMap.get(k1).hubs.get(k2).hubAlarms.alarmRemedy.toString()

                    Network.carrierMap.get(k1).hubs.get(k2).nodes.each { k3, v3 ->
                        println "$k3: " + Network.carrierMap.get(k1).hubs.get(k2).nodes.get(k3).nodeAlarms.alarmRemedy.toString()
                        println ''

                    }
                }
            }
        }
    }

}
