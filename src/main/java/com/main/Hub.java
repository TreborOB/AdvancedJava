package com.main;


import java.util.HashMap;


public class Hub extends Alarm{


    private String name;
    private int id;

    public HashMap<String, Node> nodes = new HashMap<>();


    public Hub(){
    }

    public Hub(String name, int id){
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
}
