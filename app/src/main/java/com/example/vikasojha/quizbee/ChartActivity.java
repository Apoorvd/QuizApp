package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;

public class ChartActivity extends AppCompatActivity {

    Button btnsuggestions,btnpie,btnbar;
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnpie=(Button)findViewById(R.id.btnpie);
        firebaseDatabase = FirebaseDatabase.getInstance();

        //QuestionsActivity.CT =new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("users");

//        DecimalFormat df = new DecimalFormat("###.##");
//        String s = " "+ df.format(QuestionsActivity.dupCS);
        updateScore();

        btnpie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),piedemo.class));
            }
        });

        btnbar=(Button)findViewById(R.id.btnbar);

        btnbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),bardemo.class));
            }
        });

        btnsuggestions=(Button)findViewById(R.id.btnsuggestions);

        btnsuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SuggestionActivity.class));
            }
        });



    }
    public void updateScore( ) {


        // calling add value event listener method
        // for getting the values from database.
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
               // String value = snapshot.getValue(String.class);
//                String qt = snapshot.child(Login.user).child("quiz_taken").getValue(String.class);
//                String cs = snapshot.child(Login.user).child("cScore").getValue(String.class);
//                Login.cs = Login.cs + s;
                int quizt = Integer.parseInt(Login.qt);
                quizt++;
                Login.qt = Integer.toString(quizt);
                databaseReference.child(Login.usernameformDB).child("cScore").setValue(Login.cs);

                databaseReference.child(Login.usernameformDB).child("quiz_taken").setValue(Login.qt);

                databaseReference.child(Login.usernameformDB).child("cTscore").setValue(Login.ct);

//
//                Toast.makeText(ResultActivity.this, UserProfile.Username, Toast.LENGTH_SHORT).show();
//
//
//
//                // after getting the value we are setting
//                // our value to our text view in below line.

//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // calling on cancelled method when we receive
//                // any error or we are not able to get the data.
//
//                Toast.makeText(ChartActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
            Intent myIntent = new Intent(ChartActivity.this, UserProfile.class);

//            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myIntent);
        }
        // toolbar.setTitle("Dashboard");
    }

