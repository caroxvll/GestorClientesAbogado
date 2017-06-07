package com.jorgecaro;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Jorge Caro on 11/05/2017.
 */
public class App {
    ListaCliente listaCliente = new ListaCliente();

    public App (){
        listaCliente.cargarClientes();
    }

    /**
     * Metodo que inicia el programa llamando a Menu,
     * en este metodo te permite elegir las diferentes opciones
     */
    public void run(){
        int option;

        while ((option = Menu())!=6){
            Scanner input = new Scanner(System.in);
            switch (option){
                case 1:
                    listaCliente.crearCliente();
                    break;
                case 2:
                    listaCliente.mostrarCliente();
                    break;
                case 3:
                    listaCliente.borrarCliente();
                    break;
                case 4:
                    listaCliente.buscarCliente();
                    break;
                case 5:
                    listaCliente.buscarAreasCliente();
                default:
                    break;
            }
        }
        listaCliente.guardarClientes();
    }
    public int Menu(){
        int opcion;
        Scanner input = new Scanner(System.in);

        System.out.println("...............................");
        System.out.println(".Portero&Peña // Abogados     .");
        System.out.println("...............................");
        System.out.println(".1- Añadir Cliente            .");
        System.out.println(".2- Mostrar Clientes          .");
        System.out.println(".3- Eliminar Cliente          .");
        System.out.println(".4- Buscar Cliente            .");
        System.out.println(".5- Mostrar clientes por Area .");
        System.out.println(".6- Salir                     .");
        System.out.println("...............................");
        System.out.println();
        System.out.print("Opcion: ");
        System.out.println();

        try {
            opcion = input.nextInt();
            return opcion;
        } catch (InputMismatchException e) {
            System.out.println("Introduzca una opcion correcta.");
        }
        return Menu();
    }
}

