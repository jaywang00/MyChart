package com.example.demouicontrol.mychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PieChartActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart = findViewById(R.id.chart);
        init();
    }

    void init() {

//        List<PieEntry> entries = new ArrayList<>();
//
//        entries.add(new PieEntry(18.5f, "Green"));
//        entries.add(new PieEntry(26.7f, "Yellow"));
//        entries.add(new PieEntry(24.0f, "Red"));
//        entries.add(new PieEntry(30.8f, "Blue"));
//
//        PieDataSet set = new PieDataSet(entries, "Election Results");
//        PieData data = new PieData(set);
//        pieChart.setData(data);
//        pieChart.invalidate(); // refresh


        List<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(18.5f, "Green"));
            entries.add(new PieEntry(26.7f, "Yellow"));
            entries.add(new PieEntry(24.0f, "Red"));
            entries.add(new PieEntry(30.8f, "Blue"));

        PieDataSet pieDataSet = new PieDataSet(entries,"");
            pieDataSet.setColors(new int[]{Color.GREEN,Color.YELLOW,Color.RED,Color.BLUE});
            pieDataSet.setValueTextSize(15);
            pieDataSet.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return value+"%";
                }
            });

        pieDataSet.setValueTextColor(Color.BLACK);

        PieData data = new PieData(pieDataSet);
        pieChart.setData(data);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(20);
        pieChart.setHoleRadius(0);
        pieChart.getLegend().setTextSize(15);
        pieChart.getLegend().setFormSize(15);
        Description description = new Description();
        description.setText("Election Results");
        description.setTextSize(15);
        pieChart.setDescription(description);
        pieChart.setTransparentCircleRadius(0);
        pieChart.invalidate(); // refresh
    }
}

