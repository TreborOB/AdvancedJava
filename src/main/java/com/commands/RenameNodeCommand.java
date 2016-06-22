package com.commands;



import com.main.Node;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class RenameNodeCommand implements Command {



    private Scanner sc = new Scanner(System.in);
    private Node nodes;

    private String nodeName;
    private String newName;


    public void execute() {

        System.out.println("Rename Node");

        nodes = new Node();
        Node.listNodes();
        System.out.println("");


        do{
        System.out.print("Choose the node you would like to rename: ");
        nodeName = sc.next();
        }while (!nodes.contains(nodeName));

        System.out.println("");


        do{
        System.out.print("Enter the new name for the node : ");
        newName = sc.next();
       }while(nodes.containsUnique(newName));


    replaceName(nodeName, newName);

    }


    private void replaceName(String hubName, String newName){

        Set<Node> nodeSet = nodes.getNodes();

        Node n1 = new Node();

        String parent = "";

        for (Iterator<Node> i = nodeSet.iterator(); i.hasNext();) {
            Node n = i.next();
            if (n.getName().equalsIgnoreCase(hubName)) {
                n1 = n;
                parent = n.getParent();
                i.remove();
            }
        }

        n1.setName(newName);
        n1.setParent(parent);

        nodeSet.add(n1);

        nodes.setNodes(nodeSet);
    }






}
