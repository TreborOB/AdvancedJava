package com.commands;


import com.main.Hub;

public class ListHubCommand implements Command{

    public void execute() {

        System.out.println("Listing Hubs");
        Hub.listHubs();


    }
}
