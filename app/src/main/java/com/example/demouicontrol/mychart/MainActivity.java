package com.example.demouicontrol.mychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

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

        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(getData("三月_每日支出", Color.GREEN));
            dataSets.add(getData("四月_每日支出", Color.BLUE));

        LineData lineData = new LineData(dataSets);
            chart.setData(lineData);

        XAxis xAxis = chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setTextSize(15);
            xAxis.setTextColor(Color.BLACK);
//          xAxis.setLabelCount(4);
            xAxis.setGranularity(1);

        YAxis leftAxis = chart.getAxisLeft();
            leftAxis.setTextSize(15);
            leftAxis.setTextColor(Color.BLACK);

        YAxis rightAxis = chart.getAxisRight();
            rightAxis.setEnabled(false);

        chart.setVisibleXRangeMaximum(5);

        chart.invalidate(); // refresh

    }

    LineDataSet getData(String label, int color){
        List<Entry> entries = new ArrayList<Entry>();

        Random r = new Random();
        for(int i=1; i<=30; i++){
            entries.add(new Entry(i,r.nextInt(5000)));
        }

        LineDataSet dataSet = new LineDataSet(entries, label); // add entries to dataset
            dataSet.setColor(color);
            dataSet.setValueTextColor(Color.RED); // styling, ...
            dataSet.setValueTextSize(12);
            dataSet.setLineWidth(3);
            dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            dataSet.setCircleRadius(5);
            dataSet.setCircleColor(Color.RED);

            return dataSet;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"ZoomIn").setIcon(R.drawable.zoomin).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0,1,0,"ZoomOut").setIcon(R.drawable.zoomout).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                chart.zoomIn();
                break;
            case 1:
                chart.zoomOut();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
