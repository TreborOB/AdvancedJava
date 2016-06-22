package com.main;


import java.util.HashMap;
import java.util.Map;

public class Hub extends Base{


    private String unitAvailability;

    public static HashMap<String, Node> map = new HashMap<String, Node>();


    public Hub(){

    }


    public Hub(String name, String unitAvailability){
        super(name);
        this.unitAvailability = unitAvailability;

    }

    public String getUnitAvailability() {
        return unitAvailability;
    }

    public void setUnitAvailability(String unitAvailability) {
        this.unitAvailability = unitAvailability;
    }


    public void deleteHub(String key){
        map.remove(key);

    }


    public void listAllHubs(){
        for ( String key : map.keySet() ) {
            System.out.println( key );
        }
    }

    public void listAllNodes(){
        for ( Map.Entry<String, Node> entry : map.entrySet() ) {
            System.out.println(entry.getValue().getName());
        }
    }

    public boolean keyExists(String key) {
        if (map.containsKey(key)) {
            return true;

        } else {
            return false;
        }
    }


    public boolean nodeExist(){
      if(map.containsValue("Node1")){
          return true;
      }else{
          return false;
      }
    }


    public static void populateMap(){

        Node node1 = new Node("Node1");
        Node node2 = new Node("Node2");

        map.put("Hub1", node1);
        map.put("Hub2", node2);
    }

}
