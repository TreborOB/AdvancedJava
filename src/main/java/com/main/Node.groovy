package com.main

import groovy.transform.EqualsAndHashCode;


/**
 * Created by robertobrien on 14/09/2016.
 */

@EqualsAndHashCode(includeFields = true)
class Node {

    String name;
    String id;

    def nodeAlarms = [] //Alarms associated with a node

    Node(name, id) {
        this.name = name;
        this.id = id;
    }

}
