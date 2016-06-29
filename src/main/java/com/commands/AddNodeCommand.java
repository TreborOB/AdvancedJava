package com.commands;


import com.main.*;

import java.util.Map;
import java.util.Scanner;

public class AddNodeCommand implements Command{


    private Scanner sc = new Scanner(System.in);

    public void execute() {


        System.out.println("");
        System.out.println("Add Node");
        System.out.println("--------");


        ListElements.listCarriers();


        String carrierName;
        do {
            System.out.print("Which carrier would you like to associate the node with?: ");
            carrierName = sc.nextLine();
            SearchForElementName.searchForCarrier(carrierName);
        } while (!Network.carrierMap.containsKey(carrierName));


        System.out.println("");


        ListElements.listHubs(carrierName);


        String hubName;
        do {
            System.out.print("Which hub would you like to associate the node with?: ");
            hubName = sc.nextLine();
            SearchForElementName.searchForHub(carrierName, hubName);
        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


        System.out.println("");

        String nodeName;
        do {
            System.out.print("Enter the name of the node: ");
            nodeName = sc.nextLine();
            if(Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName)){
                System.out.println(nodeName + " already exists");
            }
        } while (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName));


        System.out.println("");


        ListElements.listNodes(carrierName, hubName);

        String nodeID;
        do {
            System.out.print("Enter an id for the node (the id must be an int value): ");
            nodeID = sc.nextLine();
        }while (!checkID(carrierName, hubName, nodeID)) ;


           addNode(carrierName, hubName, nodeName, nodeID);

        }





    private void addNode(String carrierName, String hubName, String nodeName, String nodeID) {

        Carrier c = Network.carrierMap.get(carrierName);

        Node node = new Node(nodeName, nodeID);

        c.hubs.get(hubName).nodes.put(node.getName(), node);


        System.out.println("Node added");

    }




    private boolean checkID(String carrierName, String hubName, String nodeID) {

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
