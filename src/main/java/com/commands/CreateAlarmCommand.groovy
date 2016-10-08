package com.commands


import com.main.Alarm
import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class CreateAlarmCommand extends Base implements Command {


    def execute() {
        alarmCreation()
    }


    /**
     * Prompts the user to select a carrier
     *
     */
    def alarmCreation() {
        listCarriers()

        def carrierName = input('Enter the new carriers name: ')
        doesCarrierExist(carrierName) ? hubOrNode(carrierName) : notExists(carrierName)

    }

    /**
     * Prompts the user to select to create an alarm on a hub or node
     *
     * @param carrierName
     * @return
     */
    def hubOrNode(String carrierName) {

        def alarmOnHubOrNode = input('Would you like to create an alarm on a hub (1) or node (2)?: ')

        switch (alarmOnHubOrNode) {
        case '1': createAlarmOnHub(carrierName); break
        case '2': createAlarmOnNode(carrierName); break
        default: print 'Invalid selection'}
    }


    /**
     * Prompts the user to select to a hub
     *
     * @param carrierName
     */
    def createAlarmOnHub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Enter the hubs name: ')
        doesHubExist(carrierName, hubName) ? createHubAlarm(carrierName, hubName) : notExists(hubName)
    }


    /**
     * Prompts the user to select a hub
     *
     * @param carrierName
     */
     def createAlarmOnNode(String carrier) {
        println 'Alarm on node'

        listHubs(carrier)
        def hubName = input('Choose a hub: ')
        doesHubExist(carrier, hubName) ? createNodeAlarm(carrier, hubName) : notExists('No such hub: ' + "$hubName")

    }


    /**
     * Creates an alarm on a hub
     *
     * @param carrierName, hubName
     */
    def createHubAlarm(String carrier, String hubName) {

        Alarm hubAlarm
        hubAlarm = createAlarm()

        Network.carrierMap.get(carrier).hubs.get(hubName).hubAlarms.add(hubAlarm)

        println 'Alarm Created'
        println '--------------\n'
        println "Hub: $hubName"
        println 'Alarm type: ' + hubAlarm.getAlarmType()
        println 'Creation Date: ' + hubAlarm.getAlarmReceivedDate()
    }


    /**
     * Prompts the user to select a node
     *
     * @param carrierName, hubName
     */
    def createNodeAlarm(String carrier, String hubName) {

        listNodes(carrier, hubName)
        def nodeName = input('Choose a node: ')
        doesNodeExist(carrier, hubName, nodeName) ? nodeAlarmCreation(carrier, hubName, nodeName) : notExists('No such node: ' + "$nodeName")
    }


    /**
     * Creates an alarm on a node
     *
     * @param carrierName, hubName, nodeName
     */
    def nodeAlarmCreation(String carrier, String hubName, String nodeName) {

        Alarm nodeAlarm
        nodeAlarm = createAlarm()

        Network.carrierMap.get(carrier).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.add(nodeAlarm)

        println 'Alarm Created\n' + println '--------------\n'
        println 'Node: ' + nodeName + '\n' + 'Alarm type: ' + nodeAlarm.getAlarmType() + '\n' + 'Creation Date: ' + nodeAlarm.getAlarmReceivedDate()
    }


    /**
     * Prompts the user to choosen which specific alarm type to create
     *
     * @param Id
     * @return
     */
    def createAlarm() {

        String alarmType
        String alarmRemedy

        println ''
        println 'Please choose an alarm type (1-4): '
        println '1. Unit unavailable '
        println '2. Optical loss '
        println '3. Dark fibre '
        println '4. Power outage '
        def chosenAlarm = input('Choose an alarm type (1-4): ')

        switch (chosenAlarm) {
            case '1': alarmType = 'Unit unavailable'
                      alarmRemedy = 'Unit unavailable remedy';break
            case '2': alarmType = 'Optical loss'
                      alarmRemedy = 'Optical loss remedy';break
            case '3': alarmType = 'Dark fibre'
                      alarmRemedy = 'Dark fibre remedy';break
            case '4': alarmType = 'Power outage'
                      alarmRemedy = 'Power outage remedy';break
            default: alarmType = 'Default'
                     alarmRemedy = 'Default remedy'
        }

        Date date = new Date()
        return new Alarm(alarmType, alarmRemedy, date)
    }
}
