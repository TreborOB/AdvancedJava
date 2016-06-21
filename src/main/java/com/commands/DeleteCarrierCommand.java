package com.commands;


import com.main.Main;

import java.util.Scanner;

public class DeleteCarrierCommand implements Command{


    Scanner sc = new Scanner(System.in);

    public void execute() {

        Main main = new Main();
        main.listCarriers();

        System.out.println("");
        System.out.print("Please enter the name of the carrier you would like to delete: ");
        String name = sc.next();

        main.deleteCarrier(name);
    }
}
