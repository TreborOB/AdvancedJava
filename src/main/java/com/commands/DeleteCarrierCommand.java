package com.commands;


import com.main.Carrier;

import java.util.Scanner;

public class DeleteCarrierCommand implements Command{


    Scanner sc = new Scanner(System.in);

    public void execute() {

        Carrier carrier = new Carrier();
        carrier.listCarriers();

        System.out.println("");
        System.out.print("Please enter the name of the carrier you would like to delete: ");
        String name = sc.next();

       carrier.deleteCarrier(name);
    }
}
