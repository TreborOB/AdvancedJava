package com.commands;


import com.main.Hub;

public class ListAllNodesCommand implements Command{


    Hub h = new Hub();

    public void execute(){


        System.out.println("");
        System.out.print("List All Nodes");
        System.out.println("");

        h.listAllNodes();




    }
}
