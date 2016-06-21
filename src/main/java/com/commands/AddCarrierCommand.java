package com.commands;



import com.main.Carrier;
import com.main.Main;

import java.util.Scanner;

public class AddCarrierCommand implements Command{

    Scanner sc = new Scanner(System.in);


    public void execute() {
        System.out.print("Please enter the name of the carrier: ");
        String name = sc.next();
        createCarrier(name);
    }


    public void createCarrier(String name){
        Main main = new Main();
        Carrier carrier = new Carrier(name);
        main.addCarrier(carrier);
    }














}
