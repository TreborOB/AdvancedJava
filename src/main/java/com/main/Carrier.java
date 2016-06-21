package com.main;


import java.util.HashSet;
import java.util.Set;

public class Carrier extends Base{


    private Set<Hub> hubs = new HashSet<Hub>();

    public Carrier(String name){
        super(name);
    }


    public void addHub(Hub hub){
        hubs.add(hub);
    }


}

