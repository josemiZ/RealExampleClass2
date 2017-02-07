package com.bixspace.realmbasicloginregister.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bixspace.realmbasicloginregister.R;
import com.bixspace.realmbasicloginregister.core.BaseActivity;
import com.bixspace.realmbasicloginregister.presentation.fragment.LoginFragment;
import com.bixspace.realmbasicloginregister.presentation.presenter.LoginPresenter;
import com.bixspace.realmbasicloginregister.presentation.util.ActivityUtils;

/**
 * Created by miguel on 06/02/17.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white);

        LoginFragment fragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if(fragment == null){
            fragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.body);
        }

        new LoginPresenter(fragment,getApplicationContext());
    }
}
