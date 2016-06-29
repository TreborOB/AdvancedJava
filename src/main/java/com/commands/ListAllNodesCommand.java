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
        System.out.println("-------------");

        String parentCarrier;
        String parentHub;


        ListElements.listCarriers();

        do {
            System.out.print("Choose a carrier: ");
            parentCarrier = scan.nextLine();
            if(!Network.carrierMap.containsKey(parentCarrier)){
                System.out.println("No such carrier");
            }
        } while (!Network.carrierMap.containsKey(parentCarrier));


        ListElements.listHubs(parentCarrier);

        do {
            System.out.println("Which hubs nodes would you like to view?");
            parentHub = scan.nextLine();
            if(!Network.carrierMap.get(parentCarrier).hubs.containsKey(parentHub)){
                System.out.println("No such hub");
            }
        } while (!Network.carrierMap.get(parentCarrier).hubs.containsKey(parentHub));


        System.out.println("");
        listAllNodes(parentCarrier, parentHub);
    }



    public void listAllNodes(String parentCarrier, String parentHub){
        if (Network.carrierMap.get(parentCarrier).hubs.get(parentHub).nodes.size() == 0) {
            System.out.println("No nodes exist");
        }
        {
            for (Map.Entry<String, Node> entry: Network.carrierMap.get(parentCarrier).hubs.get(parentHub).nodes.entrySet()) {
                System.out.println("Hub name: "  + parentHub + "\n" + "Node name: " + entry.getValue().getName() + "\n" + "ID: " + entry.getValue().getId());
                System.out.println("");
            }

        }
    }
}
