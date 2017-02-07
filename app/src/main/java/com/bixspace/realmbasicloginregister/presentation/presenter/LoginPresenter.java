package com.bixspace.realmbasicloginregister.presentation.presenter;

import android.content.Context;

import com.bixspace.realmbasicloginregister.data.entities.UserSerializable;
import com.bixspace.realmbasicloginregister.data.entities.realmEntities.User;
import com.bixspace.realmbasicloginregister.data.repositories.local.SessionManager;
import com.bixspace.realmbasicloginregister.data.repositories.local.UserRealm;
import com.bixspace.realmbasicloginregister.data.repositories.remote.ServiceGeneratorSimple;
import com.bixspace.realmbasicloginregister.data.repositories.remote.request.LoginRequest;
import com.bixspace.realmbasicloginregister.presentation.contract.LoginContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by miguel on 06/02/17.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private UserRealm userRealm;
    private SessionManager sessionManager;


    public LoginPresenter(LoginContract.View mView, Context context) {
        this.mView = mView;
        this.userRealm = new UserRealm(context);
        this.sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void login(String email, String password) {
        mView.setLoadingIndicator(true);
        User user = userRealm.login(email,password);
        mView.setLoadingIndicator(false);
        if(user!=null){
            //sessionManager.login(user);
            mView.loginSuccessfully();
        }
        else{
            mView.loginDenied("Lo sentimos, hubo un error de registro");
        }

    }

    @Override
    public void loginApi(String email, String password) {
        mView.setLoadingIndicator(true);
        LoginRequest loginRequest = ServiceGeneratorSimple.createService(LoginRequest.class);
        Call<UserSerializable> call = loginRequest.login(email,password,"exe");
        call.enqueue(new Callback<UserSerializable>() {
            @Override
            public void onResponse(Call<UserSerializable> call, Response<UserSerializable> response) {
                if (!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.loginSuccessfully();
                }
                else {
                    mView.loginDenied("Correo incorrecto");
                }
            }

            @Override
            public void onFailure(Call<UserSerializable> call, Throwable t) {
                if (!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.loginDenied("No se pudo acceder al servidor en este momento");
            }
        });
    }

    @Override
    public void start() {

    }
}
