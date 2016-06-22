package com.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Node extends Base{

    static Set<Node> nodes = new HashSet<Node>();


    private String parent;

    Hub hub = new Hub();


    public Node(){
        //populateNodes();

    }

    public Node(String parent, String name){
        super(name);
        this.parent = parent;

    }

    public Set<Node> getNode() {
        return nodes;
    }


    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }




    public void addNode(Node node){
        nodes.add(node);
    }


    //Displaying the list of nodes
    public static void listNodes() {
        for (Node n : nodes) {
            System.out.println("Parent name: " +n.getParent() +" Node name: " + n.getName());
        }
    }



    public int nodeSize(){
        int setSize = nodes.size();
        return setSize;
    }


    //Pre-populating the carrier list
    public static void populateNodes() {

        Node n1 = new Node("Hub1", "Node1");
        Node n2 = new Node("Hub2", "Node2");
        Node n3 = new Node("Hub3", "Node3");
        Node n4 = new Node("Hub4", "Node4");

        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);

    }

    //Deleting a specified node
    public void deleteNode(String name){


        for (Iterator<Node> i = nodes.iterator(); i.hasNext();) {
            Node n = i.next();
            if (n.getName().equals(name)) {
                i.remove();
            }
        }


    }



    //Deleting a specified node
    public void deleteNodeParent(String name){

        listNodes();

        for (Iterator<Node> i = nodes.iterator(); i.hasNext();) {
            Node n = i.next();
            if (n.getParent().equals(name)) {
                i.remove();
            }
        }


        System.out.print(nodes.size());

    }


    //Replaces the name of the parentCarrier
    public void replaceName(String parentName, String newName){

        Node n1 = new Node();

        String nodeName = "";

        for (Iterator<Node> i = nodes.iterator(); i.hasNext();) {
            Node n = i.next();
            if (n.getParent().equalsIgnoreCase(parentName)) {
                n1 = n;
                nodeName = n.getName();
                i.remove();
            }
        }

        n1.setName(nodeName);
        n1.setParent(newName);

        nodes.add(n1);

    }




    //Checks to see if the nodes name is already in the set
    public boolean contains(String name) {

        boolean hasNode = false;

        for (Iterator<Node> i = nodes.iterator(); i.hasNext();) {
            Node h = i.next();
            if (h.getParent().equalsIgnoreCase(name)) {
                hasNode = true;
            }
        }
        return hasNode;
    }


    //Checks to see if the nodes name is already in the set
    public boolean containsName(String name) {

        boolean hasNode = false;

        for (Iterator<Node> i = nodes.iterator(); i.hasNext();) {
            Node h = i.next();
            if (h.getName().equalsIgnoreCase(name)) {
                hasNode = true;
            }
        }
        return hasNode;
    }



    public boolean containsUnique(String name) {

        boolean hasNode = false;

        for (Iterator<Node> i = nodes.iterator(); i.hasNext();) {
            Node n = i.next();
            if (n.getParent().equalsIgnoreCase(name) && n.getName().equalsIgnoreCase(name)) {
                hasNode = true;
            }
        }
        return hasNode;
    }




}
