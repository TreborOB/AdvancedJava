package com.main

import groovy.transform.EqualsAndHashCode;


/**
 * Created by robertobrien on 14/09/2016.
 */

@EqualsAndHashCode(includeFields = true)
class Hub {

    String name;
    String id;

    def hubAlarms = []  //Alarms associated with a hub
    def nodes = [:]     //A map containing the hubs associated nodes

    Hub(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

