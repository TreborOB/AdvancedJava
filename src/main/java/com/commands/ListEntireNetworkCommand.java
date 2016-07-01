package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Map;

public class ListEntireNetworkCommand implements Command {


    public void execute() {

        System.out.println("");
        System.out.println("List Network");
        System.out.println("-------------\n");

        listNetwork();
    }


    //Lists all network carriers, hubs and nodes
    public void listNetwork() {

        String hubs;
        String nodes;

        if (Network.carrierMap.size() == 0) {
            System.out.println("The network is empty");
        }
        {
            for (Map.Entry<String, Carrier> entry : Network.carrierMap.entrySet()) {
                System.out.println("Carrier name: " + entry.getKey());
                hubs = entry.getKey();

                for (Map.Entry<String, Hub> entryHub : Network.carrierMap.get(hubs).hubs.entrySet()) {
                    System.out.println("Hub name: " + entryHub.getKey());
                    nodes = entryHub.getKey();

                    for (Map.Entry<String, Node> entryNode : Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet()) {
                        System.out.println("Node name: " + entryNode.getKey());

                    }

                }

                System.out.println("");
            }


        }

    }


}
