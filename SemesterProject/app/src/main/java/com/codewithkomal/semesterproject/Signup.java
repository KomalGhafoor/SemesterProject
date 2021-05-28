package com.codewithkomal.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

    private EditText emailSignUp, usernameSignUp, passwordSignUp, phoneSignUp, nameSignUp, semesterSignUp;

    Button callLogin ,calLgin;
    private DataBaseHelper myDB;
    private static final Pattern PASSWORD_PATTERN=Pattern.compile( "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$" );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
       // getSupportActionBar().hide();
        setContentView( R.layout.activity_signup );
        emailSignUp = findViewById( R.id.email );
        usernameSignUp = findViewById( R.id.username );
        passwordSignUp = findViewById( R.id.password );
        phoneSignUp = findViewById( R.id.phoneNo );
        nameSignUp = findViewById( R.id.name );
        semesterSignUp = findViewById( R.id.semester );
        //countrySignUp = findViewById( R.id.ccp );
        callLogin = findViewById( R.id.signup_btn );
        calLgin=findViewById( R.id.signup );


        calLgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this,Login.class);
                startActivity(intent);
            }
        });
        myDB = new DataBaseHelper( this );

        insertUser();
    }
  /*  private boolean validateEmail()
    {
        String emailInput= emailSignUp.getText().toString().trim();
        if(!Patterns.EMAIL_ADDRESS.matcher( emailInput ).matches())
        {
            emailSignUp.setError("Please enter a valid email address");
            return false;
        }
        else
            emailSignUp.setError( null );
        return true;

    }*/

    private void insertUser(){

        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput= emailSignUp.getText().toString().trim();
                if(usernameSignUp.getText().toString().equals("") || nameSignUp.getText().toString().equals("") || emailSignUp.getText().toString().equals("") || semesterSignUp.getText().toString().equals("") || phoneSignUp.getText().toString().equals("") || passwordSignUp.getText().toString().equals("") ) {
                    Toast.makeText( Signup.this, "Fill All The Fields", Toast.LENGTH_SHORT ).show();

                }
                /*else if(!usernameSignUp.getText().toString().matches( "^[A-Za-z]\\w{5,29}$ " )) {
                    usernameSignUp.setError( "Enter Only Characters" );
                }
                else if(!semesterSignUp.getText().toString().matches( "[1-8][1]" )) {
                    semesterSignUp.setError( "Enter Only digit" );
                }*/
                else if(!Patterns.EMAIL_ADDRESS.matcher( emailInput ).matches()) {
                    emailSignUp.setError( "Please enter a valid email address" );
                }
               /* else if(!phoneSignUp.getText().toString().matches("[0-9][10]" ))
                {
                    phoneSignUp.setError( "Enters only 10 digit Mobile Number" );
                }*/
                 else if(!PASSWORD_PATTERN.matcher(passwordSignUp.getText().toString().trim()).matches())
                {
                    passwordSignUp.setError( "Password too weak" );
                }
                else {
                    String user = usernameSignUp.getText().toString();
                    boolean usercheckResult= myDB.checkUserName( user );
                    if(usercheckResult==false) {
                        boolean var = myDB.registerUser( nameSignUp.getText().toString(), usernameSignUp.getText().toString(), semesterSignUp.getText().toString(), emailSignUp.getText().toString(), phoneSignUp.getText().toString(), passwordSignUp.getText().toString() );
                        if (var) {

                            Toast.makeText( Signup.this, "User Registered Successfully !!", Toast.LENGTH_SHORT ).show();
                            startActivity( new Intent( Signup.this, Login.class ) );

                        }  else
                            Toast.makeText( Signup.this, "Registration Error !!", Toast.LENGTH_SHORT ).show();

                    }
                    else
                        Toast.makeText( Signup.this, "User Already Exist Please Login !!", Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
}