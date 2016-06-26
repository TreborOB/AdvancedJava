package com.main;



public class Node{


    private String name;
    private int id;
    private Alarm alarm;


    public Node(){

    }

    public Node(String name, int id, Alarm alarm){
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
