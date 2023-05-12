package com.example.uts4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class ActivityTimer extends AppCompatActivity {
    private Button btntimer, btnStopwatch;
    private TimerFragment timerFragment;
    private StopwatchFragment stopwatchFragment;
    ArrayList<String> test;
    ArrayList<String> test1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        test = getIntent().getStringArrayListExtra("test");
        test1 = getIntent().getStringArrayListExtra("test1");


        btntimer = findViewById(R.id.btnTimer);
        btnStopwatch = findViewById(R.id.btnStopwatch);

        timerFragment = new TimerFragment();
        stopwatchFragment = new StopwatchFragment();

        btntimer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, TimerFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // Name can be null
                        .commit();
            }
        });

        btnStopwatch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, StopwatchFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // Name can be null
                        .commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Check if the currently displayed fragment is the one you want to handle back press for
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView3);
        Intent intent = new Intent(this, ActivityHome.class);
        intent.putStringArrayListExtra("test", (ArrayList<String>) test);
        intent.putStringArrayListExtra("test1", (ArrayList<String>) test1);
        startActivity(intent);
    }


}