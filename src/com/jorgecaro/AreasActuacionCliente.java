package com.jorgecaro;

/**
 * Created by Jorge Caro on 26/05/2017.
 * Clase con todos los tipos de areas que puede tener un cliente
 */
public enum AreasActuacionCliente {
    ACCIDENTE_DE_TRAFICO("accidente de trafico"),
    CLAUSULA_SUELO("clausula suelo"),
    DERECHO_A_FAMILIA("derecho a familia"),
    PARTICIPACIONES_PREFERENTES("participaciones preferentes"),
    VACIO("vacio");

    private final String areasActuacionCliente;

    AreasActuacionCliente(String areasActuacionCliente){
        this.areasActuacionCliente = areasActuacionCliente;
    }

    public String getAreasActuacionCliente() {
        return areasActuacionCliente;
    }
}
