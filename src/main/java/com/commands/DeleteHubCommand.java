package com.commands;




import com.main.Hub;
import com.main.Node;

import java.util.Scanner;

public class DeleteHubCommand implements Command{


    Scanner sc = new Scanner(System.in);
    Hub hub;

    Node node = new Node();

    String name;

    public void execute() {

        hub = new Hub();
        hub.listHubs();


        System.out.println("");

        do {
            System.out.print("Please enter the name of the hub you would like to delete: ");
            name = sc.next();
        }while(!hub.containsName(name));


        hub.deleteHub(name);
        deleteNode(name);

    }



    public void deleteNode(String name){
        node.deleteNodeParent(name);
    }
}
