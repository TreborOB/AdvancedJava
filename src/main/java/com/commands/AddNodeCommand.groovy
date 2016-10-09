package com.commands

import com.main.Base
import com.main.Network
import com.main.Node

/**
 * Created by robertobrien on 14/09/2016.
 */
class AddNodeCommand extends Base implements Command {


    /**
     * Prompts the user to enter the carriers name
     *
     */
    def execute() {
        listCarriers()
        def carrierName = input("Enter the carriers name: ")
        doesCarrierExist(carrierName) ? nextHub(carrierName)
                : notExists(carrierName)
    }


    /**
     * Prompts the user to enter the new hubs name
     *
     * @param carrierName
     */
    def nextHub(String carrierName) {
        listHubs(carrierName)
        def hubName = input("Enter the hubs name: ")
        doesHubExist(carrierName, hubName) ? node(carrierName, hubName)
                : notExists(hubName)

    }

    /**
     * Prompts the user to enter the new nodes name
     *
     * @param carrierName , hubName
     */
    def node(String carrierName, String hubName) {
        listNodes(carrierName, hubName)
        def nodeName = input("Enter the nodes name: ")
        doesNodeExist(carrierName, hubName, nodeName) ? exists(nodeName)
                : nodeID(carrierName, hubName, nodeName)

    }

    /**
     * Prompts the user to enter the new nodes ID
     *
     * @param carrierName , hubName, nodeName
     */
    def nodeID(String carrierName, String hubName, String nodeName) {
        def nodeID = input("Enter id for the node: ")
        doesNodeIdExist(carrierName, hubName, nodeID) ? addNode(carrierName, hubName, nodeName, nodeID)
                : exists(nodeID)
    }

    /**
     * Adds the node to the network
     *
     * @param carrierName , hubName, nodeName, nodeID
     */
    def addNode(String carrierName, String hubName, String nodeName, String nodeID) {
        Node node = new Node(nodeName, nodeID)
        nodeName ? (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.put(node.getName().println("Node $nodeName with an ID of $nodeID added"), node))
                : println('No node entered')
    }
}
