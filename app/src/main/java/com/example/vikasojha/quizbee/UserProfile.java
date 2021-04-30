package com.example.vikasojha.quizbee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfile extends AppCompatActivity {

    //    TextInputLayout fullName,email,phoneNo,password;
    Button take_quiz, see_score;
    TextView fullNameLabel, userNameLabel;

    static String Username;

    TextView quiz_taken, cScore;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");
        take_quiz = findViewById(R.id.take_quiz);
        see_score = findViewById(R.id.see_scores);

        //Hooks
//        fullName = findViewById(R.id.full_name_profile);
//        email = findViewById(R.id.email_profile);
//        phoneNo = findViewById(R.id.phone_no_profile);
//        password = findViewById(R.id.password_profile);
        fullNameLabel = findViewById(R.id.full_name);
        userNameLabel = findViewById(R.id.username_label);
        quiz_taken = findViewById(R.id.numberofquiz);
        cScore = findViewById(R.id.score);

        //ShowAllData
        showAllUserData();

        take_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });

        see_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, SeeScore.class);
                startActivity(intent);
            }
        });
    }

    public String gcScore(String s) {

        String str[] = s.split(" ");
        return str[str.length - 1];
    }

    private void showAllUserData() {

//        Intent intent = getIntent();
//        String user_username= intent.getStringExtra("username");
//        String user_name= intent.getStringExtra("name");
//        String user_email= intent.getStringExtra("email");
//        String user_phoneNo= intent.getStringExtra("phoneNo");
//        String user_password= intent.getStringExtra("password");
//        String qt = intent.getStringExtra("quiz_taken");
//        String cs = gcScore(intent.getStringExtra("cScore"));

        Username = Login.usernameformDB;

        String score = gcScore(Login.cs);

        fullNameLabel.setText(Login.nameformDB);
        userNameLabel.setText(Login.usernameformDB);
        quiz_taken.setText(Login.qt);
        cScore.setText(score);
//        fullName.getEditText().setText(user_name);
//        email.getEditText().setText(user_email);
//        phoneNo.getEditText().setText(user_phoneNo);
//        password.getEditText().setText(user_password);

        fullNameLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAddItemDialog(UserProfile.this);
//                AlertDialog.Builder alert = new AlertDialog.Builder(UserProfile.this);
//
//                alert.setTitle("Title");
//                alert.setMessage("Message");
//
//// Set an EditText view to get user input
//                final EditText input = new EditText(UserProfile.this);
//                alert.setView(input);
//
//                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//
//                        // Do something with value!
//                    }
//                });
//
//                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        // Canceled.
//                    }
//                });
//
//                alert.show();

            }
        });

    }

    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Add your new name")
                .setMessage("Type it below...")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        Login.nameformDB=task;
                        databaseReference.child(Login.usernameformDB).child("name").setValue(Login.nameformDB);
                        Intent intent =new Intent(UserProfile.this,UserProfile.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

    private Toast exitToast;

    @Override
    public void onBackPressed() {
        if (exitToast == null || exitToast.getView() == null || exitToast.getView().getWindowToken() == null) {
            exitToast = Toast.makeText(this, "Press again to Logout", Toast.LENGTH_LONG);
            exitToast.show();
        } else {
            exitToast.cancel();
            finishAffinity();
            Intent a = new Intent(UserProfile.this, Login.class);
            startActivity(a);
        }
    }
}