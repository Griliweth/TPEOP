package com.example.jay.weektime2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeekTime extends AppCompatActivity {
    int chec;
    ArrayList<Period> PeriodList;
    TextView t;
    String line;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_time);
        line =" ";
        PeriodList = new ArrayList<Period>();
        readPeriodData();

    }
    public void readPeriodData(){

        InputStream PeriodData = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(PeriodData, Charset.forName("UTF-8")));

    try{
        reader.readLine();
        while ((line = reader.readLine())!= null){
            String[] tokens = line.split(",");
            WTime  WTstart = new WTime(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),0);
            Period list = new Period(WTstart, Integer.parseInt(tokens[4]),(tokens[5]));
            PeriodList.add(list);
        }
    } catch (IOException e) {
        Log.wtf("MyActivity", "Error reading data file on line " + line, e);
        e.printStackTrace();

    }}
    public WTime checkPeriod(WTime n){
         chec = 0;
        WTime sta = new WTime();
        if(PeriodList.get(chec).start.ticks < n.ticks + 60*10*5 && n.ticks+60*10*5< PeriodList.get(chec+1).start.ticks){
            sta = PeriodList.get(chec).start;
        }
        else{
            chec+=1;
        }
        return sta;
    }

    public void checkGas(View a){
        if(a.getId()== R.id.checker) {
            TextView t = (TextView) findViewById(R.id.Tex);
            WTime now = new WTime();
            WTime result = new WTime(checkPeriod(now).diffTicks(now));
            t.setText(result.toStrin());
        }
    }

}
