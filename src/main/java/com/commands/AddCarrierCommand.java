package com.commands;


import com.main.Carrier;
import com.main.Hub;

import java.util.Scanner;

public class AddCarrierCommand implements Command{

    Scanner sc = new Scanner(System.in);
    String carrierName;
    Carrier c = new Carrier();

        public void execute(){

            System.out.println("");
            System.out.print("Add Carrier");
            System.out.println("");

            do {
            System.out.print("Enter the carrier name: ");
            carrierName = sc.nextLine();
            System.out.println("");
            }while(c.keyExists(carrierName));


            Hub hub = new Hub();
            Carrier.map.put(carrierName, hub);

        }


    }

