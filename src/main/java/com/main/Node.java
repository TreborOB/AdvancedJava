package com.main;


import java.util.ArrayList;
import java.util.List;

public class Node{


    private String name;
    private int id;


    public List<Alarm> hubAlarms = new ArrayList<>();


    public Node(){

    }

    public Node(String name, int id){
       this.name = name;
       this.id = id;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Alarm> getHubAlarms() {
        return hubAlarms;
    }

    public void setHubAlarms(List<Alarm> hubAlarms) {
        this.hubAlarms = hubAlarms;
    }
}
