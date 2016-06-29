package com.main;


import java.util.ArrayList;
import java.util.List;

public class Node{


    private String name;
    private String id;


    public List<Alarm> nodeAlarms = new ArrayList<>();


    public Node(){

    }

    public Node(String name, String id){
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

    public List<Alarm> getNodeAlarms() {
        return nodeAlarms;
    }

    public void setNodeAlarms(List<Alarm> hubAlarms) {
        this.nodeAlarms = hubAlarms;
    }

    public int returnNodeAlarmsSize(){
        return nodeAlarms.size();
    }
}
