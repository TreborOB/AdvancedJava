package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;

import java.util.Scanner;

public class RenameHubCommand implements Command{


    Scanner scan = new Scanner(System.in);
    String carrier;
    String hub;


    Hub h = new Hub();

    public void execute(){


        System.out.println("Rename Hub");
        System.out.println("");


        System.out.print("Enter a carrier: ");
        carrier = scan.nextLine();
        System.out.println("");


        System.out.print("Enter the name of the hub you want to rename: ");
        hub = scan.nextLine();
        System.out.println("");



        System.out.print("Enter a new name for the hub:");
        String newHubName =  scan.nextLine();
        System.out.println("");

        renameHub(carrier, hub, newHubName);


    }



        public void renameHub(String carrier, String hub, String newHubName){


            Hub b = Network.carrierMap.get(carrier).hubs.remove(hub);


            Network.carrierMap.get(carrier).hubs.put(newHubName, b);

        }
}


