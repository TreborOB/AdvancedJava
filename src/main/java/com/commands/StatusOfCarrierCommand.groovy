package com.commands

import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class StatusOfCarrierCommand extends Base implements Command {


    def execute() {
        status()
    }

    /**
     * Prompts the user to select to a carrier
     *
     */
    public status() {

        listCarriers()
        def carrierName = input('Please enter the carrier name: ')
        doesCarrierExist(carrierName) ? carrierStatus() : notExists(carrierName)
    }

    /**
     * Prints out the number of alarms currently on each carriers network
     *
     */
    def carrierStatus() {

        if(!Network.carrierMap){
            println 'Network is empty'
        }else {
            Network.carrierMap.each{ k1, v1 ->
                println "${k1}"
                println '--------'

                Network.carrierMap.get(k1).hubs.each { k2, v2 ->
                    println "No of alarms on $k2: " + Network.carrierMap.get(k1).hubs.get(k2).hubAlarms.size()

                    Network.carrierMap.get(k1).hubs.get(k2).nodes.each { k3, v3 ->
                        println "No of alarms on $k3: " + Network.carrierMap.get(k1).hubs.get(k2).nodes.get(k3).nodeAlarms.size()
                        println ''

                    }
                }
            }
        }

    }
}
