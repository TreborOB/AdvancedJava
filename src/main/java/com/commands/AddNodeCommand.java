package com.commands;



import com.main.Hub;
import com.main.Node;

import java.util.Scanner;

public class AddNodeCommand implements Command{


    Scanner sc = new Scanner(System.in);


    public void execute() {

        Hub hub = new Hub();
        hub.listHubs();


        System.out.println("");
        System.out.print("Choose a hub to associate the node with: ");
        String parentHub = sc.next();

        System.out.println("");
        System.out.print("Name of the node: ");
        String nodeName = sc.next();


        Node node = new Node(parentHub, nodeName);
        node.addNode(node);


    }
}
