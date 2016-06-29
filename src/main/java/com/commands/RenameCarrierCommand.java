package com.commands;


import com.main.Carrier;
import com.main.Network;

import java.util.Scanner;

public class RenameCarrierCommand implements Command{

    Scanner scan = new Scanner(System.in);


    public void execute(){

        System.out.println("");
        System.out.println("Rename Carrier");
        System.out.println("---------------");

        ListElements.listCarriers();

        String carrierToRename;
        do{
        System.out.print("Enter the name of the carrier you want to rename: ");
         carrierToRename= scan.nextLine();
          SearchForElementName.searchForCarrier(carrierToRename);
    } while (!Network.carrierMap.containsKey(carrierToRename));

    System.out.println("");

        String newCarrierName;

        do {
            System.out.print("Enter a new name for the carrier: ");
            newCarrierName = scan.nextLine();
            if(!Network.carrierMap.containsKey(carrierToRename)){
                System.out.println("Carrier name already exists, please choose another");
            }
        }while(!Network.carrierMap.containsKey(carrierToRename));

        System.out.println("");

        renameCarrier(carrierToRename, newCarrierName);
    }



    private void renameCarrier(String carrier, String newCarrierName){

        Carrier c = Network.carrierMap.remove(carrier);
        Network.carrierMap.put(newCarrierName, c);
    }
}
