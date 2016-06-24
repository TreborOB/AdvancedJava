package com.commands;


import com.main.Hub;
import com.main.Network;

import java.util.Scanner;

public class DeleteNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);
    private String carrier;
    private String hub;
    private String nodeToDelete;


    public void execute(){


        System.out.println("");
        System.out.println("Delete Node");
        System.out.println("");



        System.out.println("");


        do {
            System.out.print("Enter a carrier: ");
            carrier = scan.nextLine();
        } while(!Network.carrierMap.containsKey(carrier));

        System.out.println("");


        do{
        System.out.print("Enter a hub: ");
        hub = scan.nextLine();
        System.out.println("");
        } while(!Network.carrierMap.get(carrier).hubs.containsKey(hub));


        do {
            System.out.print("Which node would you like to delete?: ");
            nodeToDelete = scan.nextLine();
        }while(!Network.carrierMap.get(carrier).hubs.get(hub).nodes.containsKey(nodeToDelete));


        System.out.println("");


        deleteNode(carrier, hub, nodeToDelete);

    }



    public void deleteNode(String carrier, String hub, String nodeToDelete){

        Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(nodeToDelete);

    }
}
