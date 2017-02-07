package com.bixspace.realmbasicloginregister.data.repositories.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.bixspace.realmbasicloginregister.data.entities.UserSerializable;
import com.google.gson.Gson;

/**
 * Created by miguel on 06/02/17.
 */

public class SessionManager {
    static final String PREFERENCE_NAME = "NamePreference";
    static int PRIVATE_MODE = 0;

    private static final String USER_JSON = "user_json";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void login(UserSerializable user){
        String profile = new Gson().toJson(user);
        editor.putString(USER_JSON,profile);
        editor.commit();
    }

    public UserSerializable getUser(){
        String user = preferences.getString(USER_JSON,null);
        return  new Gson().fromJson(user,UserSerializable.class);
    }

}
