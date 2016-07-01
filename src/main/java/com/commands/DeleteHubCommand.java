package com.commands;


import com.main.Network;

import java.util.Scanner;

public class DeleteHubCommand implements Command {


    Scanner scan = new Scanner(System.in);

    public void execute() {

        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Enter the carriers name: ");
            carrierName = scan.nextLine();

            chosenCarrier(carrierName);

        } while (!Network.carrierMap.containsKey(carrierName));


        ListElements.listHubs(carrierName);


        String hubName;
        do {
            System.out.print("Enter the hubs name: ");
            hubName = scan.nextLine();

            chosenHub(hubName);

        } while (Network.carrierMap.get(carrierName).hubs.containsKey(hubName));

        String hub = hubToDelete(carrierName);

        deleteHub(carrierName, hub);
    }

    public String chosenCarrier(String carrierName) {
        if (!Network.carrierMap.containsKey(carrierName)) {
            System.out.println("No such carrier, please choose another\n");
        }
        return carrierName;
    }


    public String chosenHub(String hubName) {
        if (!Network.carrierMap.containsKey(hubName)) {
            System.out.println("No such hub exists, please choose another\n");
        }
        return hubName;
    }


    //Deletes the specified hub
    public String hubToDelete(String carrier) {

        String hubToDelete;
        do {
            System.out.print("Enter the name of the hub you would like to delete: ");
            hubToDelete = scan.nextLine();
            SearchForElementName.searchForHub(carrier, hubToDelete);
        } while (!Network.carrierMap.get(carrier).hubs.containsKey(hubToDelete));

        return hubToDelete;
    }


    public void deleteHub(String carrier, String hubToDelete) {

        Network.carrierMap.get(carrier).hubs.remove(hubToDelete);
        System.out.println(hubToDelete + " deleted");

    }

}
