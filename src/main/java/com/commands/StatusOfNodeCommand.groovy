package com.commands


import com.main.Base
import com.main.Network
import com.main.Node


/**
 * Created by robertobrien on 14/09/2016.
 */
def class StatusOfNodeCommand extends Base implements Command {


    def execute() {
        carrier()
    }

    def carrier() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? chosenHub(carrierName) : notExists(carrierName)
    }

    def chosenHub(String carrierName) {

        listHubs(carrierName)
        println ''
        def hubName = input('Please enter the hub name: ')
        doesHubExist(carrierName, hubName) ? searchAvailability(carrierName, hubName) : notExists(hubName)

    }


    def searchAvailability(String carrier, String hubName) {

        String unitAvailability = ""

        for (int i in Network.carrierMap.get(carrier).hubs.get(hubName).getHubAlarms().size() - 1) {
            if (Network.carrierMap.get(carrier).hubs.get(hubName).getHubAlarms().get(i).getAlarmType().equalsIgnoreCase("Unit unavailable")) {
                print 'Parent hub is unavailable thus all its children are unavailable'
            } else {
                searchByNameOrID(carrier, hubName)
            }
        }
        return unitAvailability
    }


    def searchByNameOrID(String carrierName, String hubName) {

        listNodes(carrierName, hubName)
        def nodeName = input('Please enter the name or id the node you would like to search for: ')
        doesNodeExist(carrierName, hubName, nodeName) || doesNodeIdExist(carrierName, hubName, nodeName) ? check(carrierName, hubName, nodeName) : notExists(hubName)

    }


    def check(String carrierName, String hubName, String nodeName) {

        Node node
        String availableUnavailable

        if (Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.isEmpty()) {
            println 'There are no active alarms for this node'
        } else {

            for (int i in Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size()-1) {
                println ''

                if (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmType().equalsIgnoreCase("Unit unavailable")) {
                    availableUnavailable = "Unit unavailable"
                } else {
                    availableUnavailable = "Unit available"
                }

                for (Map.Entry<String, Node> entry : Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.entrySet()) {
                    if (entry.getValue().getName().equals(nodeName)) {

                        node = entry.getValue()
                        println ''
                        println 'node name: ' + node.getName()
                        println 'node id: ' + node.getId()
                        println 'node status: ' + availableUnavailable
                    }
                }
                        break;
            }
        }
    }
}
