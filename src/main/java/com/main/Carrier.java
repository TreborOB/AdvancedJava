package com.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Carrier extends Base{


    static Set<Carrier> carriers = new HashSet<Carrier>();


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


    //Displays the list of carriers
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



    //Checks to see if the carrier name is already in the set
    public boolean contains(String name) {


        boolean hasCarrier = false;

        for (Iterator<Carrier> i = carriers.iterator(); i.hasNext();) {
            Carrier c = i.next();
            if (c.getName().equalsIgnoreCase(name)) {
                hasCarrier = true;
            }
        }
        return hasCarrier;
    }



    public boolean containsUnique(String name) {


        boolean hasHub = false;

        for (Iterator<Carrier> i = carriers.iterator(); i.hasNext();) {
            Carrier c = i.next();
            if (c.getName().equals(name)) {
                hasHub = true;
            }
        }
        return hasHub;
    }






}

