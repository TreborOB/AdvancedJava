package com.commands;


import com.main.Carrier;

public class ListAllCarriersCommand implements Command{

    public void execute(){

        System.out.println("");

        Carrier c = new Carrier();
        c.listAllCarriers();

    }
}
