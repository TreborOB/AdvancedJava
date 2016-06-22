package com.commands;


import com.main.Hub;

import java.util.Scanner;

public class AddNodeCommand implements Command{


    Scanner sc = new Scanner(System.in);
    String nodeName;
    String parentName;
    Hub h = new Hub();


    public void execute(){

        System.out.println("");
        System.out.print("Add Node");
        System.out.println("");

        do{
        System.out.print("Which hub would you like to associate the node with?: ");
        parentName = sc.nextLine();
        System.out.println("");
        }while(!h.keyExists(parentName));

        System.out.print("Enter the name of the node: ");
        nodeName = sc.nextLine();
        System.out.println("");




    }
}
