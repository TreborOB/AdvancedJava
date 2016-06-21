package com.commands;


import com.main.Carrier;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class RenameCarrierCommand implements Command{

    private Scanner sc = new Scanner(System.in);
    private Carrier carriers;

    private String carrierName;

    public void execute() {


        System.out.println("Rename Carrier");

        carriers = new Carrier();
        carriers.listCarriers();
        System.out.println("");

        System.out.print("Choose the carrier you would like to rename: ");
        carrierName = sc.next();

        replaceName(carrierName);

    }


    private void replaceName(String name){

        Set<Carrier> carrierSet = carriers.getCarriers();

        Carrier c1 = new Carrier();

        for (Iterator<Carrier> i = carrierSet.iterator(); i.hasNext();) {
            Carrier c = i.next();
            if (c.getName().equalsIgnoreCase(name)) {
                c1 = c;
                i.remove();

            }
        }

         System.out.print(c1.getName());
    }






}
