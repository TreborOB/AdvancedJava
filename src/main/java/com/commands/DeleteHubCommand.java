package com.commands;


import com.main.Hub;
import com.main.Network;

import java.util.Scanner;

public class DeleteHubCommand implements Command{


    Scanner scan = new Scanner(System.in);


    private String carrier;
    private String hubToDelete;

    public void execute() {


        System.out.println("");


        do {
            System.out.print("Enter a carrier: ");
            carrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(carrier));

        System.out.println("");

       do{
        System.out.print("Enter the name of the hub you would like to delete: ");
        hubToDelete = scan.nextLine();
       } while(!Network.carrierMap.get(carrier).hubs.containsKey(hubToDelete));



        deleteHub(carrier, hubToDelete);
    }



    public void deleteHub(String carrier, String hubToDelete){

        Network.carrierMap.get(carrier).hubs.remove(hubToDelete);

    }

}
