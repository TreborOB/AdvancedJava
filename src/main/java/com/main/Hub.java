package com.main;


import java.util.HashMap;


public class Hub{


    private String name;
    private int id;
    private Alarm alarm;

    public HashMap<String, Node> nodes = new HashMap<>();


    public Hub(){
    }

    public Hub(String name, int id, Alarm alarm){
        this.name = name;
        this.id = id;
        this.alarm = alarm;

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

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }
}

