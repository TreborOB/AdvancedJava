package com.commands;


import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;


public class ListAllHubsCommand implements Command {


    Scanner scan = new Scanner(System.in);


    public void execute() {

        System.out.println("");
        System.out.println("List hubs");
        System.out.println("----------\n");


        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));

        System.out.println("");

        listAllHubs(carrierName);
    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }

    public void listAllHubs(String parentCarrier) {
        if (Network.carrierMap.get(parentCarrier).hubs.size() == 0) {
            System.out.println("No hubs exist");
        }
        {
            for (Map.Entry<String, Hub> entry : Network.carrierMap.get(parentCarrier).hubs.entrySet()) {
                System.out.println("Hub name: " + entry.getKey() + "\n" + "ID: " + entry.getValue().getId());
                System.out.println("");
            }
        }


    }


}
