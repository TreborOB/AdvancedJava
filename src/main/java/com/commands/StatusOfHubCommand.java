package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;

public class StatusOfHubCommand implements Command {


    private Scanner scan = new Scanner(System.in);


    public void execute() {

        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the new carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (Network.carrierMap.containsKey(carrierName));

        ListElements.listHubs(carrierName);

        String nameOrID;

        System.out.println("");
        System.out.print("Enter the name or ID of the hub you wish to search for: ");
        nameOrID = scan.nextLine();

        searchByNameOrID(nameOrID);

    }

    public String chosenCarrier(String carrierName) {
        if (Network.carrierMap.containsKey(carrierName)) {
            System.out.println("Carrier with that name already exists, please choose another\n");
        }
        return carrierName;
    }


    //Allows the user to search hubs by either name or unique idea
    public void searchByNameOrID(String nameOrID) {

        Hub hub;
        String hubs;


        for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
            hubs = entry.getKey();

            for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {

                if (entryHub.getKey().equalsIgnoreCase(nameOrID) || entryHub.getValue().getId().equalsIgnoreCase(nameOrID)) {
                    System.out.println("");

                    hub = entryHub.getValue();
                    System.out.println("Name: " + hub.getName());
                    System.out.println("Id: " + hub.getId());
                    System.out.println("Alarm count: " + hub.getHubAlarms().size());

                }
            }
        }
    }
}



