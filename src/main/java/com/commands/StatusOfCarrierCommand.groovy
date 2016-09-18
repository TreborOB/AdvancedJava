package com.commands


import com.main.*


/**
 * Created by robertobrien on 14/09/2016.
 */
class StatusOfCarrierCommand extends Base implements Command {


    def execute() {
        status()
    }


    public status() {

        listCarriers()
        def carrierName = input('Please enter the carrier name: ')
        doesCarrierExist(carrierName) ? carrierStatus(carrierName) : notExists(carrierName)
    }


    def carrierStatus(String carrier) {

        String hubs
        String nodes
        System.out.println("")

        if (Network.carrierMap.size() == 0) {
            println 'The network is empty'
        } else {
            for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
                hubs = entry.getKey()

                if (hubs.equalsIgnoreCase(carrier)) {
                    println 'Carrier name: ' + entry.getValue().getName()


                    for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {
                        nodes = entryHub.getKey()
                        println 'Hub alarms: ' + entryHub.getValue().hubAlarms.size()


                        for (Map.Entry<String, Node> entryNode : Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet()) {
                            println 'Node alarms: ' + entryNode.getValue().nodeAlarms.size()

                        }
                    }
                }
            }
        }
    }
}
