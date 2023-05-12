package com.example.uts4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity {

    private ImageButton btnWorkout, btnPr, btnBody, btnTimer;

    ArrayList<String> test;
    ArrayList<String> test1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        test = getIntent().getExtras().getStringArrayList("test");
        test1 = getIntent().getExtras().getStringArrayList("test1");


        btnWorkout = findViewById(R.id.btn_workout);
        btnPr = findViewById(R.id.btn_pr);
        btnBody = findViewById(R.id.btn_body);
        btnTimer = findViewById(R.id.btn_timer);

        btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityWorkout.class);
                intent.putStringArrayListExtra("test", (ArrayList<String>) test);
                intent.putStringArrayListExtra("test1", (ArrayList<String>) test1);
                startActivity(intent);
            }
        });

        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityTimer.class);
                intent.putStringArrayListExtra("test", (ArrayList<String>) test);
                intent.putStringArrayListExtra("test1", (ArrayList<String>) test1);
                startActivity(intent);
            }
        });

        btnPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityPr.class);
                intent.putStringArrayListExtra("test", (ArrayList<String>) test);
                intent.putStringArrayListExtra("test1", (ArrayList<String>) test1);
                startActivity(intent);
            }
        });

        btnBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityBody.class);
                intent.putStringArrayListExtra("test", (ArrayList<String>) test);
                intent.putStringArrayListExtra("test1", (ArrayList<String>) test1);
                startActivity(intent);
            }
        });



    }
}