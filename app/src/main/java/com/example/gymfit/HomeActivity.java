package com.example.gymfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // avoid crash if no action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Exercise App");
        }

        View bmiBtn = findViewById(R.id.btnBMI);
        View workoutBtn = findViewById(R.id.btnWorkout);

        // avoid crash if IDs missing
        if (bmiBtn != null) {
            bmiBtn.setOnClickListener(v ->
                    startActivity(new Intent(this, BMICalculatorActivity.class)));
        }

        if (workoutBtn != null) {
            workoutBtn.setOnClickListener(v ->
                    startActivity(new Intent(this, WorkoutListActivity.class)));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("User Page");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, UserActivity.class));
        return true;
    }
}
