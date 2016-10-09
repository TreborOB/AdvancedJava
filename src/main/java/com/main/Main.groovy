package com.main

import com.commands.*


/**
 * Created by robertobrien on 14/09/2016.
 */
public class Main extends Base {

    static def commands = [:]


    static void main(String[] args) {
        new PopulateValues().defaultValues() //Populates the network
        new Main().menus()
    }

    /**
     * The console menu
     *
     */
    void menus() {

        Command listEntireNetwork = new ListEntireNetworkCommand()
        Command statusOfNetwork = new StatusOfNetworkCommand()

        Command addCarrier = new AddCarrierCommand()
        Command deleteCarrier = new DeleteCarrierCommand()
        Command renameCarrier = new RenameCarrierCommand()
        Command listAllCarriers = new ListAllCarriersCommand()
        Command statusOfCarrier = new StatusOfCarrierCommand()

        Command addHub = new AddHubCommand()
        Command deleteHub = new DeleteHubCommand()
        Command renameHub = new RenameHubCommand()
        Command listAllHubs = new ListAllHubsCommand()
        Command statusOfHub = new StatusOfHubCommand()

        Command addNode = new AddNodeCommand()
        Command deleteNode = new DeleteNodeCommand()
        Command renameNode = new RenameNodeCommand()
        Command listAllNodes = new ListAllNodesCommand()
        Command statusOfNode = new StatusOfNodeCommand()

        Command createAlarm = new CreateAlarmCommand()
        Command clearAlarm = new ClearAlarmCommand()
        SuggestedRemediesCommand suggestedRemedies = new SuggestedRemediesCommand()

        Command importFromJson = new ImportFromJson()
        Command exportFromJson = new ExportToJson()


        commands.put('listNetwork', listEntireNetwork)
        commands.put('networkStatus', statusOfNetwork)

        commands.put('addCarrier', addCarrier)
        commands.put('deleteCarrier', deleteCarrier)
        commands.put('renameCarrier', renameCarrier)
        commands.put('listCarriers', listAllCarriers)
        commands.put('carrierStatus', statusOfCarrier)

        commands.put('addHub', addHub)
        commands.put('deleteHub', deleteHub)
        commands.put('renameHub', renameHub)
        commands.put('listHubs', listAllHubs)
        commands.put('hubStatus', statusOfHub)


        commands.put('addNode', addNode)
        commands.put('deleteNode', deleteNode)
        commands.put('renameNode', renameNode)
        commands.put('listNodes', listAllNodes)
        commands.put('nodeStatus', statusOfNode)

        commands.put('createAlarm', createAlarm)
        commands.put('clearAlarm', clearAlarm)
        commands.put('remedies', suggestedRemedies)


        commands.put('import', importFromJson)
        commands.put('export', exportFromJson)

        String mainMenuChoice = ''

        while (mainMenuChoice != '7') {
            println ''
            println 'DAS Network Manager'
            println '--------------------'
            println '1. Network menu'
            println '2. Carrier menu'
            println '3. Hub menu'
            println '4. Node menu'
            println '5. Alarm menu'
            println '6. Json'
            println '7. Exit\n'
            mainMenuChoice = input('Please make a selection (1-7): ')

            switch (mainMenuChoice) {

                case '1': networkMenu(); break
                case '2': carrierMenu(); break
                case '3': hubMenu(); break
                case '4': nodeMenu(); break
                case '5': alarmMenu(); break
                case '6': jsonMenu(); break
                default: 'Invalid selection'
            }
        }
    }


    public static networkMenu() {

        println ''
        println 'Network menu'
        println '-------------'
        println '1. List Entire Network'
        println '2. Network Status'
        println '3. Exit\n'
        def networkChoice = input('Please make a selection (1-3): ')


        switch (networkChoice) {
            case '1': commands.get('listNetwork').execute(); break
            case '2': commands.get('networkStatus').execute(); break
            default: println 'Main Menu\n'
        }
    }


    public static carrierMenu() {

        println ''
        println 'Carrier menu'
        println '-------------'
        println '1. Add Carrier'
        println '2. Delete Carrier'
        println '3. Rename Carrier'
        println '4. List Carriers'
        println '5. Carrier Status'
        println '6. Exit\n'
        def carrierChoice = input('Please make a selection (1-6): ')

        switch (carrierChoice) {
            case '1': commands.get('addCarrier').execute(); break
            case '2': commands.get('deleteCarrier').execute(); break
            case '3': commands.get('renameCarrier').execute(); break
            case '4': commands.get('listCarriers').execute(); break
            case '5': commands.get('carrierStatus').execute(); break
            default: println 'Main Menu\n'
        }
    }


    public static hubMenu() {

        println ''
        println 'Hub menu'
        println '---------'
        println '1. Add Hub'
        println '2. Delete Hub'
        println '3. Rename Hub'
        println '4. List Hubs'
        println '5. Hub Status'
        println '6. Exit\n'
        def hubChoice = input('Please make a selection (1-6): ')


        switch (hubChoice) {
            case '1':
                commands.get('addHub').execute(); break
            case '2': commands.get('deleteHub').execute(); break
            case '3': commands.get('renameHub').execute(); break
            case '4': commands.get('listHubs').execute(); break
            case '5': commands.get('hubStatus').execute(); break
            default: println 'Main Menu\n'

        }


    }

    public static nodeMenu() {

        println ''
        println 'Node menu'
        println '----------'
        println '1. Add Node'
        println '2. Delete Node'
        println '3. Rename Node'
        println '4. List Nodes'
        println '5. Node Status'
        println '6. Exit\n'
        def nodeChoice = input('Please make a selection (1-6): ')

        switch (nodeChoice) {
            case '1': commands.get('addNode').execute(); break
            case '2': commands.get('deleteNode').execute(); break
            case '3': commands.get('renameNode').execute(); break
            case '4': commands.get('listNodes').execute(); break
            case '5': commands.get('nodeStatus').execute(); break
            default: println 'Main Menu\n'
        }


    }

    public static alarmMenu() {
        println ''
        println 'Alarm menu'
        println '-----------'
        println '1. Create Alarm'
        println '2. Clear Alarm/s'
        println '3. View Remedies'
        println '4. Exit\n'
        def alarmChoice = input('Please make a selection (1-4): ')

        switch (alarmChoice) {
            case '1': commands.get('createAlarm').execute(); break
            case '2': commands.get('clearAlarm').execute(); break
            case '3': commands.get('remedies').execute(); break
            default: println 'Main Menu\n'

        }
    }


    public static jsonMenu() {
        println ''
        println 'Json menu'
        println '----------'
        println '1. Import'
        println '2. Export'
        println '3. Exit\n'
        def jsonChoice = input('Please make a selection (1-3): ')

        switch (jsonChoice) {
            case '1': commands.get('import').execute(); break
            case '2': commands.get('export').execute(); break
            default: println 'Main Menu\n'
        }
    }
}

