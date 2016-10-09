package com.main


import com.commands.ListAllCarriersCommand
import com.commands.ListAllHubsCommand
import com.commands.ListAllNodesCommand
import groovy.transform.EqualsAndHashCode

/**
 * Created by robertobrien on 14/09/2016.
 */


@EqualsAndHashCode(includeFields = true)
class Base {

    /**
     * Prints out all of the carriers
     *
     */
    def listCarriers() {

        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand()
        listCarriers.execute()
    }

    /**
     * Prints out all of the hubs for a selected carrier
     *
     * @param carrierName
     */
    def listHubs(String parentCarrier) {

        ListAllHubsCommand listHubs = new ListAllHubsCommand()
        listHubs.listAllHubs(parentCarrier)

    }

    /**
     * Prints out all of the nodes for a selected hub
     *
     * @param carrierName , hubName
     */
    def listNodes(String parentCarrier, String hubName) {

        ListAllNodesCommand listNodes = new ListAllNodesCommand()
        listNodes.listAllNodes(parentCarrier, hubName)
    }

    /**
     * Checks to see if a carrier already exists
     *
     * @param carrierName
     * @return
     */
    def doesCarrierExist(String carrierName) {
        return Network.carrierMap.containsKey(carrierName)
    }

    /**
     * Checks to see if a hub already exists
     *
     * @param carrierName , hubName
     * @return
     */
    def doesHubExist(String carrierName, String hubName) {
        return Network.carrierMap.get(carrierName).hubs.containsKey(hubName)
    }

    /**
     * Checks to see if a node already exists
     *
     * @param carrierName , hubName, nodeName
     * @return
     */
    def doesNodeExist(String carrierName, String hubName, String nodeName) {
        return Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName)
    }

    /**
     * Checks to see if a specified hub id already exists
     *
     * @param carrierName , id
     * @return
     */
    def doesHubIDExist(String carrierName, String id) {

        def idCheck = true
        for (Map.Entry<String, Hub> entry : Network.carrierMap.get(carrierName).hubs.entrySet()) {
            idCheck = entry.getValue().getId() != id
        }
        return idCheck
    }

    /**
     * Checks to see if a specified node id already exists
     *
     * @param carrierName , hubName
     * @return
     */
    def doesNodeIdExist(String carrierName, String hubName, String Id) {

        def idCheck = true
        for (Map.Entry<String, Node> entry : Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.entrySet()) {
            idCheck = entry.getValue().getId() != Id
        }
        return idCheck
    }

    /**
     * Message printed if an element with the specified name already exists
     *
     * @param existsAlready
     */
    def exists(String existsAlready) {
        println "$existsAlready already exists"
    }

    /**
     * Message printed if an element with the specified name does not exist
     *
     * @param carrierName , hubName
     */
    def notExists(String notExists) {
        println "$notExists does not exist within the system"
    }

    /**
     * Takes in a value from the user based on a command line prompt (which is 'prompt' in this case. Eliminates the need for Scanner for input.
     *
     * @param carrierName , hubName
     */
    static def input = { prompt ->
        print prompt
        System.in.newReader().readLine()
    }
}