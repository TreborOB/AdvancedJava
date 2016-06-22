package com.commands;


import com.main.Carrier;
import com.main.Hub;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class RenameCarrierCommand implements Command{

    private Scanner sc = new Scanner(System.in);
    private Carrier carriers;


    private String carrierName;
    private String newName;
    Hub hub = new Hub();

    public void execute() {


        System.out.println("Rename Carrier");

        carriers = new Carrier();
        carriers.listCarriers();
        System.out.println("");



        do{
        System.out.print("Choose the carrier you would like to rename: ");
        carrierName = sc.next();
        }while (!carriers.contains(carrierName));


        System.out.println("");



       do {
         System.out.print("Enter the new name for the carrier : ");
         newName = sc.next();
       }while(carriers.containsUnique(newName));


        replaceName(carrierName, newName);

    }


    private void replaceName(String carrierName, String newName){

        Set<Carrier> carrierSet = carriers.getCarriers();

        Carrier c1 = new Carrier();

        for (Iterator<Carrier> i = carrierSet.iterator(); i.hasNext();) {
            Carrier c = i.next();
            if (c.getName().equalsIgnoreCase(carrierName)) {
                c1 = c;
                i.remove();
            }
        }

         c1.setName(newName);

         carrierSet.add(c1);

         carriers.setCarriers(carrierSet);

         replaceHubParent(carrierName, newName);
    }




    public void replaceHubParent(String carrierName, String newName){

        hub.replaceName(carrierName, newName);

    }











}
