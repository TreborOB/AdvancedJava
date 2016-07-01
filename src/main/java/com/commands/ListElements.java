package com.commands;


public class ListElements {


    public static void listCarriers() {

        System.out.println("");
        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");
    }


    public static void listHubs(String parentCarrier) {

        System.out.println("");
        ListAllHubsCommand listHubs = new ListAllHubsCommand();
        listHubs.listAllHubs(parentCarrier);
        System.out.println("");
    }


    public static void listNodes(String parentCarrier, String hubName) {

        System.out.println("");
        ListAllNodesCommand listNodes = new ListAllNodesCommand();
        listNodes.listAllNodes(parentCarrier, hubName);
        System.out.println("");
    }


}
