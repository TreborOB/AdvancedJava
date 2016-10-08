package com.commands


import com.main.Network
import groovy.json.JsonOutput


/**
 * Created by robertobrien on 14/09/2016.
 */
class ExportToJson implements Command {


    /**
     * Exports the network to a new file in json format (change the path to that of your local machine)
     *
     */
    def execute() {
        def json = JsonOutput.toJson(Network.carrierMap)
        def file = new File('/Users/robertobrien/Desktop/Network.json')
        file.write json
        println 'Writing network to: ' + file.toString()
    }


}
