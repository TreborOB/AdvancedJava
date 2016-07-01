package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class StatusOfCarrierCommand implements Command {


    private Scanner scan = new Scanner(System.in);


    public void execute() {

        String carrier;


        ListElements.listCarriers();

        do {
            System.out.print("Please enter the carrier name: ");
            carrier = scan.nextLine();
            SearchForElementName.searchForCarrier(carrier);
        } while (!Network.carrierMap.containsKey(carrier));

        carrierStatus(carrier);

    }


    //Displays an overview of the specified carrier
    public void carrierStatus(String carrier) {

        String hubs;
        String nodes;
        System.out.println("");

        if (Network.carrierMap.size() == 0) {
            System.out.println("The network is empty");
        } else {
            for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
                hubs = entry.getKey();

                if (hubs.equalsIgnoreCase(carrier)) {
                    System.out.println("Carrier name: " + entry.getValue().getName());


                    for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {
                        nodes = entryHub.getKey();
                        System.out.println("Hub alarms: " + entryHub.getValue().hubAlarms.size());


                        for (Map.Entry<String, Node> entryNode : Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet()) {
                            System.out.println("Node alarms: " + entryNode.getValue().nodeAlarms.size());

                        }
                    }
                }
            }
        }
    }
}
