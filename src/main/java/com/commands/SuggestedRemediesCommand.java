package com.commands;


import com.main.Network;

import java.util.Scanner;

public class SuggestedRemediesCommand implements Command {

    private Scanner scan = new Scanner(System.in);


    public void execute() {

        System.out.println("");

        ListElements.listCarriers();

        String carrierName = chosenCarrier();

        String hubOrNodeRemedy = remedies(carrierName);
    }


    public String chosenCarrier() {

        String carrierName;
        do {
            System.out.print("Choose a carrier: ");
            carrierName = scan.nextLine();
            if (!Network.carrierMap.containsKey(carrierName)) {
                System.out.println("No such carrier");
            }

        } while (!Network.carrierMap.containsKey(carrierName));
        return carrierName;
    }


    public String remedies(String carrierName) {

        String chosenElement;

        System.out.println("");
        System.out.print("Would you like to view remedies for a hub or node?: ");
        chosenElement = scan.nextLine();

        if (chosenElement.equalsIgnoreCase("hub")) {

            hubRemedies(carrierName);

        } else if (chosenElement.equalsIgnoreCase("node")) {
            nodeRemedies(carrierName);
        } else {
            System.out.println("");
            System.out.print("invalid input");
        }

        return chosenElement;
    }


    public void hubRemedies(String carrierName) {

        System.out.println("");

        String hubName;

        ListElements.listHubs(carrierName);

        do {
            System.out.print("Choose a hub: ");
            hubName = scan.nextLine();
            if (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName)) {
                System.out.println("No such hub");
            }
        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


        for (int i = 0; i < Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size(); i++) {
            System.out.println("");
            System.out.println("Alarm: " + Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmType() + "\n" +
                    "Remedy: " + Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmRemedy());
        }
    }


    public void nodeRemedies(String carrierName) {

        System.out.println("");

        String hubName;


        ListElements.listHubs(carrierName);

        do {
            System.out.print("Choose a hub: ");
            hubName = scan.nextLine();
        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


        String nodeName;


        ListElements.listNodes(carrierName, hubName);

        do {
            System.out.println("");
            System.out.print("Choose a node: ");
            nodeName = scan.nextLine();
        } while (!Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName));


        for (int i = 0; i < Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size(); i++) {
            System.out.println("");
            System.out.println("Alarm: " + Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmType() + "\n" +
                    "Remedy: " + Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmRemedy());
        }

    }
}
