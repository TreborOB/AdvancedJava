package com.commands;


import com.main.Network;

import java.util.Scanner;

public class StatusOfNetworkCommand implements Command{


    Scanner scan = new Scanner(System.in);

    public void execute(){

        System.out.println("");
        System.out.println("Network Status");
        System.out.println("--------------");


        String carrier;


        do {
        System.out.println("");
        System.out.print("Please choose a network: ");
        carrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(carrier));

        viewAlarmStatusOfNetwork(carrier);


    }


    private void viewAlarmStatusOfNetwork(String network) {


    }




}
