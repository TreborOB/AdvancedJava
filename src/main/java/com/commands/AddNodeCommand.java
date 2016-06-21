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
        }while (!contains(parentHub));


        System.out.println("");

        do {
        System.out.print("Name of the node: ");
        nodeName = sc.next();
        }while (containsUnique(nodeName)) ;

        Node node = new Node(parentHub, nodeName);
        node.addNode(node);

        System.out.print(node.nodeSize());
    }





    //Checks to see if the carrier name is already in the set
    private boolean contains(String name) {

        Set<Hub> hubSet = hub.getHub();
        boolean hasHub = false;

        for (Iterator<Hub> i = hubSet.iterator(); i.hasNext();) {
            Hub h = i.next();
            if (h.getName().equalsIgnoreCase(name)) {
                hasHub = true;
            }
        }
        return hasHub;
    }




    private boolean containsUnique(String name) {

        Set<Node> nodeSet = node.getNodes();
        boolean hasNode = false;

        for (Iterator<Node> i = nodeSet.iterator(); i.hasNext();) {
            Node n = i.next();
            if (n.getParent().equalsIgnoreCase(parentHub) && n.getName().equalsIgnoreCase(nodeName)) {
                hasNode = true;
            }
        }
        return hasNode;
    }
}
