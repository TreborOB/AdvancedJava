package com.commands


import com.main.Alarm
import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class CreateAlarmCommand extends Base implements Command {


    def listHubs = new ListAllHubsCommand()
    def listNodes = new ListAllNodesCommand()

    def execute() {
        alarmCreation()
    }

    public alarmCreation() {
        listCarriers()

        def carrierName = input('Enter the new carriers name: ')

        doesCarrierExist(carrierName) ? hubOrNode(carrierName) : notExists(carrierName)

    }


    private hubOrNode(String carrierName) {


        def alarmOnHubOrNode = input('Would you like to create an alarm on a hub (1) or node(2)?: ')

        if (alarmOnHubOrNode.equals('1')) {
            createAlarmOnHub(carrierName)
        } else if (alarmOnHubOrNode.equals('2')) {
            createAlarmOnNode(carrierName)
        }
    }


    private createAlarmOnHub(String carrierName) {

        listHubs(carrierName)

        def hubName = input('Enter the hubs name: ')

        doesHubExist(carrierName, hubName) ? createHubAlarm(carrierName, hubName) : notExists(hubName)

    }


    private createAlarmOnNode(String carrier) {
        println ''
        println 'Alarm on node'

        println ''

        listHubs.listAllHubs(carrier)

        listHubs(carrier)

        def hubName = input('Choose a hub: ')

        if (doesHubExist(carrier, hubName)) {
            createNodeAlarm(carrier, hubName)
        } else {
            print 'No such hub: '
        }

    }


    private createHubAlarm(String carrier, String chosenHub) {

        Alarm hubAlarm

        hubAlarm = createAlarm()

        Network.carrierMap.get(carrier).hubs.get(chosenHub).hubAlarms.add(hubAlarm)

        println 'Alarm Created'
        println '--------------'
        println ''
        println "Hub: $chosenHub"
        println 'Alarm type: ' + hubAlarm.getAlarmType()
        println 'Creation Date: ' + hubAlarm.getAlarmReceivedDate()

    }


    private createNodeAlarm(String carrier, String hubName) {

        listNodes.listAllNodes(carrier, hubName)

        listNodes(carrier, hubName)

        def nodeName = input('Choose a node: ')

        if (doesNodeExist(carrier, hubName, nodeName)) {
            nodeAlarmCreation(carrier, hubName, nodeName)
        } else {
            print 'No such node: '
        }
    }


    def nodeAlarmCreation(String carrier, String hubName, String nodeName) {

        Alarm nodeAlarm
        nodeAlarm = createAlarm()

        Network.carrierMap.get(carrier).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.add(nodeAlarm)

        println 'Alarm Created'
        println '--------------'
        println ''
        println 'Node: ' + nodeName + '\n' + 'Alarm type: ' + nodeAlarm.getAlarmType() + '\n' + 'Creation Date: ' + nodeAlarm.getAlarmReceivedDate()
    }


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

            case '1':
                alarmType = 'Unit unavailable'
                alarmRemedy = 'Unit unavailable remedy'
                break

            case '2':
                alarmType = 'Optical loss'
                alarmRemedy = 'Optical loss remedy'
                break

            case '3':
                alarmType = 'Dark fibre'
                alarmRemedy = 'Dark fibre remedy'
                break

            case '4':
                alarmType = 'Power outage'
                alarmRemedy = 'Power outage remedy'
                break

            default:
                alarmType = 'Default'
                alarmRemedy = 'Default remedy'
        }
        Date date = new Date()
        return new Alarm(alarmType, alarmRemedy, date)
    }
}
