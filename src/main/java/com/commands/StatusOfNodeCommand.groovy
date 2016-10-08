package com.commands

import com.main.Base
import com.main.Network

/**
 * Created by robertobrien on 14/09/2016.
 */
def class StatusOfNodeCommand extends Base implements Command {


    def execute() {
        carrier()
    }

    /**
     * Prompts the user to select to a carrier
     *
     */
    def carrier() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? chosenHub(carrierName) : notExists(carrierName)
    }

    /**
     * Prompts the user to select a hub
     *
     * @param carrierName
     */
    def chosenHub(String carrierName) {

        listHubs(carrierName)
        println ''
        def hubName = input('Please enter the hub name: ')
        doesHubExist(carrierName, hubName) ? searchHubAvailability(carrierName, hubName) : notExists(hubName)

    }

    /**
     * Checks to see if the parent hub is unit available/unavailable as if the parent hub is available then all associated nodes are unavailable
     *
     * @param carrierName, hubName
     */
    def searchHubAvailability(String carrierName, String hubName) {

        def unit = 'Unit Unavailable'
        if(Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.alarmType.inject(false){ acc, value -> acc || unit.contains(value)}){
            println 'Hub is UNAVAILABLE thus all associated nodes are unavailable'
        }else{
            searchNode(carrierName, hubName)
            println 'Hub is AVAILABLE'
            return false
        }
    }

    /**
     * Prompts the user to select a node
     *
     * @param carrierName, hubName
     */
    def searchNode(String carrierName, String hubName){
        listNodes(carrierName, hubName)
        def nodeName = input('Please choose a node: ')
        doesNodeExist(carrierName, hubName, nodeName) ? nodeAvailabilty(carrierName, hubName, nodeName) : notExists(hubName)
    }


    /**
     * Checks to see if the selected node is unit available/unavailable
     *
     * @param carrierName
     * @return
     */
    def nodeAvailabilty(String carrierName, String hubName, String nodeName){
        def unit = 'Unit Unavailable'
        if(Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.alarmType.inject(false){ acc, value -> acc || unit.contains(value)}){
            println 'Node is UNAVAILABLE'
        }else{
            println 'Hub is AVAILABLE'
        }

    }
}
