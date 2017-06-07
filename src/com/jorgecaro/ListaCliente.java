package com.jorgecaro;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jorge Caro on 12/05/2017.
 */
public class ListaCliente {
    public ArrayList<Cliente> clientes = new ArrayList<>();

    public ListaCliente() {
        clientes = new ArrayList<>();
    }

    /**
     * Metodo que crea el cliente
     */
    public void crearCliente() {
        String nombre;
        String apellidos;
        String telefono;
        String correo;
        AreasActuacionCliente areasActuacionCliente;
        int nExpediente;
        Cliente cliente;

        Scanner input = new Scanner(System.in);

        System.out.println("....................................");
        System.out.println("Introduzca nombre del cliente:");
        nombre = input.nextLine();

        System.out.println("Introduzca apellidos del cliente:");
        apellidos = input.nextLine();

        System.out.println("Introduzca telefono del cliente:");
        telefono = input.nextLine();

        while (telefono.length() != 9) { //Bucle para que al introdducir el numero tenga que tener 9 dígitos, si tiene más o menos vuelve a pedir
            System.out.println("El telefono debe tener 9 dígitos");
            System.out.println();
            System.out.println("Introduzca telefono del cliente:");
            telefono = input.nextLine();
        }

        System.out.println("Introduzca el correo del cliente");
        correo = input.nextLine();

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correo);

        if (matcher.find() == true) { //te comprueba si el email ingresado es correcto o no, si no es correcto te vuelve a pedir opcion
            System.out.println("El email ingresado es correcto");
        } else {
            System.out.println("El email ingresado es incorrecto");
            return;
        }

        areasActuacionCliente = areasActuacionCliente(); //llamada al metodo areasActuacionCliente

        try {
            System.out.println("Introduzca nºexpediente del cliente:");
            nExpediente = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Introduzca una opcion correcta.");
            return;
        }
        System.out.println("....................................");

        cliente = new Cliente(nombre, apellidos, telefono, correo, areasActuacionCliente, nExpediente);

        clientes.add(cliente);
    }

    /**
     *Metodo que establece los tipos de area que puede tener un cliente, debe ingresar
     * alguno de ellos
     * @return en caso de no poner otra cosa o nada , te devuelve por defecto VACIO
     */
    public AreasActuacionCliente areasActuacionCliente(){
        Scanner input = new Scanner(System.in);
        String areaIntroducida;

        System.out.println("Introduce Areas de Actuación: Accidente de trafico, Clausula Suelo, Derecho a Familia, Participaciones Preferentes");
        areaIntroducida = input.nextLine();

        if (areaIntroducida.toLowerCase().replace(" ", "").equals("accidentedetrafico")){
            return AreasActuacionCliente.ACCIDENTE_DE_TRAFICO;
        }else if (areaIntroducida.toLowerCase().replace(" ", "").equals("clausulasuelo")){
            return AreasActuacionCliente.CLAUSULA_SUELO;
        }else if (areaIntroducida.toLowerCase().replace(" ", "").equals("derechoafamilia")){
            return AreasActuacionCliente.DERECHO_A_FAMILIA;
        }else if (areaIntroducida.toLowerCase().replace(" ", "").equals("participacionespreferentes")) {
            return AreasActuacionCliente.PARTICIPACIONES_PREFERENTES;
        }else if (areaIntroducida.toLowerCase().replace(" ", "").equals("vacio")) {
            return AreasActuacionCliente.VACIO;
        }
        return AreasActuacionCliente.VACIO;
    }

    /**
     * Metodo que te muestra los clientes
     */
    public void mostrarCliente() {
        Collections.sort(clientes, Cliente.comparadorExp);
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Metodo que te permite borrar el cliente que quieras
     */
    public void borrarCliente() {
        Scanner input = new Scanner(System.in);
        int expedienteClienteBorrar;

        mostrarCliente();

        try {
            System.out.println("Introduzca el expediente del cliente a borrar:");
            expedienteClienteBorrar = input.nextInt();

        }catch (InputMismatchException e) {
            System.out.println("Introduzca una opcion correcta.");
            return;
        }

        eliminarCliente(expedienteClienteBorrar);
    }

    /**
     * Metodo que te elimina el cliente por el expediente
     * @param expedienteClienteBorrar
     */
    public void eliminarCliente(int expedienteClienteBorrar) {
        Iterator<Cliente> itClientes = clientes.iterator();
        while (itClientes.hasNext()) {
            Cliente cliente = itClientes.next();

            if (cliente.getnExpediente() == expedienteClienteBorrar) {
                itClientes.remove();
                System.out.println("El cliente se a borrado correctamente");
                return;
            }
        }
        System.out.println("No se a podido borrar el cliente");
    }

    /**
     * Metodo que te busca el cliente por nombre
     */
    public void buscarCliente() {
        Scanner input = new Scanner(System.in);
        String nombreIntroducido;

        mostrarCliente();

        System.out.println("Introducir el nombre del cliente a buscar:");
        nombreIntroducido = input.nextLine().toLowerCase();
        for (Cliente cliente : clientes){
            if (nombreIntroducido.equals(cliente.getNombre().toLowerCase())) {
                System.out.println(cliente);
            }
        }
        return;
    }

    /**
     * Metodo que te busca a los clientes por area
     */
    public void buscarAreasCliente() {
        Scanner input = new Scanner(System.in);
        String areaIntroducido;

        System.out.println("Introduce Area de Actuación: Accidente de trafico, Clausula Suelo, Derecho a Familia, Participaciones Preferentes");
        areaIntroducido = input.nextLine().toLowerCase();

        for (Cliente cliente : clientes) {

            if (areaIntroducido.toLowerCase().replace(" ", "").equals(cliente.getAreaIntroducida().getAreasActuacionCliente().toLowerCase().replace(" ", ""))) {
                System.out.println(cliente);
            }
        }
        return;
    }

    /**
     * Metodo que te guarda las modificaciones que hayamos hecho en la aplicacion
     * en el archivo Abogado.dat
     */
    public void guardarClientes() {
        try {
            ObjectOutputStream guardarClientes = new ObjectOutputStream(new FileOutputStream("Abogado.dat"));

            guardarClientes.writeObject( clientes );

            guardarClientes.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que te carga todo lo que se haya hecho anteriormente,
     * se saca la informacion del archivo Abogado.dat
     */
    public void cargarClientes() {
        try {
            ObjectInputStream cargarClientes = new ObjectInputStream(new FileInputStream("Abogado.dat"));

            clientes = (ArrayList<Cliente>) cargarClientes.readObject();

            cargarClientes.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

