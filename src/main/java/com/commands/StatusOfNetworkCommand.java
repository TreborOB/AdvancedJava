package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Map;
import java.util.Scanner;

public class StatusOfNetworkCommand implements Command {


    Scanner scan = new Scanner(System.in);

    public void execute() {

        System.out.println("");
        System.out.println("Network Status");
        System.out.println("--------------");

        viewAlarmStatusOfNetwork();

    }


    private void viewAlarmStatusOfNetwork() {

        System.out.println("");

        String hubs;
        String nodes;

        if (Network.carrierMap.size() == 0) {
            System.out.println("The network is empty");
        } else {
            for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
                hubs = entry.getKey();
                System.out.println("Carrier name: " + entry.getValue().getName());


                for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {
                    nodes = entryHub.getKey();
                    System.out.println("Hub alarms: " + entryHub.getValue().hubAlarms.size());


                    for (Map.Entry<String, Node> entryNode : Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet()) {
                        System.out.println("Node alarms: " + entryNode.getValue().nodeAlarms.size());

                    }
                }

                System.out.println("");
            }

        }
        System.out.println("");
    }


}
