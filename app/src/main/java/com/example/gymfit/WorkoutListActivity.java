package com.example.gymfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutListActivity extends AppCompatActivity {

    RecyclerView recycler;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout);

        back = findViewById(R.id.back);
        recycler = findViewById(R.id.recycler);

        // back button finishes activity
        back.setOnClickListener(v -> finish());

        // setup RecyclerView
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // adapter
        WorkoutAdapter adapter = new WorkoutAdapter();
        recycler.setAdapter(adapter);
    }
}
