package com.example.gymfit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUserLogin, etPassLogin;
    Button btnLoginNow;
    TextView txtForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserLogin = findViewById(R.id.etUserLogin);
        etPassLogin = findViewById(R.id.etPassLogin);
        btnLoginNow = findViewById(R.id.btnLoginNow);
        txtForgot = findViewById(R.id.txtForgot);

        btnLoginNow.setOnClickListener(v -> {

            String inputUser = etUserLogin.getText().toString().trim();
            String inputPass = etPassLogin.getText().toString().trim();

            if (inputUser.isEmpty() || inputPass.isEmpty()) {
                Toast.makeText(this, "Enter username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences sp = getSharedPreferences("UserSession", MODE_PRIVATE);

            String savedUser = sp.getString("username", null);
            String savedPass = sp.getString("password", null);

            // if user never signed up
            if (savedUser == null || savedPass == null) {
                Toast.makeText(this, "No account found. Please sign up first.", Toast.LENGTH_SHORT).show();
                return;
            }

            // compare
            if (inputUser.equals(savedUser) && inputPass.equals(savedPass)) {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
                finish();

            } else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
        });

        txtForgot.setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }
}
