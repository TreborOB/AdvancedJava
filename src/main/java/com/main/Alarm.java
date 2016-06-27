package com.main;


import java.util.Date;

public class Alarm {

    private String alarmType;
    private String alarmRemedy;
    private Date alarmReceivedDate;


    public Alarm()
    {

    }


    public Alarm(String alarmType, String alarmRemedy, Date alarmReceivedDate){
        this.alarmType = alarmType;
        this.alarmRemedy = alarmRemedy;
        this.alarmReceivedDate = alarmReceivedDate;
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
