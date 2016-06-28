package com.commands;


import com.main.Hub;
import com.main.Network;

import java.util.Scanner;

public class RenameHubCommand implements Command{


    Scanner scan = new Scanner(System.in);
    String carrier;
    String hub;


    public void execute(){


        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");


        do {
        System.out.print("Enter a carrier: ");
        carrier = scan.nextLine();
        System.out.println("");
        }while(!Network.carrierMap.containsKey(carrier));


        ListAllHubsCommand listHubs = new ListAllHubsCommand();
        listHubs.listAllHubs(carrier);
        System.out.println("");


        do{
        System.out.print("Enter the name of the hub you want to rename: ");
        hub = scan.nextLine();
        System.out.println("");
        } while(!Network.carrierMap.get(carrier).hubs.containsKey(hub));



        System.out.print("Enter a new name for the hub: ");
        String newHubName =  scan.nextLine();
        System.out.println("");

        renameHub(carrier, hub, newHubName);


    }



        public void renameHub(String carrier, String hub, String newHubName){


            Hub b = Network.carrierMap.get(carrier).hubs.remove(hub);

            Network.carrierMap.get(carrier).hubs.put(newHubName, b);

        }
}


