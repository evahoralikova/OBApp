package com.example.evaho.myob;

public class Training {

    String performedOn;
    String location;
    String length;
    String pace;
    String time;

    public Training(String performedOn, String location, String length, String pace, String time){

        this.performedOn = performedOn;
        this.location = location;
        this.length = length;
        this.time = time;
        this.pace = pace;


    }

    public String getPerformedOn() {
        return performedOn;
    }

    public void setPerformedOn(String performedOn) {
        this.performedOn = performedOn;
    }

    public String getlocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPace() {
        return pace;
    }

    public void setPase(String pace) {
        this.pace = pace;
    }




}
