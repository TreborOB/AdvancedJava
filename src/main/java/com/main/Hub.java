package com.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hub extends Base{


    private String unitAvailability;
    private String parentNetwork;



    static Set<Hub> hub = new HashSet<Hub>();


    public Hub(){
        //populateHub();
    }

    public Hub(String name, String parentNetwork, String unitAvailability){
        super(name);
        this.unitAvailability = unitAvailability;
        this.parentNetwork = parentNetwork;
    }



    public String getUnitAvailability() {
        return unitAvailability;
    }

    public void setUnitAvailability(String unitAvailability) {
        this.unitAvailability = unitAvailability;
    }

    public String getParentNetwork() {
        return parentNetwork;
    }

    public void setParentNetwork(String parentNetwork) {
        this.parentNetwork = parentNetwork;
    }

    public void addHub(Hub hubIn){
        hub.add(hubIn);
    }



    public Set<Hub> getHub() {
        return hub;
    }

    public void setHub(Set<Hub> hub) {
        this.hub = hub;
    }



    //Displaying the list of hubs
    public static void listHubs() {
        for (Hub h : hub) {
            System.out.println("Hub name: " + h.getName() + " " + "Parent: " + h.getParentNetwork());
        }
    }



    //Deleting a specified node
    public void deleteHub(String name){


        for (Iterator<Hub> i = hub.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getName().equals(name)) {
                i.remove();
            }
        }

    }



    //Deleting a specified node
    public void deleteHubParent(String name){

        listHubs();

        for (Iterator<Hub> i = hub.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getParentNetwork().equals(name)) {
                i.remove();
            }
        }


    }


    public int hubSize(){
        int setSize = hub.size();
        return setSize;
    }




    //Pre-populating the carrier list
    public static void populateHub() {

        Hub h1 = new Hub("Hub1", "Three", "available");
        Hub h2 = new Hub("Hub2", "Vodafone", "available");
        Hub h3 = new Hub("Hub3", "Meteor", "available");
        Hub h4 = new Hub("Hub4", "Tesco", "available");


        hub.add(h1);
        hub.add(h2);
        hub.add(h3);
        hub.add(h4);
    }



    //Replaces the name of the parentCarrier
    public void replaceName(String carrierName, String newName){

        Hub h1 = new Hub();

        String hubName = "";



        for (Iterator<Hub> i = hub.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getParentNetwork().equalsIgnoreCase(carrierName)) {
                h1 = h;
                hubName = h.getName();
                i.remove();
            }
        }

        h1.setName(newName);
        h1.setParentNetwork(parentNetwork);

        hub.add(h1);
    }



    //Checks to see if the hub name is already in the set
    public boolean contains(String name) {

        boolean hasCarrier = false;

        for (Iterator<Hub> i = hub.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getParentNetwork().equalsIgnoreCase(name)) {
                hasCarrier = true;
            }
        }
        return hasCarrier;
    }



    //Checks to see if the hub name is already in the set
    public boolean containsName(String name) {

        boolean hasCarrier = false;

        for (Iterator<Hub> i = hub.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getName().equalsIgnoreCase(name)) {
                hasCarrier = true;
            }
        }
        return hasCarrier;
    }


    public boolean containsUnique(String name) {


        boolean hasNode = false;

        for (Iterator<Hub> i = hub.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getName().equals(name)) {
                hasNode = true;
            }
        }
        return hasNode;
    }














}
