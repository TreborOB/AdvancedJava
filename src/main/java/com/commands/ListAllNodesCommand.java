package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class ListAllNodesCommand implements Command {


    private String parentCarrier;
    private String parentHub;


    Scanner scan = new Scanner(System.in);

    public void execute() {


        System.out.println("");
        System.out.print("List All Nodes");
        System.out.println("");


        do {
            System.out.println("Choose a carrier");
            parentCarrier = scan.nextLine();
        } while (!Network.carrierMap.containsKey(parentCarrier));


        do {
            System.out.println("Which hubs nodes would you like to view?");
            parentHub = scan.nextLine();
        } while (!Network.carrierMap.get(parentCarrier).hubs.containsKey(parentHub));


        System.out.println("");
        listAllNodes();
    }



    public void listAllNodes(){
        if (Network.carrierMap.get(parentCarrier).hubs.get(parentHub).nodes.size() == 0) {
            System.out.println("No nodes exist");
        }
        {
            for (Map.Entry<String, Node> entry: Network.carrierMap.get(parentCarrier).hubs.get(parentHub).nodes.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getId());
            }

        }
    }
}
