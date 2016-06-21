package com.commands;




import com.main.Node;

import java.util.Scanner;

public class DeleteNodeCommand implements Command{


    private Scanner sc = new Scanner(System.in);

    public void execute() {

        Node node = new Node();
        node.listNodes();


        System.out.println("");
        System.out.print("Please enter the name of the node you would like to delete: ");
        String name = sc.next();

        node.deleteNode(name);
    }
}
