package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteCarrierCommand implements Command {

    Scanner scan = new Scanner(System.in);

    public void execute() {


        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));


        deleteCarrier(carrierName);
    }


    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }


    //Delete the specified carrier
    public void deleteCarrier(String carrierToDelete) {

        Network.carrierMap.remove(carrierToDelete);
        System.out.println(carrierToDelete + " deleted");
    }
}
