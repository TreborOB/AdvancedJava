package com.commands;


import com.main.Carrier;
import com.main.Network;

import java.util.Scanner;

public class AddCarrierCommand implements Command{

    private Scanner scan = new Scanner(System.in);



    public void execute(){


        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();

        System.out.println("");
        System.out.println("Current carriers");
        System.out.println("----------------");
        listCarriers.listAllCarriers();
        System.out.println("");

        String carrierName;

        do {
            System.out.print("Enter the new carriers name: ");
            carrierName = scan.nextLine();
        }while(Network.carrierMap.containsKey(carrierName));

            System.out.println("");

            addCarrier(carrierName);
        }


     private void addCarrier(String carrierName){
           Carrier c = new Carrier(carrierName);
           Network.carrierMap.put(c.getName(), c);
       }


    }

