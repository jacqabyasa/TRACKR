package com.example.uts4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ActivityPr extends AppCompatActivity {

    private EditText editTextTodo;
    private FloatingActionButton btnAdd;
    private RecyclerView recyclerView;
    private adapter prAdapter;
    private List<String> x;

    ArrayList<String> prList;
    ArrayList<String> todoList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr);

        todoList = getIntent().getStringArrayListExtra("test");
        prList = getIntent().getStringArrayListExtra("test1");


        btnAdd = findViewById(R.id.buttonAdd);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        prAdapter = new adapter(prList);
        recyclerView.setAdapter(prAdapter);


        FloatingActionButton buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View dialogView = getLayoutInflater().inflate(R.layout.workout_dialog, null);

                // Find and set up the necessary views within the dialog layout
                EditText input = dialogView.findViewById(R.id.editTextTodo);
                RadioGroup radioGroupCategory = dialogView.findViewById(R.id.radioGroupCategory);

                // Create an AlertDialog Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPr.this);
                builder.setTitle("Add Exercise");
                builder.setView(dialogView);

                // Set up the buttons
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String pr = input.getText().toString().trim();

                        int selectedRadioButtonId = radioGroupCategory.getCheckedRadioButtonId();
                        String category = "";
                        if (selectedRadioButtonId == R.id.rb_push) {
                            category = "Push";
                        } else if (selectedRadioButtonId == R.id.rb_pull) {
                            category = "Pull";
                        } else if (selectedRadioButtonId == R.id.rb_legs) {
                            category = "Legs";
                        }

                        prList.add(pr + " (" + category + ")");
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }


        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityPr.this, ActivityHome.class);
        intent.putStringArrayListExtra("test", (ArrayList<String>) todoList);
        intent.putStringArrayListExtra("test1", (ArrayList<String>) prList);
        startActivity(intent);
        finish();
    }
}