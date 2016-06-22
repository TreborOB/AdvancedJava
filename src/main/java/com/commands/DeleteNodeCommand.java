package com.commands;


import com.main.Hub;

import java.util.Scanner;

public class DeleteNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);
    String nodeToDelete;

    Hub h = new Hub();


    public void execute(){


        System.out.println("");
        System.out.println("Delete Node");
        System.out.println("");

        h.listAllNodes();

        System.out.println("");


        System.out.print("Which node would you like to delete?: ");
        nodeToDelete = scan.nextLine();
        System.out.println("");


    }
}
