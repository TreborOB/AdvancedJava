package com.commands;



import com.main.Carrier;



import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AddCarrierCommand implements Command{

    private Scanner sc = new Scanner(System.in);
    private Carrier carriers;

    public void execute() {

        carriers = new Carrier();
        carriers.listCarriers();
        System.out.println("");

        String name;

        do{
            System.out.print("Please enter the name of the carrier: ");
            name = sc.next();
        }while (carriers.contains(name)) ;

        createCarrier(name);
    }



    private void createCarrier(String name){

        Carrier carrier = new Carrier(name);
        carrier.addCarrier(carrier);

        System.out.print(carrier.carrierSize());
    }










}
