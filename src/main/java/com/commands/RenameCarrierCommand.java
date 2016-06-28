package com.commands;


import com.main.Carrier;
import com.main.Network;

import java.util.Scanner;

public class RenameCarrierCommand implements Command{

    Scanner scan = new Scanner(System.in);
    private String carrierToRename;
    private String newCarrierName;


    public void execute(){

        System.out.println("");
        System.out.println("Rename Carrier");
        System.out.println("---------------");

        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");


        System.out.print("Enter the name of the carrier you want to rename: ");
        carrierToRename = scan.nextLine();
        System.out.println("");


        System.out.print("Enter a new name for the carrier: ");
        newCarrierName =  scan.nextLine();
        System.out.println("");

        renameCarrier(carrierToRename, newCarrierName);
    }



    private void renameCarrier(String carrier, String newCarrierName){

        Carrier c = Network.carrierMap.remove(carrier);
        Network.carrierMap.put(newCarrierName, c);
    }
}
