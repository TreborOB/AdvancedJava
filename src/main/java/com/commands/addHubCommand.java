package com.commands;


import com.main.Carrier;
import com.main.Hub;


import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AddHubCommand implements Command{

    private Scanner sc = new Scanner(System.in);
    private Carrier carriers;
    private Hub hubs;

    private String network;
    private String hubName;
    private String hubAvailability;




    public void execute() {

        carriers = new Carrier();
        carriers.listCarriers();

        hubs = new Hub();

        do{
        System.out.print("Choose a carrier to associate the hub with: ");
        network = sc.next();
         }while (!hubs.contains(network)) ;


        do{
        System.out.println("");
        System.out.print("Name of the hub: ");
        hubName = sc.next();
        }while (hubs.containsUnique(hubName)) ;

        System.out.println("");


        System.out.print("Hub availability (available/unavailable): ");
        hubAvailability = sc.next();



        Hub hub = new Hub(network, hubName, hubAvailability);
        hub.addHub(hub);

        System.out.print(hub.hubSize());

    }





}
