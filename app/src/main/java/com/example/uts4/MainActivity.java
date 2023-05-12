package com.example.uts4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    List<akun> listAkun = new ArrayList<akun>();
    private int flag = 0;
    private int index = 0;
    private ArrayList<String> test;
    private ArrayList<String> test1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listAkun.add(new akun("user", "123"));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = new ArrayList<String>(50);
        test1 = new ArrayList<String>(50);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = etUsername.getText().toString();
                String ps = etPassword.getText().toString();

                for(int i = 0; i<listAkun.size(); i++){
                    akun curr = listAkun.get(i);
                    if(curr.username.contentEquals(un) && curr.password.contentEquals(ps)){
                        flag = 1;
                        index = i;
                        break;
                    }
                }

                if (flag == 1) {
                    // Valid
                    Intent intent = new Intent(MainActivity.this, ActivityHome.class);
                    intent.putStringArrayListExtra("test", (ArrayList<String>) test);
                    intent.putStringArrayListExtra("test1", (ArrayList<String>) test1);
                    startActivity(intent);
                } else {
                    // Invalid
                    Toast.makeText(MainActivity.this, "Invalid username or password. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}