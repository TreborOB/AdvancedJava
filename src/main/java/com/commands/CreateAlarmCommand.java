package com.commands;


import com.main.Network;

import java.util.Scanner;

public class CreateAlarmCommand implements Command{


    Scanner scan = new Scanner(System.in);
    private ListAllHubsCommand listHubs = new ListAllHubsCommand();
    private ListAllNodesCommand listNodes = new ListAllNodesCommand();

    public void execute(){

        System.out.println("");
        System.out.print("Create an alarm");
        System.out.println("");

        String carrierName;

        do{
        System.out.println("");
        System.out.print("Please choose a carrier: ");
        carrierName = scan.nextLine();
        }while(!Network.carrierMap.containsKey(carrierName));

        System.out.println("");

        System.out.print("Would you like to create an alarm on a hub or node?: ");
        String alarmOnHubOrNode = scan.nextLine();
        System.out.println("");


        if(alarmOnHubOrNode.equalsIgnoreCase("Hub")){
            createAlarmOnHub(carrierName);

        }else if(alarmOnHubOrNode.equalsIgnoreCase("Node")){
            createAlarmOnNode(carrierName);
        }

    }



    private void createAlarmOnHub(String carrier){
        System.out.println("");
        System.out.println("Alarm on hub");

        listHubs.listAllHubs(carrier);


        String chosenHub;
        do{
            System.out.print("Choose a hub: ");
            chosenHub = scan.nextLine();
            System.out.println("");
        }while(!Network.carrierMap.get(carrier).hubs.containsKey(chosenHub));

        createHubAlarm(carrier, chosenHub);

    }


    private void createAlarmOnNode(String carrier){
        System.out.println("");
        System.out.println("Alarm on node");

        System.out.println("");

        listHubs.listAllHubs(carrier);

        System.out.println("");


        String chosenHub;
        do{
        System.out.print("Choose a hub: ");
        chosenHub = scan.nextLine();
        System.out.println("");
        }while(!Network.carrierMap.get(carrier).hubs.containsKey(chosenHub));


        System.out.println("");

        listNodes.listAllNodes(carrier, chosenHub);

        System.out.println("");


        String chosenNode;
        do{
        System.out.print("Choose a node: ");
        chosenNode = scan.nextLine();
        System.out.println("");
        }while(!Network.carrierMap.get(carrier).hubs.get(chosenHub).nodes.containsKey(chosenNode));

        createNodeAlarm();

    }




    private void createHubAlarm(String carrier, String chosenHub){


        System.out.println("");
        System.out.println("Choose the alarm type: ");
        System.out.println("----------------------");
        System.out.println("Unit unavailable");
        System.out.println("Optical loss");
        System.out.println("Dark fibre");
        System.out.println("Power outage");
        String alarmType = scan.nextLine();

        System.out.println("");

        Network.carrierMap.get(carrier).hubs.get(chosenHub).setAlarmType(alarmType);


    }


    private void createNodeAlarm(){

    }







}
