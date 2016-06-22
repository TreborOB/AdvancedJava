package com.main;

import com.commands.*;

import java.util.*;

public class Main {


    public static void main(String[] args){


        Carrier.populateMap();
        Hub.populateMap();


        Scanner scan = new Scanner(System.in);

        Map<String, Command> commands = new HashMap<String, Command>();

        Command addCarrier          = new AddCarrierCommand();
        Command deleteCarrier       = new DeleteCarrierCommand();
        Command renameCarrier       = new RenameCarrierCommand();
        Command listAllCarriers     = new ListAllCarriersCommand();

        Command addHub              = new AddHubCommand();
        Command deleteHub           = new DeleteHubCommand();
        Command renameHub           = new RenameHubCommand();
        Command listAllHubs         = new ListAllHubsCommand();


        Command addNode             = new AddNodeCommand();
        Command deleteNode          = new DeleteNodeCommand();
        Command renameNode          = new RenameNodeCommand();
        Command listAllNodes        = new ListAllNodesCommand();



        commands.put("addCarrier",  addCarrier);
        commands.put("deleteCarrier",  deleteCarrier);
        commands.put("renameCarrier",  renameCarrier);
        commands.put("listCarriers",  listAllCarriers);

        commands.put("addHub",  addHub);
        commands.put("deleteHub",  deleteHub);
        commands.put("renameHub",  renameHub);
        commands.put("listHubs",  listAllHubs);

        commands.put("addNode",  addNode);
        commands.put("deleteNode",  deleteNode);
        commands.put("renameNode",  renameNode);
        commands.put("listNodes",  listAllNodes);



        String choice;

        do {
            System.out.println("");
            System.out.println("DAS network manager");
            System.out.println("--------------------");
            System.out.println("addCarrier");
            System.out.println("deleteCarrier");
            System.out.println("renameCarrier");
            System.out.println("listCarriers");
            System.out.println("");
            System.out.println("");
            System.out.println("addHub");
            System.out.println("deleteHub");
            System.out.println("renameHub");
            System.out.println("listHubs");
            System.out.println("");
            System.out.println("");
            System.out.println("addNode");
            System.out.println("deleteNode");
            System.out.println("renameNode");
            System.out.println("listNodes");



            System.out.println("");
            System.out.print("Enter a command: ");
            choice = scan.nextLine();


            try{
            commands.get(choice).execute();
            } catch(NullPointerException e){

            }

        }while(!choice.equals("Exit"));



    }
}
