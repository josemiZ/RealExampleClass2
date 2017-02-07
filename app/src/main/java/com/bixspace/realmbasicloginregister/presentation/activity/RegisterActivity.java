package com.bixspace.realmbasicloginregister.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.bixspace.realmbasicloginregister.R;
import com.bixspace.realmbasicloginregister.core.BaseActivity;
import com.bixspace.realmbasicloginregister.presentation.fragment.RegisterFragment;
import com.bixspace.realmbasicloginregister.presentation.presenter.RegisterPresenter;
import com.bixspace.realmbasicloginregister.presentation.util.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 06/02/17.
 */

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.app_name);
        ab.setDefaultDisplayHomeAsUpEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        RegisterFragment registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if (registerFragment == null) {
            registerFragment = RegisterFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), registerFragment, R.id.body);
        }

        new RegisterPresenter(registerFragment,getApplicationContext());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
