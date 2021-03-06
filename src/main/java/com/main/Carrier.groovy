package com.main

import groovy.transform.EqualsAndHashCode

/**
 * Created by robertobrien on 14/09/2016.
 */

@EqualsAndHashCode(includeFields = true)
class Carrier{

    String name
    def hubs = [:] //A map contained the carriers associated hubs

    Carrier() {
    }

    Carrier(name) {
        this.name = name
    }

}

