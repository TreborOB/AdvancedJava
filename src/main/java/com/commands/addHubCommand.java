package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;

public class AddHubCommand implements Command{

    Scanner scan = new Scanner(System.in);


    public void execute(){


        System.out.println("");
        System.out.println("Carriers");
        System.out.println("---------");


        ListElements.listCarriers();


        String carrierName;
            do {
                System.out.print("Which carrier would you like to associate the hub with?: ");
                carrierName = scan.nextLine();
                SearchForElementName.searchForCarrier(carrierName);
            }while (!Network.carrierMap.containsKey(carrierName));

            System.out.println("");


        ListElements.listHubs(carrierName);


        String hubName;
          do {
              System.out.print("Enter the hub name: ");
              hubName = scan.nextLine();
              if(Network.carrierMap.get(carrierName).hubs.containsKey(hubName)){
                  System.out.println(hubName + " already exists within the system");
              }
           }while(Network.carrierMap.get(carrierName).hubs.containsKey(hubName));



            System.out.println("");


        String hubID;

        do {
            System.out.print("Enter an id for the hub: ");
            hubID = scan.nextLine();
        }while(!checkID(carrierName, hubID));
            System.out.println("");

            addHub(carrierName, hubName, hubID);
          }




    private void addHub(String parentCarrier, String hubName, String hubID){

        Carrier c = Network.carrierMap.get(parentCarrier);

        //Check if hub exists

        Hub hub = new Hub(hubName, hubID);

        c.hubs.put(hub.getName(), hub);

        //hub.nodes.values();
    }



    private boolean checkID(String parentCarrier, String hubID) {

        boolean idCheck = true;

        for (Map.Entry<String, Hub> entry : Network.carrierMap.get(parentCarrier).hubs.entrySet()) {

            if (entry.getValue().getId().equals(hubID)) {
                System.out.println("ID " + hubID + " is not unique please choose another");
                System.out.println("");
                idCheck = false;
            } else {
                idCheck = true;
            }
        }

        return idCheck;
    }


    }
