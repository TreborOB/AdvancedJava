package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;

public class StatusOfHub implements Command{



    private Scanner scan = new Scanner(System.in);


    public void execute() {

        String carrier;

        do {
            System.out.println("");
            System.out.print("Please enter the carrier name: ");
            carrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(carrier));


        String nameOrID;

         System.out.println("");
         System.out.print("Do you wish to search by the hub name or id?: ");
         nameOrID = scan.nextLine();


        if(nameOrID.equalsIgnoreCase("name")){

              searchByName(carrier);
        }else if(nameOrID.equalsIgnoreCase("id")){

               searchByID(carrier);

        }else {
            System.out.println("");
            System.out.print("Invalid selection");

        }
    }




       private void searchByName(String carrier){

           String hubName;
           Hub hub;

           do {
               System.out.println("");
               System.out.print("Please enter the hub name: ");
               hubName = scan.nextLine();
           }while(!Network.carrierMap.get(carrier).hubs.containsKey(hubName));


               for (Map.Entry<String, Hub> entry: Network.carrierMap.get(carrier).hubs.entrySet()) {
                   if(entry.getValue().getName().equals(hubName)) {


                       hub = entry.getValue();
                       System.out.println("");
                       System.out.println("Hub name: " + hub.getName());
                       System.out.println("Hub id: " + hub.getId());
                   }





           }



       }



       private void searchByID(String carrier) {


           int hubID;

           System.out.println("");
           System.out.print("Please enter the hub id you wish to search for: ");
           hubID = scan.nextInt();

           String hubs;

           Hub hub;

               {
                   for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
                       hubs = entry.getKey();

                       for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {


                           if (entryHub.getValue().getId() == hubID) {
                               hub = entryHub.getValue();
                               System.out.println("");
                               System.out.println("Hub name: " + hub.getName());
                               System.out.println("Hub id: " + hub.getId());

                           }
                       }
                   }

               }

           }
}



