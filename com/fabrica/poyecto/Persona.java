package com.fabrica.poyecto;
import java.util.Scanner;

public class Persona {
    private String cui;
    private String nombre;
    private String direccion;
    Operacion operacion = new Operacion();

    public void crearCliente(){
        operacion.registroCliente(solicitarDatos());       
    }
    public void crearProveedor(){
        operacion.registroProveedor(solicitarDatos());
    }

    public String solicitarDatos(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Ingrese CUI:");
    cui = scan.nextLine();
    System.out.println("Ingrese Nombre:");
    nombre = scan.nextLine();
    System.out.println("Ingrese direccion:");
    direccion = scan.nextLine();

    scan.close();
    return cui+"%"+nombre+"%"+direccion;
    }

}
