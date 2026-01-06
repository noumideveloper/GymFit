package com.example.gymfit;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSession {

    Context context;

    public UserSession(Context context){
        this.context = context;
    }

    public void saveUser(String username, String password){
        SharedPreferences sp = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("username", username);
        ed.putString("password", password);
        ed.apply();
    }

    public boolean login(String username, String password){
        SharedPreferences sp = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        return username.equals(sp.getString("username",""))
                && password.equals(sp.getString("password",""));
    }

    public void resetPassword(String newPass){
        SharedPreferences sp = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("password", newPass);
        ed.apply();
    }

    public String getUsername(){
        SharedPreferences sp = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        return sp.getString("username","");
    }
}

