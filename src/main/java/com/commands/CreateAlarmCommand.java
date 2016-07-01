package com.commands;


import com.main.Alarm;
import com.main.Network;

import java.util.Date;
import java.util.Scanner;

public class CreateAlarmCommand implements Command {


    Scanner scan = new Scanner(System.in);
    private ListAllHubsCommand listHubs = new ListAllHubsCommand();
    private ListAllNodesCommand listNodes = new ListAllNodesCommand();

    public void execute() {

        System.out.println("");
        System.out.println("Create an alarm");
        System.out.println("---------------");

        ListElements.listCarriers();


        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));
        System.out.println("");


        hubOrNode(carrierName);

    }


    public void createAlarmOnHub(String carrier) {
        System.out.println("");
        System.out.println("Create alarm on hub");
        System.out.println("--------------------");

        ListElements.listHubs(carrier);

        String hubName;
        do {
            System.out.print("Enter the hubs name: ");
            hubName = scan.nextLine();

            chosenHub(hubName);

        } while (!Network.carrierMap.get(carrier).hubs.containsKey(hubName));

        createHubAlarm(carrier, hubName);

    }


    public String chosenHub(String hubName) {
        if (!Network.carrierMap.containsKey(hubName)) {
            System.out.println("No such hub exists, please choose another\n");
        }
        return hubName;
    }


    public void createAlarmOnNode(String carrier) {
        System.out.println("");
        System.out.println("Alarm on node");

        System.out.println("");

        listHubs.listAllHubs(carrier);

        System.out.println("");

        ListElements.listHubs(carrier);


        String chosenHub;
        do {
            chosenHub = scan.nextLine();
            System.out.print("Choose a hub: ");
            SearchForElementName.searchForHub(carrier, chosenHub);
            System.out.println("");
        } while (!Network.carrierMap.get(carrier).hubs.containsKey(chosenHub));


        System.out.println("");

        listNodes.listAllNodes(carrier, chosenHub);

        System.out.println("");


        ListElements.listNodes(carrier, chosenHub);

        String chosenNode;
        do {
            System.out.print("Choose a node: ");
            chosenNode = scan.nextLine();
            SearchForElementName.searchForNode(carrier, chosenHub, chosenNode);
            System.out.println("");
        } while (!Network.carrierMap.get(carrier).hubs.get(chosenHub).nodes.containsKey(chosenNode));

        createNodeAlarm(carrier, chosenHub, chosenNode);
    }


    public void createHubAlarm(String carrier, String chosenHub) {

        Alarm hubAlarm;

        do {
            hubAlarm = createAlarm();
        } while (hubAlarm.getAlarmType().equalsIgnoreCase("Default"));

        Network.carrierMap.get(carrier).hubs.get(chosenHub).hubAlarms.add(hubAlarm);


        System.out.println("Alarm Created");
        System.out.println("--------------");
        System.out.println("");
        System.out.println("Hub: " + chosenHub);
        System.out.println("Alarm type: " + hubAlarm.getAlarmType());
        System.out.println(hubAlarm.getAlarmReceivedDate());

    }


    public void createNodeAlarm(String carrier, String chosenHub, String chosenNode) {

        Alarm nodeAlarm;
        do {
            nodeAlarm = createAlarm();
        } while (nodeAlarm.getAlarmType().equalsIgnoreCase("Default"));

        Network.carrierMap.get(carrier).hubs.get(chosenHub).nodes.get(chosenNode).nodeAlarms.add(nodeAlarm);

        System.out.println("Alarm Created");
        System.out.println("--------------");
        System.out.println("");
        System.out.println("Node: " + chosenHub);
        System.out.println("Alarm type: " + nodeAlarm.getAlarmType());
        System.out.println(nodeAlarm.getAlarmReceivedDate());

    }


    public void hubOrNode(String carrierName) {

        System.out.print("Would you like to create an alarm on a hub or node?: ");
        String alarmOnHubOrNode = scan.nextLine();
        System.out.println("");


        if (alarmOnHubOrNode.equalsIgnoreCase("Hub")) {
            createAlarmOnHub(carrierName);

        } else if (alarmOnHubOrNode.equalsIgnoreCase("Node")) {
            createAlarmOnNode(carrierName);
        }


    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }


    //Allows the user to choosen an alarm type to create
    public Alarm createAlarm() {

        String chosenAlarm;
        String alarmType;
        String alarmRemedy;

        System.out.println("");
        System.out.println("Please choose an alarm type (1-4): ");
        System.out.println("1. Unit unavailable: ");
        System.out.println("2. Optical loss: ");
        System.out.println("3. Dark fibre: ");
        System.out.println("4. Power outage: \n");
        System.out.print("Choose an alarm type (1-4): \n");

        chosenAlarm = scan.nextLine();

        switch (chosenAlarm) {

            case "1":
                alarmType = "Unit unavailable";
                alarmRemedy = "Unit unavailable remedy";


                break;

            case "2":
                alarmType = "Optical loss";
                alarmRemedy = "Optical loss remedy";


                break;

            case "3":
                alarmType = "Dark fibre";
                alarmRemedy = "Dark fibre remedy";


                break;

            case "4":
                alarmType = "Power outage";
                alarmRemedy = "Power outage remedy";

                break;

            default:
                alarmType = "Default";
                alarmRemedy = "Default remedy";
        }

        Date date = new Date();

        return new Alarm(alarmType, alarmRemedy, date);

    }
}
