package com.codewithkomal.semesterproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class editProfile extends AppCompatActivity {
    ImageView callLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        callLogout=(ImageView) findViewById(R.id.logout);
        callLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(editProfile.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}