package com.example.uts4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class ActivityBody extends AppCompatActivity {

    private EditText w;
    private EditText h;
    private Button btnCalculate;
    private TextView resultTextView;
    ArrayList<String> test;
    ArrayList<String> test1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        test = getIntent().getExtras().getStringArrayList("test");
        test1 = getIntent().getExtras().getStringArrayList("test1");

        w = findViewById(R.id.weight);
        h = findViewById(R.id.height);
        btnCalculate = findViewById(R.id.btnCalculate);
        resultTextView = findViewById(R.id.result);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Below 18.5 --> Underweight");
        arrayList.add("18.5—24.9 --> Healthy Weight");
        arrayList.add("25.0—29.9 --> Overweight");
        arrayList.add("30.0 and Above --> Obesity");

        ListView listView = (ListView) findViewById(R.id.listview);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, arrayList);
        listView.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = Double.parseDouble(w.getText().toString());
                double height = Double.parseDouble(h.getText().toString())/100;

                double bmi = weight / (height * height);

                resultTextView.setText("BMI = " + bmi);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityBody.this, ActivityHome.class);
        intent.putStringArrayListExtra("test", (ArrayList<String>) test);
        intent.putStringArrayListExtra("test1", (ArrayList<String>) test1);
        startActivity(intent);
        finish();
    }
}