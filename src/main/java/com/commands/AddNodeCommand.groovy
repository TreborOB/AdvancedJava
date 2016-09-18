package com.commands


import com.main.Base
import com.main.Carrier
import com.main.Network
import com.main.Node


/**
 * Created by robertobrien on 14/09/2016.
 */
public class AddNodeCommand extends Base implements Command {


    def execute() {
        node()
    }


    def node() {
        listCarriers()
        def carrierName = input("Enter the carriers name: ")
        doesCarrierExist(carrierName) ? nextHub(carrierName) : notExists(carrierName)
    }


    def nextHub(String carrierName) {
        listHubs(carrierName)
        def hubName = input("Enter the hubs name: ")
        doesHubExist(carrierName, hubName) ? node(carrierName, hubName) : notExists(hubName)

    }


    def node(String carrierName, String hubName) {
        listNodes(carrierName, hubName)
        def nodeName = input("Enter the nodes name: ")
        doesNodeExist(carrierName, hubName, nodeName) ? exists(nodeName) : nodeID(carrierName, hubName, nodeName)

    }


    def nodeID(String carrierName, String hubName, String nodeName) {
        def nodeID = input("Enter id for the node: ")
        doesNodeIdExist(carrierName, hubName, nodeID) ? addNode(carrierName, hubName, nodeName, nodeID) : exists(nodeID)
    }


    def addNode(String carrierName, String hubName, String nodeName, String nodeID) {

        Carrier c = Network.carrierMap.get(carrierName)
        Node node = new Node(nodeName, nodeID)

        c.hubs.get(hubName).nodes.put(node.getName(), node)

        println "Node $nodeName with an ID of $nodeID added"

    }


}
