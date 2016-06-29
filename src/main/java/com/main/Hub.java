package com.main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Hub{


    private String name;
    private String id;

    public List<Alarm> hubAlarms = new ArrayList<>();
    public HashMap<String, Node> nodes = new HashMap<>();


    public Hub(){
    }

    public Hub(String name, String id){
        this.name = name;
        this.id = id;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Alarm> getHubAlarms() {
        return hubAlarms;
    }

    public void setHubAlarms(List<Alarm> hubAlarms) {
        this.hubAlarms = hubAlarms;
    }


}

