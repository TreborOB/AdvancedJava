package com.main;


import java.util.Date;

public class Alarm {



    private String alarmType;
    private String alarmRemedy;
    private Date alarmReceivedDate;


    public Alarm(){


    }


    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmRemedy() {
        return alarmRemedy;
    }

    public void setAlarmRemedy(String alarmRemedy) {
        this.alarmRemedy = alarmRemedy;
    }

    public Date getAlarmReceivedDate() {
        return alarmReceivedDate;
    }

    public void setAlarmReceivedDate(Date alarmReceivedDate) {
        this.alarmReceivedDate = alarmReceivedDate;
    }
}
