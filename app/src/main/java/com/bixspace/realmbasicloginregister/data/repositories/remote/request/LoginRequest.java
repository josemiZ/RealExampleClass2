package com.bixspace.realmbasicloginregister.data.repositories.remote.request;

import com.bixspace.realmbasicloginregister.data.entities.UserSerializable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by miguel on 06/02/17.
 */

public interface LoginRequest {

    @FormUrlEncoded
    @POST("login")
    Call<UserSerializable> login(@Field("correo_registro") String email,
                                 @Field("password_registro") String password,
                                 @Field("nombre_registro") String name);
}
