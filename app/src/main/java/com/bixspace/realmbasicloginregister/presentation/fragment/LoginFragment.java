package com.bixspace.realmbasicloginregister.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bixspace.realmbasicloginregister.R;
import com.bixspace.realmbasicloginregister.core.BaseActivity;
import com.bixspace.realmbasicloginregister.core.BaseFragment;
import com.bixspace.realmbasicloginregister.presentation.activity.RegisterActivity;
import com.bixspace.realmbasicloginregister.presentation.contract.LoginContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by miguel on 06/02/17.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View{
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    private LoginContract.Presenter presenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                presenter.loginApi(etEmail.getText().toString(),etPassword.getText().toString());
                break;
            case R.id.btn_register:
                nextActivity(getActivity(),null, RegisterActivity.class,false);
                break;
        }
    }

    @Override
    public void loginSuccessfully() {
        loginDenied("Inicio de sesión exitosa");
    }

    @Override
    public void loginDenied(String response) {
        ((BaseActivity)getActivity()).showMessageError(response);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
