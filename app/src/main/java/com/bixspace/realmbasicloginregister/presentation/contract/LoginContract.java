package com.bixspace.realmbasicloginregister.presentation.contract;

import com.bixspace.realmbasicloginregister.core.BasePresenter;
import com.bixspace.realmbasicloginregister.core.BaseView;

/**
 * Created by miguel on 06/02/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter>{
        void loginSuccessfully();
        void loginDenied(String response);
    }
    interface Presenter extends BasePresenter{
        void login(String email,String password);
        void loginApi(String email,String password);
    }
}
