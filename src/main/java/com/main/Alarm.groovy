package com.main

import groovy.transform.EqualsAndHashCode


/**
 * Created by robertobrien on 14/09/2016.
 */


@EqualsAndHashCode(includeFields=true)
class Alarm {

    String alarmType
    String alarmRemedy
    Date alarmReceivedDate


    Alarm(alarmType, alarmRemedy, alarmReceivedDate) {
        this.alarmType = alarmType
        this.alarmRemedy = alarmRemedy
        this.alarmReceivedDate = alarmReceivedDate
    }
}
