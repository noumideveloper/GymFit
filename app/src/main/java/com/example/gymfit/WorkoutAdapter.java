package com.example.gymfit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.MyHolder> {

    String[] data = {"Push-ups","Squats","Plank","Jumping Jacks"};

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_workout, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.txt.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView txt;
        CheckBox chk;
        MyHolder(View v){
            super(v);
            txt = v.findViewById(R.id.txtExercise);
            chk = v.findViewById(R.id.chkDone);
        }
    }
}

