package com.fabrica.poyecto;
import java.util.Scanner;

public class Persona {
    private String cui;
    private String nombre;
    private String direccion;
    private Archivo archivo = new Archivo();

    public void crearCliente(){
        archivo.registroCliente(solicitarDatos());       
    }
    public void crearProveedor(){
        archivo.registroProveedor(solicitarDatos());
    }

    private String solicitarDatos(){
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
