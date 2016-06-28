package com.commands;



import com.main.Carrier;
import com.main.Network;

import java.util.Map;

public class ListAllCarriersCommand implements Command{

    public void execute(){

        System.out.println("");
        System.out.println("List carriers");
        System.out.println("--------------");
        listAllCarriers();
        System.out.println("");

    }

    public void listAllCarriers(){
        if(Network.carrierMap.size() == 0){
            System.out.println("No hubs exist");
        }else{
            for (Map.Entry<String, Carrier> entry: Network.carrierMap.entrySet()) {
                System.out.println(entry.getKey());
            }
        }
    }
}
