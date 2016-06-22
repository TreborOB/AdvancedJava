package com.commands;


import com.main.Carrier;

import java.util.Scanner;

public class DeleteCarrierCommand implements Command {

    Scanner scan = new Scanner(System.in);
    Carrier c = new Carrier();

    String carrierToDelete;

    public void execute(){

        System.out.println("");
        c.listAllCarriers();
        System.out.println("");

        do {
            System.out.print("Enter the name of the carrier you would like to delete: ");
            carrierToDelete = scan.nextLine();
        }while(!c.keyExists(carrierToDelete));

        c.deleteCarrier(carrierToDelete);

    }
}
