package com.commands;


import com.main.Network;

public class SearchForElementName {


    public static void searchForCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println(carrierName + " is not a carrier within the system\n");
        }

    }

    public static void searchForHub(String carrierName, String hubName) {
        if (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName)) {
            System.out.println(hubName + " is not a hub within the system\n");
        }

    }


    public static void searchForNode(String carrierName, String hubName, String nodeName) {
        if (!Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName)) {
            System.out.println(nodeName + " is not a node within the system\n");
        }
    }

}
