package com.codewithkomal.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class boyList2 extends AppCompatActivity {

    Button movetoCat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boy_list2);

        movetoCat2 = findViewById(R.id.b2);

        movetoCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(boyList2.this,Category2.class);
                startActivity(intent);
            }
        });
    }
}