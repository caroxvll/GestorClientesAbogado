package com.jorgecaro;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Jorge Caro on 11/05/2017.
 */
public class Cliente implements Serializable {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private AreasActuacionCliente areasActuacionCliente;
    private int nExpediente;

    //Constructores

    //Constructor por defecto

    public Cliente(){

    }

    //Constructor

    /**
     * Este constructor tiene todos los atributos de Cliente
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param correo
     * @param areasActualizacionesCliente
     * @param nExpediente
     */

    public Cliente(String nombre, String apellidos, String telefono, String correo, AreasActuacionCliente areasActualizacionesCliente, int nExpediente) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.areasActuacionCliente = areasActualizacionesCliente;
        this.nExpediente = nExpediente;
    }

    //Getter y Setter

    /**
     * Getter y Setter
     * Nos permite asignar un valor si lo deseamos(Setters) y obtener el valor ya asignado a un atributo y utilizarlo
     * para cierto método (Getters)
     * @return devuelve el valor
     */


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public AreasActuacionCliente getAreaIntroducida() {
        return areasActuacionCliente;
    }

    public void setAreaIntroducida(AreasActuacionCliente areasActuacionCliente) {
        this.areasActuacionCliente = areasActuacionCliente;
    }

    public int getnExpediente() {
        return nExpediente;
    }

    public void setnExpediente(int nExpediente) {
        this.nExpediente = nExpediente;
    }

    /**
     *toString imprime todos los datos que tiene el cliente
     *
     * @return devuelve todos los datos del cliente
     */

    @Override
    public String toString() {
        return "Cliente:" +
                "NEXP: " + nExpediente + '\n' +
                " Nombre= " + nombre + '\n' +
                " Apellidos= " + apellidos + '\n' +
                " Telefono= " + telefono + '\n' +
                " Correo= " + correo + '\n' +
                " Area= " + areasActuacionCliente + '\n' +
                '}';
    }

    /**
     * Metodo que compara a los clientes por su numero de expediente y
     * te los ordena de menor a mayor
     */

    public static Comparator<Cliente> comparadorExp = new Comparator<Cliente>() {
        @Override
        public int compare(Cliente cliente1, Cliente cliente2) {
            return cliente1.getnExpediente() - cliente2.getnExpediente();
        }
    };
}

