package com.example.uts4;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TimerFragment extends Fragment {

    private TextView textViewTimer;
    private Button buttonStart;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;

    private static final long TIMER_DURATION = 60000; // 1 minute
    private static final long TIMER_INTERVAL = 1000; // 1 second

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        textViewTimer = view.findViewById(R.id.text_view_timer);
        buttonStart = view.findViewById(R.id.button_start);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTimerRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });

        return view;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(TIMER_DURATION, TIMER_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimerText(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                updateTimerText(0);
                isTimerRunning = false;
                buttonStart.setText("Start");
            }
        };

        countDownTimer.start();
        isTimerRunning = true;
        buttonStart.setText("Stop");
    }

    private void stopTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        buttonStart.setText("Start");
    }

    private void updateTimerText(long millisUntilFinished) {
        int minutes = (int) (millisUntilFinished / 1000) / 60;
        int seconds = (int) (millisUntilFinished / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        textViewTimer.setText(timeLeftFormatted);
    }


}