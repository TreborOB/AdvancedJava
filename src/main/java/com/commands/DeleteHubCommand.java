package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteHubCommand implements Command{


    Scanner scan = new Scanner(System.in);

    public void execute() {


        System.out.println("");

        ListAllCarriersCommand listCarriers = new ListAllCarriersCommand();
        listCarriers.listAllCarriers();
        System.out.println("");

       String carrier;
        do {
            System.out.print("Enter a carrier: ");
            carrier = scan.nextLine();
        }while(!Network.carrierMap.containsKey(carrier));

        System.out.println("");



        ListAllHubsCommand listHubs = new ListAllHubsCommand();
        listHubs.listAllHubs(carrier);
        System.out.println("");



        String hubToDelete;
       do{
        System.out.print("Enter the name of the hub you would like to delete: ");
        hubToDelete = scan.nextLine();
       } while(!Network.carrierMap.get(carrier).hubs.containsKey(hubToDelete));

        deleteHub(carrier, hubToDelete);
    }



    private void deleteHub(String carrier, String hubToDelete){

        Network.carrierMap.get(carrier).hubs.remove(hubToDelete);

    }

}
