package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;

public class StatusOfHubCommand implements Command{



    private Scanner scan = new Scanner(System.in);


    public void execute() {

        String carrier;

        ListElements.listCarriers();

        do {
            System.out.print("Please enter the carrier name: ");
            carrier = scan.nextLine();
            SearchForElementName.searchForCarrier(carrier);
        }while(!Network.carrierMap.containsKey(carrier));


        String nameOrID;

         System.out.println("");
         System.out.print("Enter the name or ID of the hub you wish to search for: ");
         nameOrID = scan.nextLine();

        searchByNameOrID(carrier, nameOrID);

    }




       private void searchByNameOrID(String carrier, String nameOrID){

           String hubName;
           Hub hub;
           String hubs;

           String unitAvailability = "";

           for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
               hubs = entry.getKey();

               for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {

                   if (entryHub.getKey().equalsIgnoreCase(nameOrID) || entryHub.getValue().getId().equalsIgnoreCase(nameOrID)) {
                       System.out.println("");

                       hub = entryHub.getValue();
                       System.out.println(hub.getName());
                       System.out.println(hub.getId());
                       System.out.println(unitAvailability);

                   }
               }
           }
       }
}



