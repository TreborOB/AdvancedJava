package com.commands;




import com.main.Node;

import java.util.Scanner;

public class DeleteNodeCommand implements Command{


    private Scanner sc = new Scanner(System.in);
    Node node;
    String name;

    public void execute() {

        node = new Node();
        node.listNodes();


        System.out.println("");


        do{
        System.out.print("Please enter the name of the node you would like to delete: ");
        name = sc.next();
        }while(!node.containsName(name));


        node.deleteNode(name);


    }

}
