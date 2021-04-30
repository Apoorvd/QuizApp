package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    public double CS = 0.0 ;
    int i;

    String questions[] = {
            "1. I am able to think about different solution for a particular problem",
            "2. I shall come with different solution for a problem assigned to me",
            "3. I resolve problems with solutions thought from different perspectives",
            "4. I am able to come up with ideas which are different",
            "5. I am able to come up with ideas which are not related to traditional solutions",
            "6. I can visualize the unusual uses of a product / system",
            "7. I do divergent thinking to provide solution for a problem",
            "8. I am generally going beyond commonly accepted ideas to unusual forms for a design solution",
            "9. I am generally going beyond commonly accepted approaches for a design solution",
            "10. I usually go for more number of details to extend a design solution",
            "11. I don't provide a design solution superficially or casually",
            "12. I am able to hold conflicting ideas and values",
            "13. I am able to take the action of making one view or belief compatible with another",
            "14. I generally take interest on multidisciplinary knowledge gaining and its application for problem solving",
            "15. I believe in implications of interdisciplinary/ multidisciplinary knowledge rather than for small details and facts for the sake of facts",
            "16. I am  able to identify needs in life and fill these needs",
            "17. I sense problems / deficiencies in life and find solutions",
            "18. I consider thoughts and feelings of others when solving problems",
            "19. I am very open for new ideas and experiences",
            "20. I have the capacity to be puzzled",
            "21. I am actively experimenting with ideas and the pleasure in seeking and discovering ideas",
            "22. I consider and reconsider ideas for solutions of a problem",
            "23. I evaluate my ideas as well as the ideas of others before proposing best solution to a problem",
            "24. I take time to achieve understanding and insights",
            "25. I usually look ahead and plan for a solution to provided problem",
            "26. I take an overview of  the selected solution (s) and think about different consequences (e.g. business, plicy level, political etc.)",
            "27. I have ability to put ideas in action with high energy level",
            "28. I am able to implement the planned solution to a problem with great enthusiasm",
            "29. I am able to work hard as long as I provide high quality design solution",
            "30. I am able to work consistently and persistently with extraordinary concentration to provide solutions to a problem",
            "31. I am imaginative and have ability to come with unique thoughts",
            "32. I am able to think logically during problem solving",
            "33. I take independent decision based on self-reliance during problem solving",
            "34. I have ability to see and express the humour in the contradictions and ambiguities of life",
            "35. I maintain a balance without losing commitment during design solution"
    };

   static String traits[] = {"Fluency", "Flexibility", "Originality", "Elaboration", "Tolerance of Ambiguity", "Breadth of Interest", "Sensitivity", "Curiosity", "Reflection", "Action", "Concentration & Persistence",
                        "Expression of total personality", "Sense of Humour"};
    static String suggest[] = new String[]{"Think from different perspective", "Apply principle of Creativity and Innovation Such as Inspiration", "Judge uniqueness of ideas for problem solving / welcome bold ideas", "Detail out your ideas from technology and business point of view", "Take stand to establish your thought and check the feasibility of implementation of your idea",
            "Apply amalgamated knowledge from different allied disciplines", "Improve observational skills and be empathetic", "Try out different approaches to solve the problem and do experiemnt", "Always evaluate ideas before giving solution and provide optimized design solution/Is there any USP of your idea?/ What the the MVP?/ be sensitive towards business innovation or environment or socio-political issues etc.",
            "Gain implementation skill and knowledge/ ask for help from field expert when your expertise is limited", "Be healthy and well motivated / always try for the best at your time", "Be imaginative as well as logical", "Develop sense of humour / don't loose your comitment"};

    public  byte[] pos = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 10, 10, 11, 11, 11, 12, 12};
    public  int ans[] = new int[pos.length];
    public  float CT[] = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    /*String fluency[] = {
            "1. I am able to think about different solution for a particular problem",
            "2. I shall come with different solution for a problem assigned to me",
            "3. I resolve problems with solutions thought from different perspectives"
    };

    String flexibility[] = {
            "4. I am able to come up with ideas which are different",
            "5. I am able to come up with ideas which are not related to traditional solutions",
            "6. I can visualize the unusual uses of a product / system"
    };

    String originality[] = {
            "7. I do divergent thinking to provide solution for a problem",
            "8. I am generally going beyond commonly accepted ideas to unusual forms for a design solution",
            "9. I am generally going beyond commonly accepted approaches for a design solution"
    };

    String elaboration[] = {
            "10. I usually go for more number of details to extend a design solution",
            "11. I don't provide a design solution superficially or casually"
    };

    String tolerance_of_ambiguity[] = {
            "12. I am able to hold conflicting ideas and values",
            "13. I am able to take the action of making one view or belief compatible with another"
    };

    String breadth_of_interest[] = {
            "14. I generally take interest on multidisciplinary knowledge gaining and its application for problem solving",
            "15. I believe in implications of interdisciplinary/ multidisciplinary knowledge rather than for small details and facts for the sake of facts"
    };

    String sensitivity[] = {
            "16. I am  able to identify needs in life and fill these needs",
            "17. I sense problems / deficiencies in life and find solutions",
            "18. I consider thoughts and feelings of others when solving problems"
    };

    String curiosity[] = {
            "19. I am very open for new ideas and experiences",
            "20. I have the capacity to be puzzled",
            "21. I am actively experimenting with ideas and the pleasure in seeking and discovering ideas"
    };

    String reflection[] = {
            "22. I consider and reconsider ideas for solutions of a problem",
            "23. I evaluate my ideas as well as the ideas of others before proposing best solution to a problem",
            "24. I take time to achieve understanding and insights",
            "25. I usually look ahead and plan for a solution to provided problem",
            "26. I take an overview of  the selected solution (s) and think about different consequences (e.g. business, plicy level, political etc.)"
    };

    String action[] = {
            "27. I have ability to put ideas in action with high energy level",
            "28. I am able to implement the planned solution to a problem with great enthusiasm"
    };

    String concentration_and_persistence[] = {
            "29. I am able to work hard as long as I provide high quality design solution",
            "30. I am able to work consistently and persistently with extraordinary concentration to provide solutions to a problem"
    };

    String expression_of_tp[] = {
            "31. I am imaginative and have ability to come with unique thoughts",
            "32. I am able to think logically during problem solving",
            "33. I take independent decision based on self-reliance during problem solving"
    };

    String sense_of_humour[] = {
            "34. I have ability to see and express the humour in the contradictions and ambiguities of life",
            "35. I maintain a balance without losing commitment during design solution"
    };*/


    String opt[] = {
            "1 -> Strongly Disagree", "2", "3", "4 -> Agree", "5", "6", "7 -> Strongly Agree"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;
    public static int j = 0, c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

//        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("myname");


            textView.setText("Rate yourself from on the scale of 1-7 in the following questions");

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb5 = (RadioButton) findViewById(R.id.radioButton5);
        rb6 = (RadioButton) findViewById(R.id.radioButton6);
        rb7 = (RadioButton) findViewById(R.id.radioButton7);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        rb5.setText(opt[4]);
        rb6.setText(opt[5]);
        rb7.setText(opt[6]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                String sup[]=ansText.split(" ");
                int m = Integer.parseInt(sup[0]);
                ans[flag++]=m;
//                CT[pos[flag]]= CT[pos[flag]] + answers[flag];
//                c++;
//                if(pos[flag] != j)
//                {
//                    j++;
//                    CT[flag-1]= CT[flag-1]/(c*1.0f);
//                    CS= CS + CT[flag-1];
//                    c=0;
//                }
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
//                if(ansText.equals(answers[flag])) {
//                    correct++;
//                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    wrong++;
//                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
//                }

//                flag++;
//
//                if (score != null)
//                score.setText(""+m);

                if (flag <  questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[0]);
                    rb2.setText(opt[1]);
                    rb3.setText(opt[2]);
                    rb4.setText(opt[3]);
                    rb5.setText(opt[4]);
                    rb6.setText(opt[5]);
                    rb7.setText(opt[6]);
                } else {
                    for (i = 0; i < pos.length; i++) {
                        if (pos[i] == j) {
                            CT[j] = CT[j] + ans[i];
                            c++;
                        } else {
                            CT[j] = (CT[j++]*1.0f)/ (c * 1.0f);
                            c = 0;
                            i--;
                        }
                    }
                    CT[j]=CT[j]/((c)*1.0f);
                    for (i = 0; i < 13; i++) {
                        DecimalFormat df = new DecimalFormat("###.##");
                         Login.ct = Login.ct + df.format(CT[i]) + " ";
                        CS = CT[i] + CS;
                    }
                    Login.ct = Login.ct + "_";
                    DecimalFormat df = new DecimalFormat("###.##");
                    String st = " "+ df.format(CS);
                    Login.cs = Login.cs + " " + st;
                    i= 0; j =0; CS = 0;
                    Intent into = new Intent(getApplicationContext(), ChartActivity.class);
                    startActivity(into);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intent);
            }
        });
    }
}