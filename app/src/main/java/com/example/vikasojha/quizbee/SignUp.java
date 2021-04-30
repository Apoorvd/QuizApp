package com.example.vikasojha.quizbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //Variables
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Hooks
        regName = findViewById(R.id.name);
        regUsername = findViewById(R.id.username);
        regEmail = findViewById(R.id.email);
        regPhoneNo = findViewById(R.id.phoneNo);
        regPassword = findViewById(R.id.password);
        regBtn = findViewById(R.id.go_btn);
        regToLoginBtn = findViewById(R.id.log_in_screen);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                if ( !validateEmail() | !validateName() | !validatePassword() | !validatePhoneNo() | !validateUsername()){
                    return;
                }

                String cScore="0.0", quiz_taken="0", cTscore = "0 0 0 0 0 0 0 0 0 0 0 0 0_";
                //Get all the values

                String name = regName.getEditText().getText().toString(); //imp*******
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneNo = regPhoneNo.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();


                UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password,  cScore , quiz_taken, cTscore);

//                reference.setValue(helperClass);

              reference.child(username).setValue(helperClass);

              //reference.child(username).child("quiz_taken").setValue("10");
//                reference.child(username).push();
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private Boolean validateName() {
        String val = regName.getEditText().getText().toString(); //imp*******

        if(val.isEmpty()) {
            regName.setError("Field cannot be empty");
            return false;
        } else {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = regUsername.getEditText().getText().toString(); //imp*******
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()) {
            regUsername.setError("Field cannot be empty");
            return false;
        } else if(val.length()>=15) {
            regUsername.setError("Username too long");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            regUsername.setError("White Spaces are not allowed");
            return false;
        }
        else{
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString(); //imp*******
        String emailPattern ="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        if(val.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        }else if(!val.matches(emailPattern)){
            regEmail.setError("Invalid email address");
            return false;
        }
        else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo() {
        String val = regPhoneNo.getEditText().getText().toString(); //imp*******

        if(val.isEmpty()) {
            regPhoneNo.setError("Field cannot be empty");
            return false;
        } else {
            regPhoneNo.setError(null);
            regPhoneNo.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString(); //imp*******
        //String passwordVal= "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
        if(val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        }else if(!((val.matches(".*[0-9]{1,}.*") && val.matches(".*[@#$]{1,}.*") && val.length()>=6 && val.length()<=20))){
            regPassword.setError("Password is too weak");
            return false;
        }
        else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }

    public void registerUser(View view) {

        if ( !validateEmail() | !validateName() | !validatePassword() | !validatePhoneNo() | !validateUsername()){
            return;
        }
        //Get all the values in String
        String name = regName.getEditText().getText().toString(); //imp*******
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNo = regPhoneNo.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        String cScore = "0.00", quiz_taken = "0" , cTscore= "";
        UserHelperClass helperClass = new UserHelperClass(name, username,email, phoneNo, password, cScore , quiz_taken, cTscore);

        reference.setValue(helperClass);
    }
    public void onBackPressed() {
        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);

        finish();
    }
}