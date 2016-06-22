package com.commands;


import com.main.Carrier;
import com.main.Hub;

import java.util.Scanner;

public class RenameCarrierCommand implements Command{

    Scanner scan = new Scanner(System.in);
    String carrier;
    Carrier c = new Carrier();

    public void execute(){

        System.out.println("Rename Carrier");
        System.out.println("");


        do {
            System.out.print("Enter the name of the carrier you want to rename: ");
            carrier = scan.nextLine();
            System.out.println("");
        }while(!c.keyExists(carrier));

        System.out.print("Enter a new name for the carrier:");
        String newCarrierName =  scan.nextLine();
        System.out.println("");


        Hub newHub = Carrier.map.remove(carrier);
        Carrier.map.put(newCarrierName, newHub);


    }
}
