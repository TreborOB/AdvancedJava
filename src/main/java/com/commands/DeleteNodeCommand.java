package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);



    public void execute(){


        System.out.println("");
        System.out.println("Delete Node");
        System.out.println("");


        System.out.println("");


        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");

        String carrier;
        do {
            System.out.print("Enter a carrier: ");
            carrier = scan.nextLine();
        } while(!Network.carrierMap.containsKey(carrier));

        System.out.println("");



        ListAllHubsCommand listHubs = new ListAllHubsCommand();
        listHubs.listAllHubs(carrier);
        System.out.println("");



        String hub;
        do{
        System.out.print("Enter a hub: ");
        hub = scan.nextLine();
        System.out.println("");
        } while(!Network.carrierMap.get(carrier).hubs.containsKey(hub));


        String nodeToDelete;
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
