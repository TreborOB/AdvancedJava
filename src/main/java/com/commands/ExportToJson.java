package com.commands;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.main.Network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToJson implements Command {


    public void execute() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String network = gson.toJson(Network.carrierMap);
        exportToFile(network);

    }

    private void exportToFile(String network) {
        try {

            File file = new File("/Users/robertobrien/Desktop/Network.json");
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("");
            System.out.println("Writing network to file");

            fileWriter.write(network);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
