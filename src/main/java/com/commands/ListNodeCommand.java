package com.commands;


import com.main.Node;

public class ListNodeCommand implements Command{

    public void execute() {

        System.out.println("Listing Nodes");
        Node node = new Node();
        node.listNodes();

    }
}
