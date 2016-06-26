package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Map;

public class ListEntireNetwork implements Command{


    public void execute(){

        System.out.println("");
        System.out.println("listEntireNetwork");
        System.out.println("");

        listNetwork();
    }


    private void listNetwork(){


        String hubs;
        String nodes;

        if (Network.carrierMap.size()==0) {
            System.out.println("The network is empty");
        }
        {
            for (Map.Entry<String, Carrier> entry: Network.carrierMap.entrySet()) {
                System.out.println("Carrier name: " + entry.getKey());
                hubs = entry.getKey();

                for (Map.Entry<String, Hub> entryHub: Network.carrierMap.get(hubs).hubs.entrySet()) {
                    System.out.println("");
                    System.out.println("Hub name: " + entryHub.getKey());
                    System.out.println("Hub alarms: " + entryHub.getValue().getAlarm().getAlarmType());
                    nodes = entryHub.getKey();

                    for (Map.Entry<String, Node> entryNode: Network.carrierMap.get(hubs).hubs.get(nodes).nodes.entrySet()) {
                        System.out.println("");
                        System.out.println("Node name: " + entryNode.getKey());
                        System.out.println("Node alarms: " + entryNode.getValue().getAlarm().getAlarmType());
                    }

                }


                System.out.println("------------------------");
                System.out.println("");

            }



        }

    }



}
