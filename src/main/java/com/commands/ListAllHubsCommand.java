package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;

import java.util.Map;
import java.util.Scanner;


public class ListAllHubsCommand implements Command{


    Scanner scan = new Scanner(System.in);
    private String parentCarrier;

    public void execute(){

        System.out.println("");


        do {
            System.out.println("Which carriers hubs would you like to view?");
            parentCarrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(parentCarrier));

        System.out.println("");

        listAllHubs();


        }

        public void listAllHubs(){
            if(Network.carrierMap.get(parentCarrier).hubs.size() == 0){
                System.out.println("No hubs exist");
            }{
                for (Map.Entry<String, Hub> entry: Network.carrierMap.get(parentCarrier).hubs.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue().getId());
                }
    }


    }




}