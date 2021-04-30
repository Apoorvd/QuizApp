package com.example.vikasojha.quizbee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SeeScore extends AppCompatActivity {

    TextView fullNameLabel, userNameLabel;

//    static String Username;

    TextView quiz_taken, cScore , dispScore;
    //FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    //DatabaseReference databaseReference;

    Button see_suggestions;

    String   oldScore="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_score);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //firebaseDatabase = FirebaseDatabase.getInstance();

        //QuestionsActivity.CT =new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        // below line is used to get
        // reference for our database.
        //databaseReference = firebaseDatabase.getReference("users");

        fullNameLabel = findViewById(R.id.full_name);
        userNameLabel = findViewById(R.id.username_label);
        quiz_taken = findViewById(R.id.numberofquiz);
        cScore = findViewById(R.id.score);
        dispScore= findViewById(R.id.cScore);
        see_suggestions = findViewById(R.id.curr_sug);
        this.recieveData();

        see_suggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SuggestionActivity.class));
            }
        });

//        fullNameLabel.setText(Login.user);
//
//        quiz_taken.setText(quizTaken);
//        cScore.setText(gcScore(currentScore));
//        goScore(currentScore);
//        dispScore.setText(oldScore);

    }



    private void goScore(String s) {
        String str[]=s.split(" ");

        for (int i= 1 ; i < str.length ; i++)
        {
            oldScore = oldScore + str[i] + "  \n";
        }

    }

    public String gcScore(String s){

        String str[]=s.split(" ");
        return str[str.length-1];
    }

    public void recieveData( ) {


        // calling add value event listener method
        // for getting the values from database.
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // this method is call to get the realtime
//                // updates in the data.
//                // this method is called when the data is
//                // changed in our Firebase console.
//                // below line is for getting the data from
//                // snapshot of our database.
//                // String value = snapshot.getValue(String.class);
//                //String phoneNoformDB = snapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
//                //String emailformDB = snapshot.child(userEnteredUsername).child("email").getValue(String.class);
//                quizTaken = snapshot.child(Login.usernameformDB).child("quiz_taken").getValue(String.class);
//                currentScore = snapshot.child(Login.usernameformDB).child("cScore").getValue(String.class);

//
//                Toast.makeText(ResultActivity.this, UserProfile.Username, Toast.LENGTH_SHORT).show();
//
//
//
//                // after getting the value we are setting
//                // our value to our text view in below line.

                userNameLabel.setText(Login.usernameformDB);

        fullNameLabel.setText(Login.nameformDB);

        quiz_taken.setText(Login.qt);
        cScore.setText(gcScore(Login.cs));
        if ( Login.qt.equals("0"))
        {
            dispScore.setText("Quiz not given. Suggestion activity will show wrong result. Atleast give a quiz");
        }

        else{
            goScore(Login.cs);
            dispScore.setText(oldScore);
        }



//            }
//            //
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // calling on cancelled method when we receive
//                // any error or we are not able to get the data.
//
//                Toast.makeText(SeeScore.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        finishAffinity();
        Intent myIntent = new Intent(SeeScore.this, UserProfile.class);

//            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(myIntent);
    }
}