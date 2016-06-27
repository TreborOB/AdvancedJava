package com.main;

import com.commands.*;


import java.util.*;

public class Main {



    public static void main(String[] args){


        Main main = new Main();
        main.populateValues();

        Scanner scan = new Scanner(System.in);

        Map<String, Command> commands = new HashMap<>();


        Command listEntireNetwork = new ListEntireNetwork();
        Command statusOfNetwork   = new StatusOfNetworkCommand();


        Command addCarrier        = new AddCarrierCommand();
        Command deleteCarrier     = new DeleteCarrierCommand();
        Command renameCarrier     = new RenameCarrierCommand();
        Command listAllCarriers   = new ListAllCarriersCommand();
        Command statusOfCarrier   = new StatusOfCarrierCommand();

        Command addHub            = new AddHubCommand();
        Command deleteHub         = new DeleteHubCommand();
        Command renameHub         = new RenameHubCommand();
        Command listAllHubs       = new ListAllHubsCommand();
        Command statusOfHub       = new StatusOfHubCommand();


        Command addNode           = new AddNodeCommand();
        Command deleteNode        = new DeleteNodeCommand();
        Command renameNode        = new RenameNodeCommand();
        Command listAllNodes      = new ListAllNodesCommand();
        Command statusOfNode      = new StatusOfNodeCommand();

        Command createAlarm       = new CreateAlarmCommand();
        Command clearAlarm  = new ClearAlarmCommand();

        SuggestedRemediesCommand suggestedRemedies = new SuggestedRemediesCommand();

        commands.put("listNetwork",  listEntireNetwork);
        commands.put("networkStatus",  statusOfNetwork);

        commands.put("addCarrier",  addCarrier);
        commands.put("deleteCarrier",  deleteCarrier);
        commands.put("renameCarrier",  renameCarrier);
        commands.put("listCarriers",  listAllCarriers);
        commands.put("carrierStatus",  statusOfCarrier);

        commands.put("addHub",  addHub);
        commands.put("deleteHub",  deleteHub);
        commands.put("renameHub",  renameHub);
        commands.put("listHubs",  listAllHubs);
        commands.put("hubStatus",  statusOfHub);


        commands.put("addNode",  addNode);
        commands.put("deleteNode",  deleteNode);
        commands.put("renameNode",  renameNode);
        commands.put("listNodes",  listAllNodes);
        commands.put("nodeStatus",  statusOfNode);

        commands.put("createAlarm",  createAlarm);
        commands.put("clearAlarm",  clearAlarm);
        commands.put("remedies",  suggestedRemedies);



        String choice;

        do {
            System.out.println("");
            System.out.println("DAS network manager");
            System.out.println("--------------------");
            System.out.println("listNetwork");
            System.out.println("networkStatus");
            System.out.println("");

            System.out.println("addCarrier");
            System.out.println("deleteCarrier");
            System.out.println("renameCarrier");
            System.out.println("listCarriers");
            System.out.println("carrierStatus");
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
            System.out.println("");
            System.out.println("createAlarm");
            System.out.println("clearAlarm");
            System.out.println("remedies");


            System.out.println("");
            System.out.print("Enter a command: ");
            choice = scan.nextLine();


            try{
            commands.get(choice).execute();
            } catch(NullPointerException e){
               System.out.println("");
               System.out.print("No such command");
               System.out.println("");
            }

        }while(!choice.equals("Exit"));

    }




    private void populateValues(){

        Carrier c1 = new Carrier("Vodafone");
        Carrier c2 = new Carrier("Three");

        Hub h1 = new Hub("Hub1", 1);
        Hub h2 = new Hub("Hub2", 2);

        Node n1 = new Node("Node1", 1);
        Node n2 = new Node("Node2", 2);


        Date date = new Date();


        Alarm alarm1 = new Alarm("Power outage", "Power outage remedy", date);
        Alarm alarm2 = new Alarm("Dark fibre", "Dark fibre remedy", date);
        Alarm alarm3 = new Alarm("Unit unavailable", "Unit unavailable remedy", date);
        Alarm alarm4 = new Alarm("Optical loss", "Optical loss remedy", date);

        h1.hubAlarms.add(alarm1);
        h1.hubAlarms.add(alarm2);

        h2.hubAlarms.add(alarm3);
        h2.hubAlarms.add(alarm4);


        Network.carrierMap.put(c1.getName(), c1);
        Network.carrierMap.put(c2.getName(), c2);


        Network.carrierMap.get(c1.getName()).hubs.put(h1.getName(), h1);
        Network.carrierMap.get(c2.getName()).hubs.put(h2.getName(), h2);


        Network.carrierMap.get(c1.getName()).hubs.get(h1.getName()).nodes.put(n1.getName(), n1);
        Network.carrierMap.get(c2.getName()).hubs.get(h2.getName()).nodes.put(n2.getName(), n2);

    }
}
