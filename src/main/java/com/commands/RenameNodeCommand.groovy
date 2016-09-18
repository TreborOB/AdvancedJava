package com.commands


import com.main.Base
import com.main.Network
import com.main.Node


/**
 * Created by robertobrien on 14/09/2016.
 */
public class RenameNodeCommand extends Base implements Command {


    def execute() {
        rename()
    }


    def rename() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? renameHub(carrierName) : notExists(carrierName)
    }


    def renameHub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Enter the name of the hub: ')
        doesHubExist(carrierName, hubName) ? node(carrierName, hubName) : notExists(hubName)
    }


    def node(String carrierName, String hubName) {

        listNodes(carrierName, hubName)
        def nodeName = input('Enter the node name: ')
        doesNodeExist(carrierName, hubName, nodeName) ? newName(carrierName, hubName, nodeName) : notExists(hubName)
    }


    def newName(String carrierName, String hubName, String nodeName) {

        def newNodeName = input('Enter a new name for the node: ')
        doesNodeExist(carrierName, hubName, nodeName) ? renameNode(carrierName, hubName, nodeName, newNodeName) : exists(hubName)
    }


    def void renameNode(String carrier, String hub, String node, String newNodeName) {

        Node n = Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(node)
        n.setName(newNodeName)
        Network.carrierMap.get(carrier).hubs.get(hub).nodes.put(newNodeName, n)
        println "Node $node has been renamed to $newNodeName"

    }


}
