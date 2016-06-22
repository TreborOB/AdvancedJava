package com.commands;


import com.main.Node;

public class ListNodeCommand implements Command{

    public void execute() {

        System.out.println("");
        Node.listNodes();

    }
}
