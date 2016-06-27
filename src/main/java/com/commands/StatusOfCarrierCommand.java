package com.commands;


import com.main.Network;

import java.util.Scanner;

public class StatusOfCarrierCommand implements Command{


    private Scanner scan = new Scanner(System.in);


    public void execute() {

        String carrier;

        do {
            System.out.println("");
            System.out.print("Please enter the carrier name: ");
            carrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(carrier));


    }

}
