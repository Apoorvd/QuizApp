package com.example.vikasojha.quizbee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button CallSignUp, login_btn;

    ImageView image;

//    static String user;
    TextView logoText, sloganText;

    TextInputLayout username, password;

    static String nameformDB, usernameformDB, phoneNoformDB, emailformDB, cs, qt, ct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        //Hooks
        CallSignUp = findViewById(R.id.sign_up_screen);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.Login_btn);



        CallSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
//                startActivity(intent);


                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(image, "logo_img");
                pairs[1]=new Pair<View,String>(logoText, "logo_text");
                pairs[2]=new Pair<View,String>(sloganText, "heading_trans");
                pairs[3]=new Pair<View,String>(username, "username_trans");
                pairs[4]=new Pair<View,String>(password, "pass_trans");
                pairs[5]=new Pair<View,String>(login_btn, "go_trans");
                pairs[6]=new Pair<View,String>(CallSignUp, "sign_up_trans");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(v);
            }
        });

    }

    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString(); //imp*******
        if(val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString(); //imp*******

        if(val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {
        //Validate Login Info
        if( !validatePassword() | !validateUsername())
            return;
        else{
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredUsername = username.getEditText().getText().toString();
        final String userEnteredPassword = password.getEditText().getText().toString();

//        Toast.makeText(this, userEnteredUsername, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, userEnteredPassword, Toast.LENGTH_SHORT).show();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if ( snapshot.exists()){

//                    user = userEnteredUsername;
                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordformDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);
//                    String s = passwordformDB;
//                    Toast.makeText(Login.this,s, Toast.LENGTH_SHORT).show();
//                    assert passwordformDB != null;
                    if(passwordformDB.equals(userEnteredPassword)){

                        username.setError(null);
                        username.setErrorEnabled(false);

                        nameformDB = snapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        usernameformDB = snapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        phoneNoformDB = snapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                        emailformDB = snapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        cs = snapshot.child(userEnteredUsername).child("cScore").getValue(String.class);
                        qt = snapshot.child(userEnteredUsername).child("quiz_taken").getValue(String.class);
                        ct = snapshot.child(userEnteredUsername).child("cTscore").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(), UserProfile.class);

//                        intent.putExtra("name",nameformDB);
//                        intent.putExtra("username",usernameformDB);
//                        intent.putExtra("email",emailformDB);
//                        intent.putExtra("phoneNo",phoneNoformDB);
//                        intent.putExtra("password",passwordformDB);
//                        intent.putExtra("cScore", cs);
//                        intent.putExtra("quiz_taken", qt);

                        //intent.putExtra("",);

                        startActivity(intent);
                    }
                    else{
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }

                }
                else{
                    username.setError("No User found");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
//    @Override
//    public void onBackPressed() {
//
//        int count = getSupportFragmentManager().getBackStackEntryCount();
//        //Log.e("count", "is getBackStackEntryCount -> " + count);
//        if(count == 0)
//        {
//            super.onBackPressed();
//        }
//        for (int i = 0; i < count; ++i) {
//            getSupportFragmentManager().popBackStackImmediate();
//            //Log.e("getBackStack", "IS REMOVED " + i);
//        }
//        this.finish();
//        //return;
//    }


    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}