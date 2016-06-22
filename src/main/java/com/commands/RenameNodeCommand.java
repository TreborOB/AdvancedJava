package com.commands;


import com.main.Hub;

import java.util.Scanner;

public class RenameNodeCommand implements Command{

    Scanner scan = new Scanner(System.in);
    String parentHub;

    Hub h = new Hub();

    public void execute(){


        System.out.println("");
        System.out.print("Rename Nodes");
        System.out.println("");


        do {
            System.out.print("Which hubs nodes do you want to rename?: ");
            parentHub = scan.nextLine();
            System.out.println("");
        }while(!h.keyExists(parentHub));



    }
}
