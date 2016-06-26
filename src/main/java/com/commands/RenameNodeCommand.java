package com.commands;


import com.main.Network;
import com.main.Node;

import java.util.Scanner;

public class RenameNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);
    private String carrier;
    private String hub;
    private String node;
    private String newName;



    public void execute(){


        System.out.println("");
        System.out.print("Rename Nodes");
        System.out.println("");

        System.out.print("Enter a carrier: ");
        carrier = scan.nextLine();
        System.out.println("");

        System.out.print("Enter a hub: ");
        hub = scan.nextLine();
        System.out.println("");

        System.out.print("Which node would you like to rename?: ");
        node = scan.nextLine();

        System.out.println(""); System.out.print("Enter a new name for the node: ");
        newName = scan.nextLine();
        System.out.println("");


        renameNode(carrier, hub, node, newName);
    }




    public void renameNode(String carrier, String hub, String node, String newName){


        Node n = Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(node);

        Network.carrierMap.get(carrier).hubs.get(hub).nodes.put(newName, n);

    }
}
