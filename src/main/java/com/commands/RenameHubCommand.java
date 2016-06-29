package com.commands;


import com.main.Hub;
import com.main.Network;

import java.util.Scanner;

public class RenameHubCommand implements Command{


    Scanner scan = new Scanner(System.in);

    public void execute(){


        ListElements.listCarriers();
        String carrier;

        do {
        System.out.print("Enter a carrier: ");
        carrier = scan.nextLine();
         SearchForElementName.searchForCarrier(carrier);
        System.out.println("");
        }while(!Network.carrierMap.containsKey(carrier));


        ListElements.listHubs(carrier);

        String hub;

        do{
        System.out.print("Enter the name of the hub you want to rename: ");
        hub = scan.nextLine();
            SearchForElementName.searchForHub(carrier, hub);
        } while(!Network.carrierMap.get(carrier).hubs.containsKey(hub));

        String newHubName;

       do {
           System.out.print("Enter a new name for the hub: ");
            newHubName = scan.nextLine();
             System.out.println("");
       }while(!Network.carrierMap.get(carrier).hubs.containsKey(hub));

        renameHub(carrier, hub, newHubName);


    }


        private void renameHub(String carrier, String hub, String newHubName){

            Hub b = Network.carrierMap.get(carrier).hubs.remove(hub);

            Network.carrierMap.get(carrier).hubs.put(newHubName, b);

        }
}


