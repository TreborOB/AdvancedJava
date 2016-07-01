package com.commands;


import com.main.Carrier;
import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class AddNodeCommand implements Command {


    private Scanner scan = new Scanner(System.in);

    public void execute() {


        System.out.println("");
        System.out.println("Add Node");
        System.out.println("--------");


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


        System.out.println("");


        ListElements.listNodes(carrierName, hubName);

        String nodeName = chosenNode(carrierName, hubName);
        System.out.println("");


        String nodeID;
        do {
            System.out.print("Enter an id for the node: ");
            nodeID = scan.nextLine();
        } while (!checkID(carrierName, hubName, nodeID));


        addNode(carrierName, hubName, nodeName, nodeID);

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


    public String chosenNode(String carrierName, String hubName) {
        String nodeName;
        do {
            System.out.print("Enter the name of the node: \n");
            nodeName = scan.nextLine();
            if (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName)) {
                System.out.println(nodeName + " already exists");
            }
        } while (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName));

        return nodeName;
    }


    //Adds new node
    public void addNode(String carrierName, String hubName, String nodeName, String nodeID) {

        Carrier c = Network.carrierMap.get(carrierName);

        Node node = new Node(nodeName, nodeID);

        c.hubs.get(hubName).nodes.put(node.getName(), node);

        System.out.println("Node " + node.getName() + " with an ID of " + node.getId() + " added");

    }


    //Checks to see of ID is unique
    public boolean checkID(String carrierName, String hubName, String nodeID) {

        boolean idCheck = true;

        for (Map.Entry<String, Node> entry : Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.entrySet()) {


            if (entry.getValue().getId().equals(nodeID)) {
                System.out.println("ID " + nodeID + " is not unique please choose another");
                System.out.println("");
                idCheck = false;
            } else {
                idCheck = true;
            }
        }

        return idCheck;
    }


}
