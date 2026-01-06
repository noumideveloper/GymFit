package com.example.gymfit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(v -> {

            String username = etUser.getText().toString().trim();
            String password = etPass.getText().toString().trim();

            // validation
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            // save correctly
            SharedPreferences sp = getSharedPreferences("UserSession", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();

            editor.putString("username", username);
            editor.putString("password", password);
            editor.apply();

            Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
