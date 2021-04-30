package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ResultActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart;
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("users");


//        tv = (TextView)findViewById(R.id.tvres);
//        tv2 = (TextView)findViewById(R.id.tvres2);
//        tv3 = (TextView)findViewById(R.id.tvres3);
//        btnRestart = (Button) findViewById(R.id.btnRestart);
//
//        String s = " "+ Double.toString(QuestionsActivity.CS);
//
//        updateScore(s);
//
////        StringBuffer sb = new StringBuffer();
////        sb.append("CT answers: " + QuestionsActivity.CS + "\n");
////        StringBuffer sb2 = new StringBuffer();
////        sb2.append("CS Answers 1: " + QuestionsActivity.CT[0] + "\n");
////        StringBuffer sb3 = new StringBuffer();
////        sb3.append("CS Answer 2: " + QuestionsActivity.CT[1] + "\n");
//        tv.setText(sb);
//        tv2.setText(sb2);
//        tv3.setText(sb3);


        QuestionsActivity.correct=0;
        QuestionsActivity.wrong=0;


        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),ChartActivity.class);
                startActivity(in);
            }
        });
    }
    public void onBackPressed() {
        Intent intent = new Intent(ResultActivity.this, UserProfile.class);
        startActivity(intent);
    }

    public void updateScore( final String s )
    {

        databaseReference.child(UserProfile.Username).child("cScore").setValue("90");

        databaseReference.child(UserProfile.Username).child("quiz_taken").setValue("2");

        // calling add value event listener method
        // for getting the values from database.
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // this method is call to get the realtime
//                // updates in the data.
//                // this method is called when the data is
//                // changed in our Firebase console.
//                // below line is for getting the data from
//                // snapshot of our database.
//               // String value = snapshot.getValue(String.class);
//                String qt = snapshot.child(Login.user).child("quiz_taken").getValue(String.class);
//                String cs = snapshot.child(Login.user).child("cScore").getValue(String.class);
//                cs = cs + s;
//                int quizt = Integer.parseInt(qt);
//                quizt++;
//                qt = Integer.toString(quizt);
//
//                Toast.makeText(ResultActivity.this, UserProfile.Username, Toast.LENGTH_SHORT).show();
//
//
//
//                // after getting the value we are setting
//                // our value to our text view in below line.
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // calling on cancelled method when we receive
//                // any error or we are not able to get the data.
//                Toast.makeText(ResultActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}


