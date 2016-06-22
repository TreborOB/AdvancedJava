package com.commands;


import com.main.Hub;

import java.util.Scanner;

public class DeleteHubCommand implements Command{


    Scanner scan = new Scanner(System.in);
    Hub h = new Hub();

    String hubToDelete;

    public void execute(){


        System.out.println("");
        h.listAllHubs();
        System.out.println("");



        do{
        System.out.print("Enter the name of the hub you would like to delete: ");
         hubToDelete = scan.nextLine();
        }while(!h.keyExists(hubToDelete));

        h.deleteHub(hubToDelete);


    }
}
