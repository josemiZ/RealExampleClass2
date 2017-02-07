package com.bixspace.realmbasicloginregister.data.repositories.local;

import android.content.Context;

import com.bixspace.realmbasicloginregister.data.entities.realmEntities.User;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by miguel on 06/02/17.
 */

public class UserRealm {
    private Context context;
    private RealmHelper realmHelper;
    public static String EMAIL="email";

    public static String PASSWORD = "password";

    public UserRealm(Context context) {
        this.context = context;
        realmHelper = new RealmHelper();
        realmHelper.initRealm(context);
    }

    public RealmResults<User> getUsers(){
        Realm realm = realmHelper.getInstance();
        return realm.where(User.class).findAll();
    }

    public void registerUser(User user){
        Realm realm = realmHelper.getInstance();
        user.setId(getUsers().size()+ 1);
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }

    public User login(String email,String password){
        Realm realm = realmHelper.getInstance();
        return realm.where(User.class).equalTo(EMAIL,email).equalTo(PASSWORD,password).findFirst();
    }
}
