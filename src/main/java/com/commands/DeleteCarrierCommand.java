package com.commands;


import com.main.Carrier;
import com.main.Network;

import java.util.Scanner;

public class DeleteCarrierCommand implements Command {

    Scanner scan = new Scanner(System.in);
    Carrier c = new Carrier();

    private String carrierToDelete;

    public void execute(){

        System.out.println("");


        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");

        do {
            System.out.print("Enter the name of the carrier you would like to delete: ");
            carrierToDelete = scan.nextLine();
        } while(!Network.carrierMap.containsKey(carrierToDelete));


        deleteCarrier(carrierToDelete);
    }



    public void deleteCarrier(String carrierToDelete){

        Network.carrierMap.remove(carrierToDelete);
    }
}
