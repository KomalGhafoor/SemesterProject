package com.codewithkomal.semesterproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
  Button ChangeProfile;
    TextView profileUserName,profileEmail,profileSemester,profilePassword,profileName,textView ;
    ImageView profileView,  callLogout;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ChangeProfile=findViewById(R.id.editProfile);
        //profileEmail=findViewById(R.id.email);
        //profileUserName=findViewById(R.id.username);
        //profileSemester=findViewById(R.id.semester);
        //profilePassword=findViewById(R.id.password);

        profileView=(ImageView) findViewById(R.id.profile);
        ChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,editProfile.class);
                startActivity(intent);
            }
        });
        callLogout=(ImageView) findViewById(R.id.logout);
        callLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
        DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
        textView=findViewById(R.id.profiletext);
        StringBuilder stringBuilder=new StringBuilder();
        Cursor cursor=dataBaseHelper.ViewData();
        while(cursor.moveToNext()) {
            stringBuilder.append("\nEmail:"+cursor.getInt(1) +"\nUserName :" +cursor.getString(2)
                    +"\nSemester :" +cursor.getString(3)+ "\nPassword :" +cursor.getString(4)) ;


        }
        textView.setText(stringBuilder);

    }


}