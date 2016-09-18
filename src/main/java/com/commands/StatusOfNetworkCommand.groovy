package com.commands


import com.main.*


/**
 * Created by robertobrien on 14/09/2016.
 */
class StatusOfNetworkCommand extends Base implements Command {


    def execute() {
        viewAlarmStatusOfNetwork()
    }


    def viewAlarmStatusOfNetwork() {

        println ''

        String hubs
        String nodes

        if (Network.carrierMap.size() == 0) {
            println 'The network is empty'
        } else {
            for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
                hubs = entry.getKey()
                println 'Carrier name: ' + entry.getValue().getName()


                for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {
                    nodes = entryHub.getKey()
                    println 'Hub alarms: ' + entryHub.getValue().hubAlarms.size()

                    for (Map.Entry<String, Node> entryNode : Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet()) {
                        println 'Node alarms: ' + entryNode.getValue().nodeAlarms.size()

                    }
                }
                System.out.println("")
            }
        }
        System.out.println("")
    }
}