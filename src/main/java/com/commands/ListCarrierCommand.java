package com.commands;


import com.main.Carrier;

public class ListCarrierCommand implements Command{


    public void execute() {

        System.out.println("Listing Carriers");
        Carrier.listCarriers();
    }
}
