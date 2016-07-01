package com.commands;


import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class ListAllNodesCommand implements Command {


    Scanner scan = new Scanner(System.in);

    public void execute() {


        System.out.println("");
        System.out.println("List All Nodes");
        System.out.println("-------------\n");

        String parentCarrier;
        String parentHub;


        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));


        ListElements.listHubs(carrierName);

        do {
            System.out.println("Which hubs nodes would you like to view?");
            parentHub = scan.nextLine();
            if (!Network.carrierMap.get(carrierName).hubs.containsKey(parentHub)) {
                System.out.println("No such hub");
            }
        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(parentHub));


        System.out.println("");
        listAllNodes(carrierName, parentHub);
    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }


    public void listAllNodes(String parentCarrier, String parentHub) {
        if (Network.carrierMap.get(parentCarrier).hubs.get(parentHub).nodes.size() == 0) {
            System.out.println("No nodes exist");
        }
        {
            for (Map.Entry<String, Node> entry : Network.carrierMap.get(parentCarrier).hubs.get(parentHub).nodes.entrySet()) {
                System.out.println("Hub name: " + parentHub + "\n" + "Node name: " + entry.getKey() + "\n" + "ID: " + entry.getValue().getId());
                System.out.println("");
            }

        }
    }
}
