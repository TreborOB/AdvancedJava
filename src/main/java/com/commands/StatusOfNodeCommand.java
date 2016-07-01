package com.commands;


import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class StatusOfNodeCommand implements Command {


    private Scanner scan = new Scanner(System.in);


    public void execute() {

        ListElements.listCarriers();

        String carrier = chosenCarrier();

        ListElements.listHubs(carrier);

        String hub = chosenHub(carrier);

        String availability = searchAvailability(carrier, hub);

        if (availability.equals("Unit unavailable")) {
            System.out.println("");
            System.out.print("Parent hub is unavailable thus all nodes are unavailable");
            System.out.println("");

        } else {
            searchByNameOrID(carrier, hub);
        }
    }


    public String chosenHub(String carrier) {

        String hubName;

        do {
            System.out.println("");
            System.out.print("Please enter the hub name: ");
            hubName = scan.nextLine();
            SearchForElementName.searchForHub(carrier, hubName);
        } while (!Network.carrierMap.get(carrier).hubs.containsKey(hubName));

        return hubName;
    }


    public String chosenCarrier() {

        String carrier;

        do {
            System.out.print("Please enter the carrier name: ");
            carrier = scan.nextLine();
            SearchForElementName.searchForCarrier(carrier);
        } while (!Network.carrierMap.containsKey(carrier));

        return carrier;
    }


    //Allows the user to search nodes by either name or unique idea
    public void searchByNameOrID(String carrier, String hubName) {

        String nodeName;
        Node node;
        String availableUnavailable;

        ListElements.listNodes(carrier, hubName);

        do {
            System.out.println("");
            System.out.print("Please enter the name of id the node you would like to search for: ");
            nodeName = scan.nextLine();
        } while (!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(nodeName));


        if (Network.carrierMap.get(carrier).hubs.get(hubName).hubAlarms.isEmpty()) {
            System.out.println("");
            System.out.println("There are no active alarms for this node");
        } else {


            for (int i = 0; i < Network.carrierMap.get(carrier).hubs.get(hubName).hubAlarms.size(); i++) {
                System.out.println("");

                if (Network.carrierMap.get(carrier).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmType().equalsIgnoreCase("Unit unavailable")) {
                    availableUnavailable = "Unit unavailable";
                } else {
                    availableUnavailable = "Unit available";

                }

                for (Map.Entry<String, Node> entry : Network.carrierMap.get(carrier).hubs.get(hubName).nodes.entrySet()) {
                    if (entry.getValue().getName().equals(nodeName)) {

                        node = entry.getValue();
                        System.out.println("");
                        System.out.println("node name: " + node.getName());
                        System.out.println("node id: " + node.getId());
                        System.out.println("node status: " + availableUnavailable);
                    }

                }

            }
        }
    }


    //searches to see if the specified now is available/unavailable
    public String searchAvailability(String carrier, String hubName) {

        String unitAvailability = "";

        for (int i = 0; i < Network.carrierMap.get(carrier).hubs.get(hubName).getHubAlarms().size(); i++) {
            if (Network.carrierMap.get(carrier).hubs.get(hubName).getHubAlarms().get(i).getAlarmType().equalsIgnoreCase("Unit unavailable")) {
                unitAvailability = "Unit unavailable";
            } else {
                unitAvailability = "Unit available";
            }
        }
        return unitAvailability;
    }
}
