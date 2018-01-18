package com.example.jay.weektime2;

import java.util.Calendar;

/**
 * Created by Jay on 1/12/18.
 */

public class WTime {
    int ticks;
    public WTime(int day, int hours, int minutes, int seconds) {
        ticks = day * 24 * 60 * 60 * 10 + hours * 60 * 60 * 10 + minutes * 60 * 10 + seconds * 10;
        if(minutes >= 60){
            day = day + minutes/60;
            minutes = minutes%60;
        }
    }
    public WTime(int tick){
ticks = tick;
    }
    public WTime() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int seconds = c.get(Calendar.SECOND);
        ticks = day * 24 * 60 * 60 * 10 + hour * 60 * 60 * 10 + min * 60 * 10 + seconds * 10;
    }
    public String toStrin() {

        String s = "hours = " + getHours() + "," + "minutes = " + getMinutes() + "," + "seconds = " + getSeconds() + ".";
        return s;
    }
    public int getDay() {

        int day = ticks / (24 * 60 * 60 * 10);
        return day;
    }

    public int getHours() {

        int hours = (ticks % (24 * 60 * 60 * 10)) / (60 * 60 * 10);
        return hours;
    }

    public int getMinutes() {
        int minutes = ((ticks % (24 * 60 * 60 * 10)) % (60 * 60 * 10)) / (60 * 10);
        return minutes;
    }

    public int getSeconds() {
        int seconds = (((ticks % (24 * 60 * 60 * 10)) % (60 * 60 * 10)) % (60 * 10)) / 10;
        return seconds;
    }
    public int diffTicks(WTime current){
        int diff = this.ticks-current.ticks;
        return diff;
    }

}
