package com.main


import com.commands.ListAllCarriersCommand
import com.commands.ListAllHubsCommand
import com.commands.ListAllNodesCommand
import groovy.transform.EqualsAndHashCode

/**
 * Created by robertobrien on 14/09/2016.
 */


@EqualsAndHashCode
class Base {


    def listCarriers() {
        println ''
        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand()
        listCarriers.listAllCarriers()
        println ''
    }


    def listHubs(String parentCarrier) {
        println ''
        ListAllHubsCommand listHubs = new ListAllHubsCommand()
        listHubs.listAllHubs(parentCarrier)
        println ''
    }

    def listNodes(String parentCarrier, String hubName) {
        println ''
        ListAllNodesCommand listNodes = new ListAllNodesCommand()
        listNodes.listAllNodes(parentCarrier, hubName)
        println ''
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

        boolean idCheck = true
        for (Map.Entry<String, Hub> entry : Network.carrierMap.get(carrierName).hubs.entrySet()) {
            idCheck = !entry.getValue().getId().equals(id)
        }
        return idCheck
    }


    def doesNodeIdExist(String carrierName, String hub, String Id) {

        boolean idCheck = true

        for (Map.Entry<String, Node> entry : Network.carrierMap.get(carrierName).hubs.get(hub).nodes.entrySet()) {

            idCheck = !entry.getValue().getId().equals(Id)
        }
        return idCheck
    }


    def exists(String existsAlready) {

        println ''
        println "$existsAlready already exists"
    }


    def notExists(String notExistsAlready) {

        println ''
        println "$notExistsAlready does not exists wihtin the system"
    }

    static def input = { prompt ->
        print prompt
        System.in.newReader().readLine()
    }


}