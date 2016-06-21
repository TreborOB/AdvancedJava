package com.commands;



import com.main.Carrier;



import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AddCarrierCommand implements Command{

    private Scanner sc = new Scanner(System.in);
    private Carrier carriers;

    public void execute() {

        carriers = new Carrier();
        carriers.listCarriers();
        System.out.println("");

        String name;

        do{
            System.out.print("Please enter the name of the carrier: ");
            name = sc.next();
        }while (contains(name)) ;

        createCarrier(name);
    }



    private void createCarrier(String name){

        Carrier carrier = new Carrier(name);
        carrier.addCarrier(carrier);

        System.out.print(carrier.carrierSize());
    }



     //Checks to see if the carrier name is already in the set
     private boolean contains(String name) {

        Set<Carrier> carrierSet = carriers.getCarriers();
        boolean hasCarrier = false;

        for (Iterator<Carrier> i = carrierSet.iterator(); i.hasNext();) {
            Carrier c = i.next();
            if (c.getName().equalsIgnoreCase(name)) {
                hasCarrier = true;
            }
        }
        return hasCarrier;
    }






}
