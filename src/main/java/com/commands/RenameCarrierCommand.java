package com.commands;


import com.main.Carrier;
import com.main.Network;

import java.util.Scanner;

public class RenameCarrierCommand implements Command {

    Scanner scan = new Scanner(System.in);


    public void execute() {

        System.out.println("");
        System.out.println("Rename Carrier");
        System.out.println("---------------");

        ListElements.listCarriers();


        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));

        System.out.println("");

        String newCarrierName = newName(carrierName);

        System.out.println("");

        renameCarrier(carrierName, newCarrierName);
    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }

    //Takes in the new name for the carrier
    public String newName(String carrier) {

        String newName;

        do {
            System.out.print("Enter a new name for the carrier: ");
            newName = scan.nextLine();
            if (!Network.carrierMap.containsKey(carrier)) {
                System.out.println("Carrier name already exists, please choose another");
            }
        } while (!Network.carrierMap.containsKey(carrier));

        return newName;
    }


    //Renames the specified carrier
    public void renameCarrier(String carrier, String newCarrierName) {

        Carrier c = Network.carrierMap.remove(carrier);
        c.setName(newCarrierName);
        Network.carrierMap.put(newCarrierName, c);
    }
}
