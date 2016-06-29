package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);



    public void execute(){


        System.out.println("");
        System.out.println("Delete Node");
        System.out.println("");


        ListElements.listCarriers();


        String carrier;
        do {
            System.out.print("Enter a carrier: ");
            carrier = scan.nextLine();
            SearchForElementName.searchForCarrier(carrier);
        } while(!Network.carrierMap.containsKey(carrier));

        System.out.println("");


        ListElements.listHubs(carrier);


        String hubName;
        do{
        System.out.print("Enter a hub: ");
        hubName = scan.nextLine();
            SearchForElementName.searchForHub(carrier, hubName);
        } while(!Network.carrierMap.get(carrier).hubs.containsKey(hubName));


        ListElements.listNodes(carrier, hubName);

        String nodeToDelete;
        do {
            System.out.print("Which node would you like to delete?: ");
            nodeToDelete = scan.nextLine();
            SearchForElementName.searchForNode(carrier, hubName, nodeToDelete);
        }while(!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(nodeToDelete));


        System.out.println("");


        deleteNode(carrier, hubName, nodeToDelete);

    }



    private void deleteNode(String carrier, String hub, String nodeToDelete){

        Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(nodeToDelete);

    }
}
