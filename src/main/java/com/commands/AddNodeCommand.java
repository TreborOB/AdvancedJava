package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class AddNodeCommand implements Command{


    Scanner sc = new Scanner(System.in);
    private String nodeName;
    private String hubName;
    private String carrierName;
    private int nodeID;

    Hub h = new Hub();


    public void execute() {

        System.out.println("");
        System.out.print("Add Node");
        System.out.println("");


        do {
            System.out.print("Which carrier would you like to associate the node with?: ");
            carrierName = sc.nextLine();
        } while (!Network.carrierMap.containsKey(carrierName));


        System.out.println("");


        do {
            System.out.print("Which hub would you like to associate the node with?: ");
            hubName = sc.nextLine();
        } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


        System.out.println("");


        do {
            System.out.print("Enter the name of the node: ");
            nodeName = sc.nextLine();
        } while (Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName));


        System.out.println("");

        do {
            System.out.print("Enter an id for the node (the id must be an int value): ");
            nodeID = sc.nextInt();
        }while (!checkID(nodeID)) ;


            Carrier c = Network.carrierMap.get(carrierName);

            Node node = new Node(nodeName, nodeID);

            c.hubs.get(hubName).nodes.put(node.getName(), node);

        }






    public boolean checkID(int id) {

        boolean idCheck = true;

        for (Map.Entry<String, Node> entry : Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.entrySet()) {


            if (entry.getValue().getId() == nodeID) {
                System.out.println("ID is not unique please choose another");
                System.out.println("");
                idCheck = false;
            } else {
                idCheck = true;
            }
        }

        return idCheck;
    }


}
