package com.commands;


import com.main.Network;

import java.util.Scanner;

public class ClearAlarmCommand implements Command {


    private Scanner scan = new Scanner(System.in);

    public void execute() {


        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));


        alarmOnHubOrNode(carrierName);
    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }


    public void clearHubAlarm(String carrierName) {

        String hubName;

        ListElements.listHubs(carrierName);
        System.out.println("");

        do {
            System.out.print("Please choose a hub: ");
            hubName = scan.nextLine();
            SearchForElementName.searchForHub(carrierName, hubName);
        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));

        String AlLOrSpecific;

        System.out.println("");
        System.out.print("Would you like to clear all alarms or only specific alarms from the hub?: ");
        AlLOrSpecific = scan.nextLine();

        if (AlLOrSpecific.equalsIgnoreCase("all")) {

            clearAllHubAlarms(carrierName, hubName);

        } else if (AlLOrSpecific.equalsIgnoreCase("specific")) {

            clearSpecificHubAlarms(carrierName, hubName);

        } else {
            System.out.print("Invalid selection");
        }


    }


    private void clearNodeAlarm(String carrierName) {

        String hubName;
        ListElements.listHubs(carrierName);
        System.out.println("");


        do {
            System.out.print("Please choose a hub: ");
            hubName = scan.nextLine();
            SearchForElementName.searchForHub(carrierName, hubName);
        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


        String nodeName;

        ListElements.listNodes(carrierName, hubName);

        do {
            System.out.println("");
            System.out.print("Please choose a node: ");
            nodeName = scan.nextLine();
        } while (!Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName));


        String AlLOrSpecific;

        System.out.println("");
        System.out.print("Would you like to clear all alarms or only specific alarms from the node?: ");
        AlLOrSpecific = scan.nextLine();

        if (AlLOrSpecific.equalsIgnoreCase("all")) {

            clearAllNodeAlarms(carrierName, hubName, nodeName);

        } else if (AlLOrSpecific.equalsIgnoreCase("specific")) {

            clearSpecificNodeAlarms(carrierName, hubName, nodeName);

        } else {
            System.out.print("Invalid selection");
        }

    }


    //Clears all hub alarms
    public void clearAllHubAlarms(String carrierName, String hubName) {

        Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.clear();

        System.out.println("All hub alarms cleared");
    }


    //Clears a user specified hub alarm
    private void clearSpecificHubAlarms(String carrierName, String hubName) {

        String specificAlarmHub = specificAlarmToRemove();

        for (int i = 0; i < Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size(); i++) {
            System.out.println("");

            if (Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmType().equalsIgnoreCase(specificAlarmHub)) {

                System.out.print(specificAlarmHub + " alarm removed");
            }
        }
    }


    //Clears all node alarms
    public void clearAllNodeAlarms(String carrierName, String hubName, String nodeName) {

        Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.clear();

        System.out.println("Alarms cleared");
    }


    //Clears a user specified node alarm
    public void clearSpecificNodeAlarms(String carrierName, String hubName, String nodeName) {

        String specificAlarmNode;

        do {
            specificAlarmNode = specificAlarmToRemove();
        } while (specificAlarmNode.equals("No selection"));

        if (Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.isEmpty()) {

            System.out.println("No alarms available");
        } else {

            for (int i = 0; i < Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size(); i++) {
                System.out.println("");
                if (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmType().equalsIgnoreCase(specificAlarmNode)) {
                    System.out.print(specificAlarmNode + " alarm removed");
                } else {
                    System.out.print("No " + specificAlarmNode + " alarm type found");
                }
            }
        }
    }


    //Allows the user to specify which alarm type to remove
    public String specificAlarmToRemove() {

        System.out.println("");
        System.out.println("Please choose the number of the alarm type you would like to remove: ");

        System.out.println("1. Unit unavailable");
        System.out.println("2. Optical Loss");
        System.out.println("3. Dark Fibre");
        System.out.println("4. Power Outage\n");
        System.out.print("Choose an alarm type to clear (1-4): \n");

        String choice = scan.nextLine();


        String alarmToRemove;

        switch (choice) {

            case "1":
                alarmToRemove = "Unit unavailable";
                break;
            case "2":
                alarmToRemove = "Optical loss";
                break;
            case "3":
                alarmToRemove = "Dark fibre";
                break;
            case "4":
                alarmToRemove = "Power outage";
                break;
            default:
                alarmToRemove = "No selection";
        }

        return alarmToRemove;
    }


    public String alarmOnHubOrNode(String carrierName) {

        String hubOrNode;

        System.out.println("");
        System.out.print("Would you like to clear alarm/s from a hub or node?: ");
        hubOrNode = scan.nextLine();

        if (hubOrNode.equalsIgnoreCase("hub")) {

            clearHubAlarm(carrierName);

        } else if (hubOrNode.equalsIgnoreCase("node")) {

            clearNodeAlarm(carrierName);
        } else {
            System.out.print("Invalid selection");
        }

        return hubOrNode;
    }
}





