package com.example.posyandu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int mode =0;

    private static final String pref_posyandu ="prefPosyandu";
    private static final String is_login ="isLogin";
    private static final String key_username ="keyUsername";

    public SessionManager(Context context){
        this.context=context;
        pref=context.getSharedPreferences(pref_posyandu,mode);
        editor= pref.edit();
    }
    public void createSession(String username){
        editor.putBoolean(is_login,true);
        editor.putString(key_username, username);
        editor.commit();
    }
    public void cekLogin (){
        if (!this.is_login()){
            Intent i = new Intent(context,LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        else {
            Intent i = new Intent(context,ContainerActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
    private boolean is_login(){
        return pref.getBoolean(is_login, false);
    }
    public HashMap<String,String> getUserDetails(){
        HashMap<String,String> user =new HashMap<String,String>();
        user.put(pref_posyandu,pref.getString(pref_posyandu,null));
        user.put(key_username, pref.getString(key_username,null));
        return user;
    }
}
