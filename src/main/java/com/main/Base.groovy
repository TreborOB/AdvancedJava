package com.main


import com.commands.ListAllCarriersCommand
import com.commands.ListAllHubsCommand
import com.commands.ListAllNodesCommand
import groovy.transform.EqualsAndHashCode

/**
 * Created by robertobrien on 14/09/2016.
 */


@EqualsAndHashCode(includeFields=true)
class Base {


    def listCarriers() {

        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand()
        listCarriers.listAllCarriers()
    }

    def listHubs(String parentCarrier) {

        ListAllHubsCommand listHubs = new ListAllHubsCommand()
        listHubs.listAllHubs(parentCarrier)

    }

    def listNodes(String parentCarrier, String hubName) {

        ListAllNodesCommand listNodes = new ListAllNodesCommand()
        listNodes.listAllNodes(parentCarrier, hubName)
    }


    def doesCarrierExist(String carrierName) {
        return Network.carrierMap.containsKey(carrierName)
    }

    def doesHubExist(String carrierName, String hubName) {
        return Network.carrierMap.get(carrierName).hubs.containsKey(hubName)
    }


    def doesNodeExist(String carrierName, String hubName, String nodeName) {
        return Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName)
    }


    def doesHubIDExist(String carrierName, String id) {

        def idCheck = true
        for (Map.Entry<String, Hub> entry : Network.carrierMap.get(carrierName).hubs.entrySet()) {
            idCheck = entry.getValue().getId() != id}
        return idCheck
    }


    def doesNodeIdExist(String carrierName, String hub, String Id) {

            def idCheck = true
            for (Map.Entry<String, Node> entry : Network.carrierMap.get(carrierName).hubs.get(hub).nodes.entrySet()) {
                idCheck = entry.getValue().getId() != Id}
            return idCheck
    }


    def exists(String existsAlready) {
        println "$existsAlready already exists"
    }


    def notExists(String notExists) {

        println "$notExists does not exist within the system"
    }

    static def input = { prompt ->
        print prompt
        System.in.newReader().readLine()
    }
}