package com.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hub extends Base{


    private String unitAvailability;
    private String parentNetwork;

    private static Set<Hub> hub = new HashSet<Hub>();


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

    //Displaying the list of nodes
    public static void listHubs() {
        for (Hub h : hub) {
            System.out.println("Hub name: " + h.getName() + " " + "Parent: " + h.getParentNetwork());
        }
    }


    //Deleting a specified node
    public void deleteHub(String name){

        listHubs();

        for (Iterator<Hub> i = hub.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getName().equals(name)) {
                i.remove();
            }
        }
        System.out.print(hub.size());

    }


    public int hubSize(){
        int setSize = hub.size();
        return setSize;
    }




    //Pre-populating the carrier list
    public static void populateHub() {

        Hub h1 = new Hub("Hub1", "Tesco", "available");
        Hub h2 = new Hub("Hub2", "Vodafone", "available");
        Hub h3 = new Hub("Hub3", "Tesco", "available");
        Hub h4 = new Hub("Hub4", "Meteor", "available");


        hub.add(h1);
        hub.add(h2);
        hub.add(h3);
        hub.add(h4);
    }

}
