package com.main;


import com.commands.AddCarrierCommand;
import com.commands.Command;
import com.commands.DeleteCarrierCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Map<String, Command> commands = new HashMap<String, Command>();



        Command addCarrier    = new AddCarrierCommand();
        Command deleteCarrier = new DeleteCarrierCommand();


        commands.put("addCarrier",  addCarrier);
        commands.put("deleteCarrier",  deleteCarrier);



        System.out.print("Enter a key "); //Ask the user for the key
        String s = scan.next();

        commands.get(s).execute();






    }
}
