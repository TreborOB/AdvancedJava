package com.commands;


import com.main.Network;
import com.main.Node;

import java.util.Scanner;

public class RenameNodeCommand implements Command {

    Scanner scan = new Scanner(System.in);


    public void execute() {


        System.out.println("");
        System.out.println("Rename Node");
        System.out.println("------------");


        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the new carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));

        ListElements.listHubs(carrierName);

        String hubName = chosenHub(carrierName);

        ListElements.listNodes(carrierName, hubName);

        String node = chosenNode(carrierName, hubName);

        String newNodeName = newNameForNode(carrierName, hubName, node);

        renameNode(carrierName, hubName, node, newNodeName);
    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("Carrier with that name already exists, please choose another\n");
        }
        return carrierName;
    }

    public String chosenHub(String carrier) {
        String hubName;
        do {
            System.out.print("Enter a hub: ");
            hubName = scan.nextLine();
            SearchForElementName.searchForHub(carrier, hubName);
        } while (!Network.carrierMap.get(carrier).hubs.containsKey(hubName));
        return hubName;
    }


    public String chosenNode(String carrier, String hubName) {
        String node;
        do {
            System.out.print("Which node would you like to rename?: ");
            node = scan.nextLine();
            SearchForElementName.searchForNode(carrier, hubName, node);
        } while (!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(node));

        return node;
    }


    //Renames the specified node
    public void renameNode(String carrier, String hub, String node, String newNodeName) {

        Node n = Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(node);
        n.setName(newNodeName);

        Network.carrierMap.get(carrier).hubs.get(hub).nodes.put(newNodeName, n);

    }

    //Takes in the new name for the node
    public String newNameForNode(String carrier, String hub, String node) {

        String newNodeName;

        do {
            System.out.println("");
            System.out.print("Enter a new name for the node: ");
            newNodeName = scan.nextLine();
            if (!Network.carrierMap.get(carrier).hubs.get(hub).nodes.containsKey(node)) {
                System.out.print("A node with this name already exists within the system");
            }
            System.out.println("");
        } while (!Network.carrierMap.get(carrier).hubs.get(hub).nodes.containsKey(node));

        return newNodeName;
    }


}
