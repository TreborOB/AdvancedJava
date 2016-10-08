package com.commands

import com.main.Base
import com.main.Network

/**
 * Created by robertobrien on 14/09/2016.
 */
class ClearAlarmCommand extends Base implements Command {


    def execute() {
        clearAlarm()
    }

    /**
     * Prompts the user to enter the carriers name
     *
     */
    def clearAlarm() {
        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? alarmOnHubOrNode(carrierName) : notExists(carrierName)
    }


    /**
     * Prompts the user to select to clear an alarm from a hub or node
     *
     * @param carrierName
     * @return
     */
    def alarmOnHubOrNode(String carrierName) {
        println ''
        def hubOrNode = input('Would you like to clear alarms from a hub (1) or node (2): ')

        switch (hubOrNode) {
            case '1': clearHubAlarm(carrierName);break
            case '2': clearNodeAlarm(carrierName);break
            default: print 'Invalid selection'
        }
        return hubOrNode
    }

    /**
     * Prompts the user to select a hub from which to clear alarm/s
     *
     * @param carrierName
     */
    def clearHubAlarm(String carrierName) {

        listHubs(carrierName)
        println ''

        def hubName = input('Please choose a hub: ')
        doesHubExist(carrierName, hubName) ? allOrSpecific(carrierName, hubName) : notExists(hubName)

    }


    /**
     * Prompts the user to select to clear all of specific alarm types on a hub
     *
     * @param carrierName, hubName
     */
    def allOrSpecific(String carrierName, String hubName) {

        def allOrSpecific = input('Would you like to clear all alarms (1) or only specific alarms (2) from the hub?:')
        switch (allOrSpecific) {
            case '1': clearAllHubAlarms(carrierName, hubName);break
            case '2': clearSpecificHubAlarms(carrierName, hubName);break
            default: print 'Invalid selection '
        }


    }


    /**
     * Clears all alarms on a hub
     *
     * @param carrierName, hubName
     */
    def clearAllHubAlarms(String carrierName, String hubName) {

        Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.clear()
        println 'All hub alarms cleared'
    }


    /**
     * Clears specific alarm types on a hub
     *
     * @param carrierName, hubName
     */
    def clearSpecificHubAlarms(String carrierName, String hubName) {

        String specificAlarmHub = specificAlarmToRemove()

        Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.removeAll {
            (it.alarmType == specificAlarmHub)
        }
        println "Alarm type $specificAlarmHub removed"

    }


    /**
     * Prompts the user to select a hub
     *
     * @param carrierName
     */
    def clearNodeAlarm(String carrierName) {

        listHubs(carrierName)
        def hubName = input('please choose a hub: ')

        doesHubExist(carrierName, hubName) ? node(carrierName, hubName) :  notExists(hubName)

    }


    /**
     * Prompts the user to select to a node
     *
     * @param carrierName, hubName
     */
    def node(String carrierName, String hubName) {

        listNodes(carrierName, hubName)
        println ''

        def nodeName = input('Please choose a node: ')
        doesNodeIdExist(carrierName, hubName, nodeName) ? allOrSpec(carrierName, hubName, nodeName) : notExists(nodeName)
    }


    /**
     * Prompts the user to select to clear all of a specific alarm types on a node
     *
     * @param carrierName, hubName, nodeName
     */
    def allOrSpec(String carrierName, String hubName, String nodeName) {

        println ''

        def allOrSpecific = input('Would you like to clear all alarms (1) or only specific alarms (2) from the node?: ')


        switch (allOrSpecific) {
            case '1':
                clearAllNodeAlarms(carrierName, hubName, nodeName)
                break
            case '2':
                clearSpecificNodeAlarms(carrierName, hubName, nodeName)
                break
            default:
                print 'Invalid selection '
        }
    }


    /**
     * Prompts the user to select to clear an alarm from a hub or node
     *
     * @param carrierName, hubName, nodeName
     */
    def clearAllNodeAlarms(String carrierName, String hubName, String nodeName) {

        Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.clear()
        println 'Alarms cleared'
    }


    /**
     * Removes a specific alarm type on a node
     *
     * @param carrierName, hubName, nodeName
     */
    def clearSpecificNodeAlarms(String carrierName, String hubName, String nodeName) {

        String specificAlarmHub = specificAlarmToRemove()

        Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.removeAll{
            (it.alarmType == specificAlarmHub)
        }
        println "Alarm type $specificAlarmHub removed"
    }


    /**
     * Prompts the user to choosen which specific alarm type is to be removed from the network element
     *
     * @return
     */
    def specificAlarmToRemove() {

        println ''
        println 'Please choose the number of the alarm type you would like to remove'
        println '1. Unit unavailable'
        println '2. Optical Loss'
        println '3. Dark Fibre'
        println '4. Power Outage'
        def choice = input('Choose an alarm type to clear (1-4): ')

        String alarmToRemove

        switch (choice) {
            case '1': alarmToRemove = 'Unit unavailable';break
            case '2': alarmToRemove = 'Optical loss';break
            case '3': alarmToRemove = 'Dark fibre';break
            case '4': alarmToRemove = 'Power outage';break
            default: alarmToRemove = 'No selection'
        }
        return alarmToRemove
    }
}
