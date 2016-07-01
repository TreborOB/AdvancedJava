package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteNodeCommand implements Command {

    Scanner scan = new Scanner(System.in);


    public void execute() {


        System.out.println("");
        System.out.println("Delete Node");
        System.out.println("------------");


        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));


        ListElements.listHubs(carrierName);

        String hubName;
        do {
            System.out.print("Enter the hubs name: ");
            hubName = scan.nextLine();

            chosenHub(carrierName, hubName);

        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


        ListElements.listNodes(carrierName, hubName);

        String nodeToDelete;
        do {
            System.out.print("Which node would you like to delete?: ");
            nodeToDelete = scan.nextLine();
            SearchForElementName.searchForNode(carrierName, hubName, nodeToDelete);
        } while (!Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeToDelete));


        System.out.println("");


        deleteNode(carrierName, hubName, nodeToDelete);

    }

    //delete a specified node
    public void deleteNode(String carrier, String hub, String nodeToDelete) {

        Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(nodeToDelete);
        System.out.print(nodeToDelete + " deleted");

    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }


    public String chosenHub(String carrierName, String hubName) {
        if (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName)) {
            System.out.println("No such hub exists, please choose another\n");
        }
        return hubName;
    }

}
