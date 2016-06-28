package com.commands;


import com.main.*;

import java.util.Map;
import java.util.Scanner;

public class StatusOfNodeCommand implements Command {


    private Scanner scan = new Scanner(System.in);


    public void execute() {


        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");

        String carrier;

        do {
            System.out.println("");
            System.out.print("Please enter the carrier name: ");
            carrier = scan.nextLine();
        } while (!Network.carrierMap.containsKey(carrier));


        String hubName;

        do {
            System.out.println("");
            System.out.print("Please enter the hub name: ");
            hubName = scan.nextLine();
        } while (!Network.carrierMap.get(carrier).hubs.containsKey(hubName));



        String availability = searchAvailability(carrier, hubName);

        if(availability.equals("Unit unavailable"))
        {
            System.out.print("Parent hub is unavailable thus all nodes are unavailable");
            System.out.println("");


        }else{


            String nameOrID;

            System.out.println("");
            System.out.print("Do you wish to search by the node name or id?: ");
            nameOrID = scan.nextLine();


            if (nameOrID.equalsIgnoreCase("name")) {

                searchByName(carrier, hubName);
            } else if (nameOrID.equalsIgnoreCase("id")) {

                searchByID(carrier, hubName);

            } else {
                System.out.println("");
                System.out.print("Invalid selection");
            }

        }

    }


    private void searchByName(String carrier, String hubName) {

        String nodeName;
        Node node;
        String availableUnavailable;

        do {
            System.out.println("");
            System.out.print("Please enter the node name: ");
            nodeName = scan.nextLine();
        } while (!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(nodeName));


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


    private void searchByID(String carrier, String hubName) {

        int nodeID;

        System.out.println("");
        System.out.print("Please enter the node id you wish to search for: ");
        nodeID = scan.nextInt();


        String hubs;
        String nodes;

        Node node;

        String unitAvailability;


        for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
            hubs = entry.getKey();

            for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {
                nodes = entryHub.getKey();

                for (Map.Entry<String, Node> entryNode : Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet())


                    for (int i = 0; i < Network.carrierMap.get(carrier).hubs.get(entryHub.getKey()).nodes.get(entryNode.getKey()).getNodeAlarms().size(); i++) {

                        if (Network.carrierMap.get(carrier).hubs.get(entryHub.getKey()).nodes.get(entryNode.getKey()).getNodeAlarms().get(i).getAlarmType().equalsIgnoreCase("available")) {
                            unitAvailability = "Available";
                        } else {
                            unitAvailability = "Unavailable";
                        }


                        if (entryNode.getValue().getId() == nodeID) {
                            node = entryNode.getValue();

                            System.out.println("");
                            System.out.println("Node name " + node.getName());
                            System.out.println("Node id: " + node.getId());
                            System.out.println("Node availability: " + unitAvailability);

                        }

                    }
            }

            System.out.println("");
        }
    }





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
