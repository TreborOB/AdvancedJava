package com.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Carrier extends Base{


    private Set<Carrier> carriers = new HashSet<Carrier>();


    public Carrier(){
        populateCarriers();
    }

    public Carrier(String name){
        super(name);
    }


    public void addCarrier(Carrier carrier){
        carriers.add(carrier);
    }


    //Displaying the list of carriers
    public void listCarriers() {
        for (Carrier c : carriers) {
            System.out.println(c.getName());
        }
    }




    //Deleting a specified carrier
    public void deleteCarrier(String name){

        for (Iterator<Carrier> i = carriers.iterator(); i.hasNext();) {
            Carrier c = i.next();
            if (c.getName().equals(name)) {
                i.remove();
            }
        }
        System.out.print(carriers.size());

    }



    //Pre-populating the carrier list
    public void populateCarriers() {

        Carrier c1 = new Carrier("Three");
        Carrier c2 = new Carrier("Vodafone");
        Carrier c3 = new Carrier("Meteor");
        Carrier c4 = new Carrier("Tesco");

        carriers.add(c1);
        carriers.add(c2);
        carriers.add(c3);
        carriers.add(c4);

    }

}

