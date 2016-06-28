package com.commands;


import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;


public class ListAllHubsCommand implements Command{


    Scanner scan = new Scanner(System.in);


    public void execute(){

        System.out.println("");
        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");


        String parentCarrier;
        do {
            System.out.print("Which carriers hubs would you like to view?: ");
            parentCarrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(parentCarrier));

        System.out.println("");

        listAllHubs(parentCarrier);


        }

        public void listAllHubs(String parentCarrier){
            if(Network.carrierMap.get(parentCarrier).hubs.size() == 0){
                System.out.println("No hubs exist");
            }{
                for (Map.Entry<String, Hub> entry: Network.carrierMap.get(parentCarrier).hubs.entrySet()) {
                    System.out.println("Hub name: " + entry.getKey() + "\n" + "ID: " + entry.getValue().getId());
                    System.out.println("");
                }
    }


    }




}
