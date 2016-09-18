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


    def clearAlarm() {
        listCarriers()

        def carrierName = input('Enter the carriers name: ')

        doesCarrierExist(carrierName) ? alarmOnHubOrNode(carrierName) : notExists(carrierName)
    }


    private alarmOnHubOrNode(String carrierName) {

        println ''
        def hubOrNode = input('Would you like to clear alarms from a hub (1) or node (2): ')


        switch (hubOrNode) {
            case '1':
                clearHubAlarm(carrierName)
                break

            case '2':
                clearNodeAlarm(carrierName)
                break
            default:
                print 'Invalid selection '
        }

        return hubOrNode
    }


    def clearHubAlarm(String carrierName) {

        listHubs(carrierName)
        println ''

        def hubName = input('Please choose a hub: ')

        doesHubExist(carrierName, hubName) ? allOrSpecific(carrierName, hubName) : notExists(hubName)

    }


    def allOrSpecific(String carrierName, String hubName) {

        println ''

        print 'Would you like to clear all alarms (1) or only specific alarms (2) from the hub?: '

        def allOrSpecific = input('Enter the carriers name: ')

        if (allOrSpecific == '1') {

            clearAllHubAlarms(carrierName, hubName)

        } else if (allOrSpecific == '2') {

            clearSpecificHubAlarms(carrierName, hubName)

        } else {
            print 'Invalid selection'
        }


    }


    def clearAllHubAlarms(String carrierName, String hubName) {

        Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.clear()


        println 'All hub alarms cleared'
    }


    def clearSpecificHubAlarms(String carrierName, String hubName) {

        String specificAlarmHub = specificAlarmToRemove()

        def n = Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size() - 1
        n.times {
            if (Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(n - 1).getAlarmType().equalsIgnoreCase(specificAlarmHub)) {
                Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.remove(n - 1)
                System.out.print(specificAlarmHub + ' alarm removed')
                println "$specificAlarmHub alarm removed"

            } else {
                println "No such alarm on $hubName"
            }
        }


    }


    def clearNodeAlarm(String carrierName) {

        listHubs(carrierName)
        println ''

        def hubName = input('please choose a hub: ')

        if (doesHubExist(carrierName, hubName)) {
            node(carrierName, hubName)
        } else {
            print 'No such hub'
        }
    }


    def node(String carrierName, String hubName) {

        listNodes(carrierName, hubName)

        println ''

        def nodeName = input('Please choose a node: ')

        doesNodeIdExist(carrierName, hubName, nodeName) ? allOrSpec(carrierName, hubName, nodeName) : notExists(nodeName)
    }

    def allOrSpec(String carrierName, String hubName, String nodeName) {

        println ''

        def allOrSpecific = input('Would you like to clear all alarms (1) or only specific alarms (2) from the node?: ')

        if (allOrSpecific.equals('1')) {

            clearAllNodeAlarms(carrierName, hubName, nodeName)

        } else if (allOrSpecific.equals('2')) {

            clearSpecificNodeAlarms(carrierName, hubName, nodeName)

        } else {
            print 'Invalid selection'
        }
    }


    def clearAllNodeAlarms(String carrierName, String hubName, String nodeName) {

        Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.clear()

        println 'Alarms cleared'
    }


    def clearSpecificNodeAlarms(String carrierName, String hubName, String nodeName) {

        String specificAlarmNode


        specificAlarmNode = specificAlarmToRemove()


        if (Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.isEmpty()) {

            println 'No alarms available'

        } else {
            for (int i in Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.size() - 1) {
                System.out.println('')
                if (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmType().equalsIgnoreCase(specificAlarmNode)) {
                    Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.remove(i)
                    println "$specificAlarmNode alarm removed"
                }
            }
        }
    }


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

            case '1':
                alarmToRemove = 'Unit unavailable'
                break
            case '2':
                alarmToRemove = 'Optical loss'
                break
            case '3':
                alarmToRemove = 'Dark fibre'
                break
            case '4':
                alarmToRemove = 'Power outage'
                break
            default:
                alarmToRemove = 'No selection'
        }
        return alarmToRemove
    }
}
