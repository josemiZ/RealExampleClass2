package com.bixspace.realmbasicloginregister.data.entities;

import java.io.Serializable;

/**
 * Created by miguel on 06/02/17.
 */

public class MessageSerializable implements Serializable {
    private String Estado;
    private String Mensaje;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
