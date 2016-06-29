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
            System.out.println("");
            System.out.print("Please choose a carrier: ");
            carrierName = scan.nextLine();
            SearchForElementName.searchForCarrier(carrierName);
        } while (!Network.carrierMap.containsKey(carrierName));

        System.out.println("");


        System.out.print("Would you like to create an alarm on a hub or node?: ");
        String alarmOnHubOrNode = scan.nextLine();
        System.out.println("");


        if (alarmOnHubOrNode.equalsIgnoreCase("Hub")) {
            createAlarmOnHub(carrierName);

        } else if (alarmOnHubOrNode.equalsIgnoreCase("Node")) {
            createAlarmOnNode(carrierName);
        }

    }


    private void createAlarmOnHub(String carrier) {
        System.out.println("");
        System.out.println("Create alarm on hub");
        System.out.println("-------------");

        ListElements.listHubs(carrier);

        String chosenHub;
        do {
            System.out.print("Choose a hub: ");
            chosenHub = scan.nextLine();
            SearchForElementName.searchForHub(carrier, chosenHub);
        } while (!Network.carrierMap.get(carrier).hubs.containsKey(chosenHub));

        createHubAlarm(carrier, chosenHub);

    }


    private void createAlarmOnNode(String carrier) {
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


    private void createHubAlarm(String carrier, String chosenHub) {

        Alarm hubAlarm;

        do {
            hubAlarm = createAlarm();
        }while(hubAlarm.getAlarmType().equalsIgnoreCase("Default"));

        Network.carrierMap.get(carrier).hubs.get(chosenHub).hubAlarms.add(hubAlarm);
    }


    private void createNodeAlarm(String carrier, String chosenHub, String chosenNode) {

        Alarm nodeAlarm;
        nodeAlarm = createAlarm();

        Network.carrierMap.get(carrier).hubs.get(chosenHub).nodes.get(chosenNode).nodeAlarms.add(nodeAlarm);

    }


    private Alarm createAlarm() {

            String chosenAlarm;
            String alarmType;
            String alarmRemedy;

            System.out.println("");
            System.out.println("Please choose an alarm type (1-4): ");
            System.out.println("1. Unit unavailable: ");
            System.out.println("2. Optical loss: ");
            System.out.println("3. Dark fibre: ");
            System.out.println("4. Power outage: ");

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
