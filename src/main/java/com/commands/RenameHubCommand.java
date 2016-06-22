package com.commands;



import com.main.Hub;
import com.main.Node;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class RenameHubCommand implements Command {


    private Scanner sc = new Scanner(System.in);
    private Hub hubs;

    private String hubName;
    private String newName;

    Node node = new Node();

    public void execute() {

        System.out.println("Rename Hub");

        hubs = new Hub();
        Hub.listHubs();
        System.out.println("");


        do {
            System.out.print("Choose the hub you would like to rename: ");
            hubName = sc.next();
        }while (!hubs.contains(hubName));



        System.out.println("");


        do{
        System.out.print("Enter the new name for the hub: ");
        newName = sc.next();
        }while(hubs.containsUnique(newName));

        replaceName(hubName, newName);

    }



    private void replaceName(String hubName, String newName){

        Set<Hub> hubSet = hubs.getHub();

        Hub h1 = new Hub();

        for (Iterator<Hub> i = hubSet.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getName().equalsIgnoreCase(hubName)) {
                h1 = h;
                i.remove();
            }
        }

        h1.setName(newName);

        hubSet.add(h1);

        hubs.setHub(hubSet);

        replaceHubParent(hubName, newName);
    }



    public void replaceHubParent(String carrierName, String newName){

       node.replaceName(carrierName, newName);

    }


}
