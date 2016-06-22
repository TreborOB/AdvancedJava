package com.commands;


import com.main.Hub;

public class ListAllHubsCommand implements Command{


    public void execute(){

        System.out.println("");

        Hub h = new Hub();
        h.listAllHubs();
    }
}
