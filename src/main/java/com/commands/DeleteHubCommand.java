package com.commands;




import com.main.Hub;

import java.util.Scanner;

public class DeleteHubCommand implements Command{


    Scanner sc = new Scanner(System.in);

    public void execute() {

        Hub hub = new Hub();
        hub.listHubs();


        System.out.println("");
        System.out.print("Please enter the name of the hub you would like to delete: ");
        String name = sc.next();

        hub.deleteHub(name);
    }
}
