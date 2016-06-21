package com.main;

import com.commands.*;

import java.util.*;

public class Main {


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Map<String, Command> commands = new HashMap<String, Command>();


        Command addCarrier               = new AddCarrierCommand();
        Command listCarriers             = new ListCarrierCommand();
        Command deleteCarrier            = new DeleteCarrierCommand();

        Command ListEntireNetworkCommand = new ListEntireNetworkCommand();

        Command addHub                   = new AddHubCommand();
        Command listHubs                 = new ListHubCommand();
        Command deleteHub                = new DeleteHubCommand();


        Command addNode                  = new AddNodeCommand();
        Command listNodes                = new ListNodeCommand();
        Command deleteNode               = new DeleteHubCommand();


        commands.put("addCarrier",  addCarrier);
        commands.put("listCarriers",  listCarriers);
        commands.put("deleteCarrier",  deleteCarrier);

        commands.put("ListEntireNetwork",  ListEntireNetworkCommand);

        commands.put("addHub",  addHub);
        commands.put("listHubs",  listHubs);
        commands.put("deleteHub",  deleteHub);



        commands.put("addNode",  addNode);
        commands.put("listNodes",  listNodes);
        commands.put("deleteNode",  deleteNode);


        String choice;

        do {
            System.out.println("");
            System.out.println("DAS network manager");
            System.out.println("--------------------");
            System.out.println("addCarrier");
            System.out.println("listCarriers");
            System.out.println("deleteCarrier");
            System.out.println("");


            System.out.println("ListEntireNetwork");
            System.out.println("");

            System.out.println("");
            System.out.println("addHub");
            System.out.println("listHubs");
            System.out.println("deleteHub");
            System.out.println("");

            System.out.println("");
            System.out.println("addNode");
            System.out.println("listNodes");
            System.out.println("deleteNode");
            System.out.println("");

            System.out.println("");
            System.out.println("Exit");
            System.out.println("");
            System.out.print("Enter a command: ");
            choice = scan.next();

            commands.get(choice).execute();

        }while(!choice.equals("Exit"));

    }

}
