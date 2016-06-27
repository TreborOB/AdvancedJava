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
        System.out.println();


        String parentCarrier;
            do {
                System.out.print("Which carrier would you like to associate the hub with?: ");
                parentCarrier = scan.nextLine();
            }while (!Network.carrierMap.containsKey(parentCarrier));

            System.out.println("");


        String hubName;
          do {
            System.out.print("Enter the hub name: ");
            hubName = scan.nextLine();

           }while(Network.carrierMap.get(parentCarrier).hubs.containsKey(hubName));



            System.out.println("");



        int hubID;

        do {
            System.out.print("Enter an id for the hub (the id must be an int value): ");
            hubID = scan.nextInt();
        }while(!checkID(parentCarrier, hubID) || hubID < 0);
            System.out.println("");

            addHub(parentCarrier, hubName, hubID);
          }




    private void addHub(String parentCarrier, String hubName, int hubID){

        Carrier c = Network.carrierMap.get(parentCarrier);

        //Check if hub exists

        Hub hub = new Hub(hubName, hubID);

        c.hubs.put(hub.getName(), hub);

        //hub.nodes.values();
    }



    private boolean checkID(String parentCarrier, int hubID) {

        boolean idCheck = true;

        for (Map.Entry<String, Hub> entry : Network.carrierMap.get(parentCarrier).hubs.entrySet()) {

            if (entry.getValue().getId() == hubID) {
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
