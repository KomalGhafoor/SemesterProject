package com.codewithkomal.semesterproject;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText loginUsername,loginPassword;
    private DataBaseHelper myDb;
    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, sloganText;
    //TextInputLayout username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        //getSupportActionBar().hide();
        setContentView( R.layout.activity_login );

        //Hooks
        callSignUp = findViewById( R.id.signup );
        image = findViewById( R.id.logoImage );
        logoText = findViewById( R.id.logo_name );
        sloganText = findViewById( R.id.slogan_name );
        //username = findViewById( R.id.username );
        // password = findViewById( R.id.password );
        loginUsername = findViewById( R.id.loginusername );
        loginPassword = findViewById( R.id.password );
        login_btn = findViewById( R.id.Login_btn );

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });
        myDb = new DataBaseHelper( this );
        loginUser();
    }

    private void loginUser() {
        login_btn.setOnClickListener( v-> {
            if(loginUsername.getText().toString().equals("") || loginPassword.getText().toString().equals("") )
            {
                Toast.makeText( Login.this, "Fill All The Fields", Toast.LENGTH_SHORT ).show();
            }
            else {
                boolean var = myDb.checkUser( loginUsername.getText().toString(), loginPassword.getText().toString() );
                if (var) {


                    Toast.makeText( Login.this, "Login Successfully", Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent( Login.this, Home.class ) );
                    finish();
                } else {
                    Toast.makeText( Login.this, "Login Failed !!", Toast.LENGTH_SHORT ).show();
                }
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>( image, "logo_image" );
                pairs[1] = new Pair<View, String>( image, "logo_text" );
                pairs[2] = new Pair<View, String>( image, "logo_desc" );
                pairs[3] = new Pair<View, String>( image, "uname_trans" );
                pairs[4] = new Pair<View, String>( image, "password_trans" );
                pairs[5] = new Pair<View, String>( image, "login_trans" );
                pairs[6] = new Pair<View, String>( image, "signup_trans" );

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( Login.this, pairs );
            }
        } );

    }
}