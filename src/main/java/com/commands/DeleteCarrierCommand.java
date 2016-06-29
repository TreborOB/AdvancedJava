package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteCarrierCommand implements Command {

    Scanner scan = new Scanner(System.in);

    public void execute(){


        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the name of the carrier you would like to delete: ");
            carrierName = scan.nextLine();
            SearchForElementName.searchForCarrier(carrierName);
        } while(!Network.carrierMap.containsKey(carrierName));


        deleteCarrier(carrierName);
    }



    private void deleteCarrier(String carrierToDelete){

        Network.carrierMap.remove(carrierToDelete);
        System.out.print(carrierToDelete + " deleted");
    }
}
