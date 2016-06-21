package com.commands;



import com.main.Carrier;


import java.util.Scanner;

public class AddCarrierCommand implements Command{

    Scanner sc = new Scanner(System.in);


    public void execute() {
        System.out.print("Please enter the name of the carrier: ");
        String name = sc.next();
        createCarrier(name);
    }


    public void createCarrier(String name){

        Carrier carrier = new Carrier(name);
        carrier.addCarrier(carrier);
    }














}
