package com.commands;


import com.main.Network;
import com.main.Node;

import java.util.Scanner;

public class RenameNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);


    public void execute(){


        System.out.println("");
        System.out.println("Rename Node");
        System.out.println("------------");


        ListElements.listCarriers();

        String carrier;
        do{
        System.out.print("Enter a carrier: ");
        carrier = scan.nextLine();
        SearchForElementName.searchForCarrier(carrier);
        }while(!Network.carrierMap.containsKey(carrier));
        System.out.println("");

        ListElements.listHubs(carrier);

        String hubName;
        do {
            System.out.print("Enter a hub: ");
            hubName = scan.nextLine();
            SearchForElementName.searchForHub(carrier, hubName);
        }while(!Network.carrierMap.get(carrier).hubs.containsKey(hubName));


        ListElements.listNodes(carrier, hubName);

        String node;

        do{
        System.out.print("Which node would you like to rename?: ");
        node = scan.nextLine();
        SearchForElementName.searchForNode(carrier, hubName, node);
        }while(!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(node));


        String newNodeName;

        do {
            System.out.println("");
            System.out.print("Enter a new name for the node: ");
            newNodeName = scan.nextLine();
            if(!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(node)) {
                System.out.print("A node with this name already exists within the system");
            }
            System.out.println("");
        }while(!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(node));


        renameNode(carrier, hubName, node, newNodeName);
    }


    private void renameNode(String carrier, String hub, String node, String newNodeName){

        Node n = Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(node);

        Network.carrierMap.get(carrier).hubs.get(hub).nodes.put(newNodeName, n);

    }
}
