package com.main;


import java.util.HashMap;

public class Carrier extends Base{


    String name;


    public static HashMap<String, Hub> map = new HashMap<String, Hub>();


    public Carrier(){

    }

    public Carrier(String name){
        super(name);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public void deleteCarrier(String key){
        map.remove(key);

    }


    public void listAllCarriers(){
        for ( String key : map.keySet() ) {
            System.out.println( key );
        }
    }


    public boolean keyExists(String value) {
        if (map.containsKey(value)) {
            return true;

        } else {
            return false;
        }
    }


    public static void populateMap(){

        Hub hub1 = new Hub();
        Hub hub2 = new Hub();

        map.put("Vodafone", hub1);
        map.put("Three", hub2);
    }



}

