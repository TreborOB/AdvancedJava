package com.commands;


import com.main.Carrier;
import com.main.Network;

import java.util.Scanner;

public class AddCarrierCommand implements Command{

    private Scanner scan = new Scanner(System.in);



    public void execute(){

        System.out.println("");
        System.out.println("Current carriers");
        System.out.println("----------------");


        ListElements.listCarriers();

        String carrierName;

        do {
            System.out.print("Enter the new carriers name: ");
            carrierName = scan.nextLine();
            if(Network.carrierMap.containsKey(carrierName)){
                System.out.println("Carrier with that name already exists, please choose another");
            }
        }while(Network.carrierMap.containsKey(carrierName));

            System.out.println("");

            addCarrier(carrierName);



        }


         private void addCarrier(String carrierName){
             Carrier c = new Carrier(carrierName);
             Network.carrierMap.put(c.getName(), c);
             System.out.print(carrierName + " added");
     }


    }

