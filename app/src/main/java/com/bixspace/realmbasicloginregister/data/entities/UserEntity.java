package com.bixspace.realmbasicloginregister.data.entities;

import java.io.Serializable;

/**
 * Created by miguel on 06/02/17.
 */

public class UserEntity implements Serializable {
    private String correo_registro;
    private String password_registro;
    private String nombre_registro;

    public String getCorreo_registro() {
        return correo_registro;
    }

    public void setCorreo_registro(String correo_registro) {
        this.correo_registro = correo_registro;
    }

    public String getPassword_registro() {
        return password_registro;
    }

    public void setPassword_registro(String password_registro) {
        this.password_registro = password_registro;
    }

    public String getNombre_registro() {
        return nombre_registro;
    }

    public void setNombre_registro(String nombre_registro) {
        this.nombre_registro = nombre_registro;
    }
}
