package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteHubCommand implements Command{


    Scanner scan = new Scanner(System.in);

    public void execute() {

        ListElements.listCarriers();

       String carrier;
        do {
            System.out.print("Enter a carrier: ");
            carrier = scan.nextLine();
            SearchForElementName.searchForCarrier(carrier);
        }while(!Network.carrierMap.containsKey(carrier));


        ListElements.listHubs(carrier);


        String hubToDelete;
       do{
        System.out.print("Enter the name of the hub you would like to delete: ");
        hubToDelete = scan.nextLine();
           SearchForElementName.searchForHub(carrier, hubToDelete);
       } while(!Network.carrierMap.get(carrier).hubs.containsKey(hubToDelete));

        deleteHub(carrier, hubToDelete);
    }



    private void deleteHub(String carrier, String hubToDelete){

        Network.carrierMap.get(carrier).hubs.remove(hubToDelete);

    }

}
