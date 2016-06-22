package com.commands;



import com.main.Carrier;
import com.main.Hub;
import com.main.Node;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AddNodeCommand implements Command{


    private Scanner sc = new Scanner(System.in);
    private Hub hub;
    private Node node;


    private String parentHub;
    private String nodeName;

    public void execute() {

        hub = new Hub();
        node = new Node();
        hub.listHubs();
        System.out.println("");


        do {
            System.out.print("Choose a hub to associate the node with: ");
            parentHub = sc.next();
        }while (!node.contains(parentHub));


        System.out.println("");

        do {
        System.out.print("Name of the node: ");
        nodeName = sc.next();
        }while (node.containsUnique(nodeName)) ;



        String s = hub.getParentNetwork();



        Node node = new Node(parentHub, nodeName);
        node.addNode(node);

        System.out.print(node.nodeSize());
    }

}
