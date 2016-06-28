package com.commands;


import com.main.Network;
import com.main.Node;

import java.util.Scanner;

public class RenameNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);
    private String carrier;
    private String hub;
    private String node;
    private String newName;



    public void execute(){


        System.out.println("");
        System.out.println("Rename Node");
        System.out.println("------------");


        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();


        System.out.println("");
        System.out.print("Enter a carrier: ");
        carrier = scan.nextLine();
        System.out.println("");


        ListAllHubsCommand listHubs = new ListAllHubsCommand();
        listHubs.listAllHubs(carrier);
        System.out.println("");


        System.out.print("Enter a hub: ");
        hub = scan.nextLine();
        System.out.println("");

        ListAllNodesCommand listAllNodes = new ListAllNodesCommand();
        listAllNodes.listAllNodes(carrier, hub);

        System.out.print("Which node would you like to rename?: ");
        node = scan.nextLine();

        System.out.println(""); System.out.print("Enter a new name for the node: ");
        newName = scan.nextLine();
        System.out.println("");


        renameNode(carrier, hub, node, newName);
    }



    public void renameNode(String carrier, String hub, String node, String newNodeName){


        Node n = Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(node);

        Network.carrierMap.get(carrier).hubs.get(hub).nodes.put(newNodeName, n);

    }
}
