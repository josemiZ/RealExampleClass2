package com.bixspace.realmbasicloginregister.presentation.presenter;

import android.content.Context;

import com.bixspace.realmbasicloginregister.data.entities.realmEntities.User;
import com.bixspace.realmbasicloginregister.data.repositories.local.SessionManager;
import com.bixspace.realmbasicloginregister.data.repositories.local.UserRealm;
import com.bixspace.realmbasicloginregister.presentation.contract.RegisterContract;

/**
 * Created by miguel on 06/02/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View mView;
    private UserRealm userRealm;
    private SessionManager sessionManager;

    public RegisterPresenter(RegisterContract.View mView, Context context) {
        this.mView = mView;
        this.userRealm = new UserRealm(context);
        this.sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void registerUser(User user) {
        mView.setLoadingIndicator(true);
        userRealm.registerUser(user);
        login(user);
    }

    private void login(User user){
        mView.setLoadingIndicator(false);
        //sessionManager.login(user);
        if(user!=null){
            mView.registerSuccessfully();
        }
        else{
            mView.registerDenied("Lo sentimos, hubo un error de registro");
        }
    }

    @Override
    public void start() {

    }
}
