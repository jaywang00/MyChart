package com.example.demouicontrol.mychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //##### Add here
    LineChart chart ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //##### Add here
        chart = (LineChart) findViewById(R.id.chart);
        init();
    }

    //##### Add here
    void init(){
//        YourData[] dataObjects = ...;

        List<Entry> entries = new ArrayList<Entry>();

//        for (YourData data : dataObjects) {
//
//            // turn your data into Entry objects
//            entries.add(new Entry(data.getValueX(), data.getValueY()));
//        }
        entries.add(new Entry(1,30));
        entries.add(new Entry(3,45));
        entries.add(new Entry(5,40));
        entries.add(new Entry(7,20));
        entries.add(new Entry(9,70));
        entries.add(new Entry(11,40));

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.RED); // styling, ...

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
