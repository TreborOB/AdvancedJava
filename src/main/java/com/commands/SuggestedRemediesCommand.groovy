package com.commands


import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
class SuggestedRemediesCommand extends Base implements Command {

    private Scanner scan = new Scanner(System.in)

    def execute() {
        alarm()
    }


    def alarm() {
        println ''

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? remedies(carrierName) : notExists(carrierName)
    }


    def remedies(String carrierName) {


        println ''
        print 'Would you like to view remedies for a hub (1) or node (2) ?: '
        String chosenElement = scan.nextLine()


        if (chosenElement == '1') {
            hubRemedies(carrierName)

        } else if (chosenElement == '2') {
            nodeRemedies(carrierName)
        } else {
            println ''
            print 'invalid input'
        }
    }


    def hubRemedies(String carrierName) {

        println ''

        listHubs(carrierName)

        def hubName = input('Choose a hub: ')

        if (doesHubExist(carrierName, hubName)) {

            for (int i in Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size() - 1) {
                println ''
                println('Alarm: ' + Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmType() +
                        '\nRemedy: ' + Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmRemedy()
                        + '\nAlarm creation date: ' + Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmReceivedDate())
            }
        } else {
            println 'No such hub'
        }
    }


    def nodeRemedies(String carrierName) {
        println ''

        listHubs(carrierName)
        def hubName = input('Choose a hub: ')
        doesHubExist(carrierName, hubName) ? chooseNode(carrierName, hubName) : exists(hubName)
    }

    def chooseNode(String carrierName, String hubName) {

        listNodes(carrierName, hubName)

        println ''

        def nodeName = input('Enter the nodes name: ')

        if (doesNodeExist(carrierName, hubName, nodeName)) {
            for (int i in Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size()) {
                println ''
                println('Alarm: ' + Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmType() +
                        '\nRemedy: ' + Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmRemedy()
                        + '\nAlarm creation date: ' + Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).alarmReceivedDate)
            }
        } else {
            print 'No such node'
        }
    }
}
