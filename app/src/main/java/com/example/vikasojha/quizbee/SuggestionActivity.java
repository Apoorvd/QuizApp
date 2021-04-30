package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import static com.example.vikasojha.quizbee.QuestionsActivity.CT;

public class SuggestionActivity extends AppCompatActivity {
    TextView tv;

    float newct[];
    double newcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        tv = (TextView)findViewById(R.id.text_view);

        int i;
        String str[]= Login.ct.split("_");
        String newstr[] = str[str.length-1].split(" ");
        newct = new float[newstr.length];
        for (i = 0; i < newstr.length; i++)
            newct[i]=Float.parseFloat(newstr[i]);

        str=Login.cs.split(" ");
        newcs= Double.parseDouble(str[str.length-1]);


        loadText();
    }

    private void loadText() {
        String s = "";

        for(int i=0 ; i < 13; i++)
        {
            s = s + "\nCT Score in " + QuestionsActivity.traits[i] + ": " + String.valueOf(newct[i]*100/7) + "% \n";
            if(newct[i] < 5.5)
                s= s + "We suggest u to " + QuestionsActivity.suggest[i] + "\n";
            else
                s= s + "Continue the current practice. You have good " + QuestionsActivity.traits[i] + " trait." + "\n";
        }
        s = s + "\n \n \n WE CONCLUDED THAT";
        if(newcs < 71.5)
            s = s + "You have low level of creativity. Follow our above solutions" + "\n";
        else if(newcs== 71.5)
            s = s + "You have moderate level of creativity. Continue the current practice" + "\n";
        else
            s = s + "You have high level of creativity. Continue the current practice" + "\n";

        tv.setMovementMethod(new ScrollingMovementMethod());
        tv.setText(s);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(SuggestionActivity.this, UserProfile.class);
//        startActivity(intent);
//    }

}
