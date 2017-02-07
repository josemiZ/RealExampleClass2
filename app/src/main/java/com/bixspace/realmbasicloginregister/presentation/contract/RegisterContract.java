package com.bixspace.realmbasicloginregister.presentation.contract;

import com.bixspace.realmbasicloginregister.core.BasePresenter;
import com.bixspace.realmbasicloginregister.core.BaseView;
import com.bixspace.realmbasicloginregister.data.entities.realmEntities.User;

/**
 * Created by miguel on 06/02/17.
 */

public interface RegisterContract {
    interface View extends BaseView<Presenter>{
        void registerSuccessfully();
        void registerDenied(String error);
    }
    interface Presenter extends BasePresenter{
        void registerUser(User user);
    }
}
