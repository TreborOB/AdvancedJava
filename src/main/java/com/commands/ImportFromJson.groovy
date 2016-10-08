package com.commands

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.main.Carrier
import com.main.Network

import java.lang.reflect.Type


/**
 * Created by robertobrien on 14/09/2016.
 */
class ImportFromJson implements Command {


    /**
     * Reads in a network from the path location in json format
     *
     */
    def execute() {

        try{
            JsonReader reader = new JsonReader(new FileReader('/Users/robertobrien/Desktop/Network.json'))
            Gson gson = new Gson()

            Type type = new TypeToken<Map<String, Carrier>>() {}.getType()
            Network.carrierMap = gson.fromJson(reader, type)

            println ''
            println 'Network Imported'

        } catch (FileNotFoundException fnf) {
            println "File not found: + $fnf"
        }

    }
}
