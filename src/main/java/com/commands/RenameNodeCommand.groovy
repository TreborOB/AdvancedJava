package com.commands

import com.main.Base
import com.main.Network

/**
 * Created by robertobrien on 14/09/2016.
 */
public class RenameNodeCommand extends Base implements Command {


    def execute() {
        rename()
    }

    /**
     * Prompts the user to select a carrier
     *
     */
    def rename() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? renameHub(carrierName) : notExists(carrierName)
    }

    /**
     * Prompts the user to select a hub
     *
     * @param carrierName
     */
    def renameHub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Enter the name of the hub: ')
        doesHubExist(carrierName, hubName) ? node(carrierName, hubName) : notExists(hubName)
    }

    /**
     * Prompts the user to select to a node
     *
     * @param carrierName, hubName
     */
    def node(String carrierName, String hubName) {

        listNodes(carrierName, hubName)
        def nodeName = input('Enter the node name: ')
        doesNodeExist(carrierName, hubName, nodeName) ? newName(carrierName, hubName, nodeName) : notExists(hubName)
    }

    /**
     * Prompts the user to select a new name for the node
     *
     * @param carrierName, hubName, nodeName
     */
    def newName(String carrierName, String hubName, String nodeName) {

        def newNodeName = input('Enter a new name for the node: ')
        doesNodeExist(carrierName, hubName, nodeName) ? renameNode(carrierName, hubName, nodeName, newNodeName)
                                                      : exists(hubName)
    }

    /**
     * Renames the selected node
     *
     * @param carrierName, hub, node, newNodeName
     * @return
     */
    def void renameNode(String carrier, String hub, String node, String newNodeName) {

        def n = Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(node)
        n.setName(newNodeName)

        newNodeName ? Network.carrierMap.get(carrier).hubs.get(hub).nodes.put(newNodeName.println("Node $node has been renamed to $newNodeName"), n)
                    : println('No new node entered')

    }
}
