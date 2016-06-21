package com.main;

import com.commands.*;

import java.util.*;

public class Main {


    static Set<Carrier> carriers = new HashSet<Carrier>();


    public static void main(String[] args){

        populateCarriers();

        Scanner scan = new Scanner(System.in);

        Map<String, Command> commands = new HashMap<String, Command>();



        Command addCarrier               = new AddCarrierCommand();
        Command listCarriers             = new ListCarrierCommand();
        Command deleteCarrier            = new DeleteCarrierCommand();
        Command ListEntireNetworkCommand = new ListEntireNetworkCommand();
        Command addHub                   = new AddHubCommand();


        commands.put("addCarrier",  addCarrier);
        commands.put("listCarriers",  listCarriers);
        commands.put("deleteCarrier",  deleteCarrier);
        commands.put("ListEntireNetwork",  ListEntireNetworkCommand);
        commands.put("addHub",  addHub);



        String s;

        do {
            System.out.println("");
            System.out.println("DAS network manager");
            System.out.println("--------------------");
            System.out.println("addCarrier");
            System.out.println("listCarriers");
            System.out.println("deleteCarrier");
            System.out.println("ListEntireNetwork");

            System.out.println("");
            System.out.println("addHub");
            System.out.println("");

            System.out.println("");
            System.out.println("Exit");
            System.out.println("");
            System.out.print("Enter a command: "); //Ask the user for a command
            s = scan.next();

            commands.get(s).execute();

        }while(!s.equals("Exit"));


    }


    //Adding a carrier
    public void addCarrier(Carrier c){
        carriers.add(c);
        //listCarriers();
    }




    //Displaying the list of carriers
    public void listCarriers() {
        for (Carrier c : carriers) {
            System.out.println(c.getName());
        }
    }




    //Deleting the specified carrier
    public void deleteCarrier(String name){

        for (Iterator<Carrier> i = carriers.iterator(); i.hasNext();) {
            Carrier c = i.next();
            if (c.getName().equals(name)) {
                i.remove();
            }
        }
        System.out.print(carriers.size());

    }



    //Pre-populating the carrier list
    public static void populateCarriers() {

        Carrier c1 = new Carrier("Three");
        Carrier c2 = new Carrier("Vodafone");
        Carrier c3 = new Carrier("Meteor");
        Carrier c4 = new Carrier("Tesco");

        carriers.add(c1);
        carriers.add(c2);
        carriers.add(c3);
        carriers.add(c4);

        System.out.print(carriers.size());
    }




}
