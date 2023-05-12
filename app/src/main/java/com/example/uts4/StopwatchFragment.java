package com.example.uts4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StopwatchFragment extends Fragment {

    private TextView textViewStopwatch;
    private Button buttonStart;
    private Button buttonReset;
    private Handler stopwatchHandler;
    private Runnable stopwatchRunnable;
    private long startTime = 0;
    private boolean isRunning = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        textViewStopwatch = view.findViewById(R.id.text_view_stopwatch);
        buttonStart = view.findViewById(R.id.button_start);
        buttonReset = view.findViewById(R.id.button_reset);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    stopStopwatch();
                } else {
                    startStopwatch();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetStopwatch();
            }
        });

        stopwatchHandler = new Handler();
        stopwatchRunnable = new Runnable() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis() - startTime;
                updateStopwatchText(currentTime);
                stopwatchHandler.postDelayed(this, 10);
            }
        };

        return view;
    }

    private void startStopwatch() {
        startTime = System.currentTimeMillis();
        isRunning = true;
        buttonStart.setText("Stop");
        buttonReset.setEnabled(false);
        stopwatchHandler.postDelayed(stopwatchRunnable, 0);
    }

    private void stopStopwatch() {
        isRunning = false;
        buttonStart.setText("Start");
        buttonReset.setEnabled(true);
        stopwatchHandler.removeCallbacks(stopwatchRunnable);
    }

    private void resetStopwatch() {
        stopStopwatch();
        startTime = 0;
        updateStopwatchText(0);
    }

    private void updateStopwatchText(long elapsedTime) {
        int minutes = (int) (elapsedTime / 1000) / 60;
        int seconds = (int) (elapsedTime / 1000) % 60;
        int milliseconds = (int) (elapsedTime % 1000) / 10;
        String timeFormatted = String.format("%02d:%02d:%02d", minutes, seconds, milliseconds);
        textViewStopwatch.setText(timeFormatted);
    }

}