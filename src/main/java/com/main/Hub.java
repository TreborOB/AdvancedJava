package com.main;


import java.util.HashSet;
import java.util.Set;

public class Hub extends Base{


    private String unitAvailability;
    private String parentNetwork;

    private Set<Node> nodes = new HashSet<Node>();

    public Hub(String name, String parentNetwork, String unitAvailability){
        super(name);
        this.unitAvailability = unitAvailability;
        this.parentNetwork = parentNetwork;
    }



}
