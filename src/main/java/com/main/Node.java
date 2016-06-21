package com.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Node extends Base{

    private Set<Node> nodes = new HashSet<Node>();

    String parent;

    public Node(){
        populateNodes();
    }

    public Node(String parent, String name){
        super(name);
        this.parent = parent;

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
    public void listNodes() {
        for (Node n : nodes) {
            System.out.println("Node name: " + n.getName() + " " + "Parent: " + n.getParent());
        }
    }


    //Deleting a specified node
    public void deleteNode(String name){

        listNodes();

        for (Iterator<Node> i = nodes.iterator(); i.hasNext();) {
            Node n = i.next();
            if (n.getNodes().equals(name)) {
                i.remove();
            }
        }
        System.out.print(nodes.size());

    }




    //Pre-populating the carrier list
    public void populateNodes() {

        Node n1 = new Node("Hub1", "Node1");
        Node n2 = new Node("Hub2", "Node2");
        Node n3 = new Node("Hub3", "Node3");
        Node n4 = new Node("Hub4", "Node4");

        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);

    }

}
