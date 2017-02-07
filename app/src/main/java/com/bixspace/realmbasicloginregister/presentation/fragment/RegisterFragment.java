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
import com.bixspace.realmbasicloginregister.data.entities.realmEntities.User;
import com.bixspace.realmbasicloginregister.presentation.contract.RegisterContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by miguel on 06/02/17.
 */

public class RegisterFragment extends BaseFragment implements RegisterContract.View{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.last_name)
    EditText lastName;
    @BindView(R.id.gender)
    EditText gender;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private RegisterContract.Presenter presenter;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        User user = new User();
        user.setEmail(etEmail.getText().toString());
        user.setGender(gender.getText().toString());
        user.setPassword(etPassword.getText().toString());
        user.setName(name.getText().toString());
        user.setLastName(lastName.getText().toString());
        presenter.registerUser(user);
    }

    @Override
    public void registerSuccessfully() {
        registerDenied("Registro exitoso");
    }

    @Override
    public void registerDenied(String error) {
        ((BaseActivity)getActivity()).showMessageError(error);
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }
}
