package com.main
import groovy.transform.EqualsAndHashCode;


/**
 * Created by robertobrien on 14/09/2016.
 */

@EqualsAndHashCode
class Hub {

    String name;
    String id;

    def hubAlarms = []
    def nodes = [:]

    Hub(String name, String id) {
        this.name = name;
        this.id = id;
    }

}

