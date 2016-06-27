package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class StatusOfNodeCommand implements Command{


    private Scanner scan = new Scanner(System.in);


    public void execute() {


        String carrier;

        do {
            System.out.println("");
            System.out.print("Please enter the carrier name: ");
            carrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(carrier));


        String hubName;

        do {
            System.out.println("");
            System.out.print("Please enter the hub name: ");
            hubName = scan.nextLine();
        }while(!Network.carrierMap.get(carrier).hubs.containsKey(hubName));




        String nameOrID;

        System.out.println("");
        System.out.print("Do you wish to search by the node name or id?: ");
        nameOrID = scan.nextLine();



        if(nameOrID.equalsIgnoreCase("name")){

            searchByName(carrier, hubName);
        }else if(nameOrID.equalsIgnoreCase("id")){

            searchByID(carrier, hubName);

        }else {
            System.out.println("");
            System.out.print("Invalid selection");
        }

    }



    private void searchByName(String carrier, String hubName){

        String nodeName;

        do {
            System.out.println("");
            System.out.print("Please enter the node name: ");
            nodeName = scan.nextLine();
        }while(!Network.carrierMap.get(carrier).hubs.get(hubName).nodes.containsKey(nodeName));



    }



    private void searchByID(String carrier, String hubName) {


        int nodeID;

        System.out.println("");
        System.out.print("Please enter the node id you wish to search for: ");
        nodeID = scan.nextInt();


        String hubs;
        String nodes;

        Node node;



            for (Map.Entry<String, Carrier> entry: Network.carrierMap.entrySet()) {
                hubs = entry.getKey();

                for (Map.Entry<String, Hub> entryHub: Network.carrierMap.get(hubs).hubs.entrySet()) {
                    nodes = entryHub.getKey();

                    for (Map.Entry<String, Node> entryNode: Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet()) {

                        if (entryNode.getValue().getId() == nodeID) {
                            node = entryNode.getValue();

                            System.out.println("");
                            System.out.println("Node name " + node.getName());
                            System.out.println("Node id: " + node.getId());


                        }
                    }

                }

                System.out.println("");
            }
        }
      }
