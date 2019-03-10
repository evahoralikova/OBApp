package com.example.evaho.myob;

public class Training {

    String performedOn;
    String location;

    public Training(String performedOn, String location){

        this.performedOn = performedOn;
        this.location = location;
    }

    public String getPerformedOn() {
        return performedOn;
    }

    public void setPerformedOn(String performedOn) {
        this.performedOn = performedOn;
    }

    public String getMlocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }




}
