package com.commands;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.main.Carrier;
import com.main.Network;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;


public class ImportFromJson implements Command {

    public void execute() {

        try {
            JsonReader reader = new JsonReader(new FileReader("/Users/robertobrien/Desktop/Network.json"));
            Gson gson = new Gson();

            Type type = new TypeToken<Map<String, Carrier>>() {
            }.getType();
            Network.carrierMap = gson.fromJson(reader, type);

            System.out.println("");
            System.out.println("Network Imported");

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }


    }
}
