package com.example.vikasojha.quizbee;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class linedemo extends AppCompatActivity {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linedemo);

        lineChart=(LineChart)findViewById(R.id.linechart);

        ArrayList<Entry> information=new ArrayList<>();
        information.add(new Entry(10,80));
        information.add(new Entry(50,90));
        information.add(new Entry(100,110));
        information.add(new Entry(150,80));
        information.add(new Entry(500,130));

        LineDataSet lineDataSet=new LineDataSet(information,"Information");
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(20f);

        LineData lineData=new LineData(lineDataSet);



        lineChart.setData(lineData);
        lineChart.animateY(2000);
    }
}