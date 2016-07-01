package com.main;

import com.commands.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static Map<String, Command> commands = new HashMap<>();


    public static void main(String[] args) {

        Main main = new Main();
        main.populateValues();


        Command listEntireNetwork = new ListEntireNetworkCommand();
        Command statusOfNetwork = new StatusOfNetworkCommand();


        Command addCarrier = new AddCarrierCommand();
        Command deleteCarrier = new DeleteCarrierCommand();
        Command renameCarrier = new RenameCarrierCommand();
        Command listAllCarriers = new ListAllCarriersCommand();
        Command statusOfCarrier = new StatusOfCarrierCommand();

        Command addHub = new AddHubCommand();
        Command deleteHub = new DeleteHubCommand();
        Command renameHub = new RenameHubCommand();
        Command listAllHubs = new ListAllHubsCommand();
        Command statusOfHub = new StatusOfHubCommand();


        Command addNode = new AddNodeCommand();
        Command deleteNode = new DeleteNodeCommand();
        Command renameNode = new RenameNodeCommand();
        Command listAllNodes = new ListAllNodesCommand();
        Command statusOfNode = new StatusOfNodeCommand();

        Command createAlarm = new CreateAlarmCommand();
        Command clearAlarm = new ClearAlarmCommand();
        SuggestedRemediesCommand suggestedRemedies = new SuggestedRemediesCommand();

        Command importFromJson = new ImportFromJson();
        Command exportFromJson = new ExportToJson();


        commands.put("listNetwork", listEntireNetwork);
        commands.put("networkStatus", statusOfNetwork);

        commands.put("addCarrier", addCarrier);
        commands.put("deleteCarrier", deleteCarrier);
        commands.put("renameCarrier", renameCarrier);
        commands.put("listCarriers", listAllCarriers);
        commands.put("carrierStatus", statusOfCarrier);

        commands.put("addHub", addHub);
        commands.put("deleteHub", deleteHub);
        commands.put("renameHub", renameHub);
        commands.put("listHubs", listAllHubs);
        commands.put("hubStatus", statusOfHub);


        commands.put("addNode", addNode);
        commands.put("deleteNode", deleteNode);
        commands.put("renameNode", renameNode);
        commands.put("listNodes", listAllNodes);
        commands.put("nodeStatus", statusOfNode);

        commands.put("createAlarm", createAlarm);
        commands.put("clearAlarm", clearAlarm);
        commands.put("remedies", suggestedRemedies);


        commands.put("import", importFromJson);
        commands.put("export", exportFromJson);

        String mainMenuChoice;
        do {

            System.out.println("");
            System.out.println("DAS network manager");
            System.out.println("--------------------");
            System.out.println("1. Network menu");
            System.out.println("2. Carrier menu");
            System.out.println("3. Hub menu");
            System.out.println("4. Node menu");
            System.out.println("5. Alarm menu");
            System.out.println("6. Json\n");
            System.out.print("Please make a selection (1-6): ");


            mainMenuChoice = scan.nextLine();

            switch (mainMenuChoice) {

                case "1":
                    main.networkMenu();
                    break;
                case "2":
                    main.carrierMenu();
                    break;
                case "3":
                    main.hubMenu();
                    break;
                case "4":
                    main.nodeMenu();
                    break;
                case "5":
                    main.alarmMenu();
                    break;
                case "6":
                    main.jsonMenu();
                    break;
            }
        } while (mainMenuChoice != "7");
    }


    private void networkMenu() {

        System.out.println("");
        System.out.println("Network menu");
        System.out.println("-------------");
        System.out.println("1. List Network");
        System.out.println("2. Network Status");
        System.out.println("3. Exit\n");
        System.out.print("Please make a selection (1-3): ");

        String networkChoice = scan.nextLine();

        switch (networkChoice) {
            case "1":
                commands.get("listNetwork").execute();
                break;
            case "2":
                commands.get("networkStatus").execute();
                break;
        }
    }


    private void carrierMenu() {

        String carrierChoice;


        System.out.println("");
        System.out.println("Carrier menu");
        System.out.println("------------ ");
        System.out.println("1. Add Carrier");
        System.out.println("2. Delete Carrier");
        System.out.println("3. Rename Carrier");
        System.out.println("4. List Carriers");
        System.out.println("5. Carrier Status");
        System.out.println("6. Exit\n");
        System.out.print("Please make a selection (1-6): ");
        carrierChoice = scan.nextLine();

        switch (carrierChoice) {
            case "1":
                commands.get("addCarrier").execute();
                break;
            case "2":
                commands.get("deleteCarrier").execute();
                break;
            case "3":
                commands.get("renameCarrier").execute();
                break;
            case "4":
                commands.get("listCarriers").execute();
                break;
            case "5":
                commands.get("carrierStatus").execute();
                break;
        }
    }


    private void hubMenu() {
        System.out.println("");
        System.out.println("Hub menu");
        System.out.println("---------");
        System.out.println("1. Add Hub");
        System.out.println("2. Delete Hub");
        System.out.println("3. Rename Hub");
        System.out.println("4. List Hubs");
        System.out.println("5. Hub Status");
        System.out.println("6. Exit\n");
        System.out.print("Please make a selection (1-6): ");
        String hubChoice = scan.nextLine();

        switch (hubChoice) {
            case "1":
                commands.get("addHub").execute();
                break;
            case "2":
                commands.get("deleteHub").execute();
                break;
            case "3":
                commands.get("renameHub").execute();
                break;
            case "4":
                commands.get("listHubs").execute();
                break;
            case "5":
                commands.get("hubStatus").execute();
                break;

        }


    }

    private void nodeMenu() {
        System.out.println("");
        System.out.println("Node menu");
        System.out.println("----------");
        System.out.println("1. Add Node");
        System.out.println("2. Delete Node");
        System.out.println("3. Rename Node");
        System.out.println("4. List Nodes");
        System.out.println("5. Node Status");
        System.out.println("6. Exit\n");
        System.out.print("Please make a selection (1-6): ");
        String nodeChoice = scan.nextLine();

        switch (nodeChoice) {
            case "1":
                commands.get("addNode").execute();
                break;
            case "2":
                commands.get("deleteNode").execute();
                break;
            case "3":
                commands.get("renameNode").execute();
                break;
            case "4":
                commands.get("listNodes").execute();
                break;
            case "5":
                commands.get("nodeStatus").execute();
                break;
        }


    }

    private void alarmMenu() {
        System.out.println("");
        System.out.println("Alarm menu");
        System.out.println("-----------");
        System.out.println("1. Create Alarm");
        System.out.println("2. Clear Alarm/s");
        System.out.println("3. View Remedies");
        System.out.println("4. Exit\n");
        System.out.print("Please make a selection (1-4): ");
        String alarmChoice = scan.nextLine();

        switch (alarmChoice) {
            case "1":
                commands.get("createAlarm").execute();
                break;
            case "2":
                commands.get("clearAlarm").execute();
                break;
            case "3":
                commands.get("remedies").execute();
                break;
        }
    }


    private void jsonMenu() {
        System.out.println("");
        System.out.println("Json menu");
        System.out.println("----------");
        System.out.println("1. Import");
        System.out.println("2. Export");
        System.out.println("3. Exit\n");
        System.out.print("Please make a selection (1-3): ");
        String jsonChoice = scan.nextLine();

        switch (jsonChoice) {
            case "1":
                commands.get("import").execute();
                break;
            case "2":
                commands.get("export").execute();
                break;
        }
    }


    //Populates the Network with data for demo purposes
    private void populateValues() {

        Carrier c1 = new Carrier("Vodafone");
        Carrier c2 = new Carrier("Three");

        Hub h1 = new Hub("Hub1", "1");
        Hub h2 = new Hub("Hub2", "2");

        Node n1 = new Node("Node1", "1");
        Node n2 = new Node("Node2", "2");


        Date date = new Date();


        Alarm alarm1 = new Alarm("Power outage", "Power outage remedy", date);
        Alarm alarm2 = new Alarm("Dark fibre", "Dark fibre remedy", date);
        Alarm alarm3 = new Alarm("Dark fibre", "Dark fibre remedy", date);
        Alarm alarm4 = new Alarm("Optical loss", "Optical loss remedy", date);
        Alarm alarm5 = new Alarm("Power outage", "Power outage remedy", date);
        Alarm alarm6 = new Alarm("Optical loss", "Optical loss remedy", date);


        h1.hubAlarms.add(alarm1);
        h1.hubAlarms.add(alarm2);
        h1.hubAlarms.add(alarm5);

        h2.hubAlarms.add(alarm3);
        h2.hubAlarms.add(alarm4);
        h2.hubAlarms.add(alarm6);

        n1.nodeAlarms.add(alarm1);
        n1.nodeAlarms.add(alarm2);
        n1.nodeAlarms.add(alarm3);

        n2.nodeAlarms.add(alarm4);
        n2.nodeAlarms.add(alarm5);
        n2.nodeAlarms.add(alarm6);


        Network.carrierMap.put(c1.getName(), c1);
        Network.carrierMap.put(c2.getName(), c2);


        Network.carrierMap.get(c1.getName()).hubs.put(h1.getName(), h1);
        Network.carrierMap.get(c2.getName()).hubs.put(h2.getName(), h2);


        Network.carrierMap.get(c1.getName()).hubs.get(h1.getName()).nodes.put(n1.getName(), n1);
        Network.carrierMap.get(c2.getName()).hubs.get(h2.getName()).nodes.put(n2.getName(), n2);

    }
}
