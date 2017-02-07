package com.bixspace.realmbasicloginregister.data.repositories.remote.request;

import com.bixspace.realmbasicloginregister.data.entities.MessageSerializable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by miguel on 06/02/17.
 */

public interface RegisterRequest {
    @POST("registro")
    Call<MessageSerializable> registerUser(@Field("correo_registro") String email,
                                           @Field("password_registro") String password,
                                           @Field("nombre_registro") String name);
}
