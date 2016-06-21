package com.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Carrier extends Base{


    private static Set<Carrier> carriers = new HashSet<Carrier>();


    public Carrier(){
        //populateCarriers();
    }

    public Carrier(String name){
        super(name);
    }


    public static Set<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(Set<Carrier> carriers) {
        this.carriers = carriers;
    }

    public void addCarrier(Carrier carrier){
        carriers.add(carrier);
    }


    //Displaying the list of carriers
    public static void listCarriers() {
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


    public int carrierSize(){
        int setSize = carriers.size();
        return setSize;
    }



    //Pre-populating the carrier list
    static void populateCarriers() {

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

