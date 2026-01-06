package com.example.gymfit;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        EditText newPass = findViewById(R.id.newPass);

        findViewById(R.id.btnResetNow).setOnClickListener(v -> {

            new UserSession(this).resetPassword(newPass.getText().toString());

            Toast.makeText(this, "Password reset successful", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
