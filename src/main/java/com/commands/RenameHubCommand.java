package com.commands;


import com.main.Hub;
import com.main.Node;

import java.util.Scanner;

public class RenameHubCommand implements Command{


    Scanner scan = new Scanner(System.in);
    String hub;

    Hub h = new Hub();

    public void execute(){


        System.out.println("Rename Hub");
        System.out.println("");

        do {
            System.out.print("Enter the name of the hub you want to rename: ");
            hub = scan.nextLine();
            System.out.println("");
        }while(!h.keyExists(hub));


        System.out.print("Enter a new name for the hub:");
        String newHubName =  scan.nextLine();
        System.out.println("");


        Node newNode = Hub.map.remove(hub);
        Hub.map.put(newHubName, newNode);

    }
}


