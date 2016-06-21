package com.commands;


import com.main.Main;

public class ListCarrierCommand implements Command{


    public void execute() {
        System.out.println("Listing Carriers");
        Main main = new Main();
        main.listCarriers();
    }





}
