package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;

public class AddHubCommand implements Command {

    Scanner scan = new Scanner(System.in);


    public void execute() {


        System.out.println("");
        System.out.println("Carriers");
        System.out.println("---------");


        ListElements.listCarriers();


        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));

        ListElements.listHubs(carrierName);

        String hubName;
        do {
            System.out.print("Enter the new hubs name: ");
            hubName = scan.nextLine();

            chosenHub(carrierName, hubName);

        } while (Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


        System.out.println("");

        chosenID(carrierName, hubName);

    }


    //Adds new hub
    public void addHub(String parentCarrier, String hubName, String hubID) {

        Carrier c = Network.carrierMap.get(parentCarrier);

        Hub hub = new Hub(hubName, hubID);

        c.hubs.put(hub.getName(), hub);

        System.out.println("Hub " + hub.getName() + " added");
    }


    //Checks to see of ID is unique
    public boolean checkID(String parentCarrier, String hubID) {

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


    public String chosenCarrier(String carrierName) {


        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }


    public String chosenHub(String carrier, String hubName) {
        if (Network.carrierMap.get(carrier).hubs.containsKey(hubName)) {
            System.out.println("A hub with that name already exists, please choose another\n");
        }
        return hubName;
    }


    public void chosenID(String carrierName, String hubName) {

        String hubID;
        do {
            System.out.print("Enter an id for the hub: ");
            hubID = scan.nextLine();
        } while (!checkID(carrierName, hubID));
        System.out.println("");

        addHub(carrierName, hubName, hubID);
    }
}

