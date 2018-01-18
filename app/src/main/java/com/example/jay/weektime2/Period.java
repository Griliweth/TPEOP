package com.example.jay.weektime2;

/**
 * Created by Jay on 1/12/18.
 */

public class Period {
    WTime start;
    WTime end;
    String periodNumber;
    int periodLength;
    public Period(WTime start, int periodLength, String periodNumber){
        this.start = start;
        this.end = new WTime(start.getDay(),start.getHours(),start.getMinutes()+periodLength,start.getSeconds());
        this.periodNumber = periodNumber;
        this.periodLength = periodLength;
    }
   /* public Period(){
        WTime start;
        WTime end;
        int periodNumber;
        int periodLength;
    }*/
    public void setStart(WTime a){
        start = a;
    }
   // public void setEnd(int a){ end =
   // }
    public void setPeriodNumber(String g){
        periodNumber = g;
    }
    public void setPeriodLength(int a){
        periodLength = a;
    }
}
