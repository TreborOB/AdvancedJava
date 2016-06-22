package com.commands;


import com.main.Carrier;
import com.main.Hub;
import com.main.Node;

import java.util.Scanner;

public class DeleteCarrierCommand implements Command{


    Scanner sc = new Scanner(System.in);
    Carrier carrier;
    String name;

    Hub hub = new Hub();


    public void execute() {

        carrier = new Carrier();
        carrier.listCarriers();

        System.out.println("");


        do{
        System.out.print("Please enter the name of the carrier you would like to delete: ");
         name = sc.next();
        }while(!carrier.contains(name));

        carrier.deleteCarrier(name);
        deleteHub(name);

    }



    public void deleteHub(String name){
        hub.deleteHubParent(name);
    }



}
