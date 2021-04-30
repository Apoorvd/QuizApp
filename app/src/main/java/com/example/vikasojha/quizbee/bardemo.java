package com.example.vikasojha.quizbee;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class bardemo extends AppCompatActivity {

    BarChart barChart;
    float newct[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bardemo);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        int i;
        String str[]= Login.ct.split("_");
        String newstr[] = str[str.length-1].split(" ");
        newct = new float[newstr.length];
        for (i = 0; i < newstr.length; i++)
            newct[i]=Float.parseFloat(newstr[i]);



        barChart=(BarChart)findViewById(R.id.chart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f, newct[0]));
        barEntries.add(new BarEntry(1f, newct[1]));
        barEntries.add(new BarEntry(2f, newct[2]));
        barEntries.add(new BarEntry(3f, newct[3]));
        barEntries.add(new BarEntry(4f, newct[4]));
        barEntries.add(new BarEntry(5f, newct[5]));
        barEntries.add(new BarEntry(6f, newct[6]));
        barEntries.add(new BarEntry(7f, newct[7]));
        barEntries.add(new BarEntry(8f, newct[8]));
        barEntries.add(new BarEntry(9f, newct[9]));
        barEntries.add(new BarEntry(10f, newct[10]));
        barEntries.add(new BarEntry(11f, newct[11]));
        barEntries.add(new BarEntry(12f, newct[12]));


        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");
        ArrayList<String> theDates = new ArrayList<>();
//        theDates.add("Fluency");
//        theDates.add("Flexibility");
//        theDates.add("Originality");
//        theDates.add("Elaboration");
//        theDates.add("Tolerance of Ambiguity");
//        theDates.add("Breadth of Interest");
//        theDates.add("Sensitivity");
//        theDates.add("Curiosity");
//        theDates.add("Reflection");
//        theDates.add("Action");
//        theDates.add("Concentration & Persistence");
//        theDates.add("Sensitivity");
//        theDates.add("Expression of total personality");
//        theDates.add("Sense of Humour");
        theDates.add("CT-1");
        theDates.add("CT-2");
        theDates.add("CT-3");
        theDates.add("CT-4");
        theDates.add("CT-5");
        theDates.add("CT-6");
        theDates.add("CT-7");
        theDates.add("CT-8");
        theDates.add("CT-9");
        theDates.add("CT-10");
        theDates.add("CT-11");
        theDates.add("CT-12");
        theDates.add("CT-13");
        theDates.add("CT-14");
        float minXRange = 1;
        float maxXRange = 14;
        barChart.setVisibleXRange(minXRange, maxXRange);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(theDates));
//        barChart.getXAxis().setLabelCount(1, /*force: */true);
//        barChart.getXAxis().setAxisMinimum(1);
//        barChart.getXAxis().setAxisMaximum(14);
        BarData theData = new BarData(barDataSet);//----Line of error
        barChart.setData(theData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

//       // X-Axis entries
//        ArrayList<String> traitt= new ArrayList<>();
//        traitt.add("Fluency");
//        traitt.add("Flexibility");
//        traitt.add("Originality");
//        traitt.add("Elaboration");
//        traitt.add("Tolerance of Ambiguity");
//        traitt.add("Breadth of Interest");
//        traitt.add("Sensitivity");
//        traitt.add("Curiosity");
//        traitt.add("Reflection");
//        traitt.add("Action");
//        traitt.add("Concentration & Persistence");
//        traitt.add( "Expression of total personality");
//        traitt.add("Sense of Humour");
//
//
//
//        //Y-Axis entries
//        ArrayList<BarEntry> barEntries = new ArrayList<>();
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[0])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[1])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[2])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[3])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[4])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[5])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[6])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[7])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[8])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[9])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[10])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[11])));
//        barEntries.add(new BarEntry(44f, (float)(QuestionsActivity.CT[12])));
//
////        ArrayList<BarEntry> barEntries = new ArrayList<>();
////        barEntries.add(QuestionsActivity.CT[0]);
//
//
//        BarDataSet barDataSet=new BarDataSet(barEntries,"Report");
//        bar.getXAxis().setValueFormatter(new IndexAxisValueFormatter(traitt));
//
////        BarDataSet bdata = new BarDataSet(traitt, "Exam");
////        BarData theData = new BarData(QuestionsActivity.traits, barDataSet);
//       // bar.setData(theData);
//        BarData theData = new BarData(barDataSet);//----Line of error
//        bar.setData(theData);
////        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
////        barDataSet.setValueTextColor(Color.BLACK);
////        barDataSet.setValueTextSize(20f);
//
//        bar.setTouchEnabled(true);
//        bar.setDragEnabled(true);
//        bar.setScaleEnabled(true);
////        bar.getDescription().setText("Bar Report Demo");
////        bar.animateY(2000);
    }
}