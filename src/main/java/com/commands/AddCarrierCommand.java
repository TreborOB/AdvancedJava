package com.commands;


import com.main.Carrier;
import com.main.Network;

import java.util.Scanner;

public class AddCarrierCommand implements Command{

    Scanner sc = new Scanner(System.in);
    Carrier c;
    private String carrierName;

    public void execute(){

            System.out.println("");
            System.out.print("Add Carrier");
            System.out.println("");



        do {
            System.out.print("Enter the carrier name: ");
            carrierName = sc.nextLine();
        }while(Network.carrierMap.containsKey(carrierName));


            System.out.println("");

            addCarrier(carrierName);
        }


     private void addCarrier(String carrierName){
           Carrier c = new Carrier(carrierName);
           Network.carrierMap.put(c.getName(), c);
       }


    }

