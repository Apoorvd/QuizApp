package com.example.vikasojha.quizbee;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class piedemo extends AppCompatActivity {

    PieChart piechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piedemo);

        piechart=(PieChart)findViewById(R.id.piechart);
        piechart.setEntryLabelTextSize(7f);

        String str[]=Login.cs.split(" ");
        double newcs= Double.parseDouble(str[str.length-1]);


        ArrayList<PieEntry> records=new ArrayList<>();
        records.add(new PieEntry((float) newcs, "CREATIVITY SCORE (in %)"));
        records.add(new PieEntry(100-(float) newcs, ""));
//        records.add(new PieEntry(QuestionsActivity.CT[1],"FLEXIBILITY"));
//        records.add(new PieEntry(QuestionsActivity.CT[2],"ORIGINALITY"));
//        records.add(new PieEntry(QuestionsActivity.CT[3],"ELABORATION"));
//        records.add(new PieEntry(QuestionsActivity.CT[4],"TOLERANCE OF AMBIGUITY"));
//        records.add(new PieEntry(QuestionsActivity.CT[5],"BREADTH OF INTEREST"));
//        records.add(new PieEntry(QuestionsActivity.CT[6],"SENSITIVITY"));
//        records.add(new PieEntry(QuestionsActivity.CT[7],"CURIOSITY"));
//        records.add(new PieEntry(QuestionsActivity.CT[8],"REFLECTION"));
//        records.add(new PieEntry(QuestionsActivity.CT[9],"ACTION"));
//        records.add(new PieEntry(QuestionsActivity.CT[10],"CONSIDERATION & PERSISTENCE"));
//        records.add(new PieEntry(QuestionsActivity.CT[11],"EXPRESSION OF TOTAL PERSONALITY"));
//        records.add(new PieEntry(QuestionsActivity.CT[12],"SENSE OF HUMOUR"));



        PieDataSet dataSet=new PieDataSet(records,"Percentage left out of 100");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(20f);

        PieData pieData=new PieData(dataSet);

        piechart.setData(pieData);
        piechart.getDescription().setEnabled(true);
        piechart.setCenterText("CREATIVITY SCORE");
        piechart.animate();
    }
}