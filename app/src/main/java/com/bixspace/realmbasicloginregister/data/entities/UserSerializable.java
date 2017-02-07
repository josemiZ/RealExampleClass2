package com.bixspace.realmbasicloginregister.data.entities;

import java.io.Serializable;

/**
 * Created by miguel on 06/02/17.
 */

public class UserSerializable implements Serializable {
    private String estado;
    private String Mensaje;
    private UserEntity usuario;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }
}
