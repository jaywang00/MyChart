package com.example.demouicontrol.mychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    LineChart chart ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = (LineChart) findViewById(R.id.chart);
        init();
    }

    void init(){

        List<Entry> entries = new ArrayList<Entry>();

        Random r = new Random();
        for(int i=1; i<=365; i++){
            entries.add(new Entry(i,r.nextInt(500)));
        }

        LineDataSet dataSet = new LineDataSet(entries, "每日花費"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextSize(10f);
        dataSet.setValueTextColor(Color.RED); // styling, ...


        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15);
        xAxis.setTextColor(Color.BLACK);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTextSize(15);
        leftAxis.setTextColor(Color.RED);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
        chart.setVisibleXRangeMaximum(30);

        chart.invalidate(); // refresh

    }
}
