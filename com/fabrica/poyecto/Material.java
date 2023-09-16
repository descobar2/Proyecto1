package com.fabrica.poyecto;
import java.util.Scanner;

public class Material {
    private String nombre;
    private String descripcion;
    private String medida;
    private String costo;
    private Archivo archivo = new Archivo();

    public void crearMaterial(){
        archivo.registroMaterial(datoMaterial());
    }
    public String datoMaterial(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese Nombre:");
        nombre = scan.nextLine();
        System.out.println("Ingrese descripcion:");
        descripcion = scan.nextLine();
        System.out.println("Ingrese medida:");
        medida = scan.nextLine();
        System.out.println("Ingrese costo:");
        costo = scan.nextLine();

    return nombre+"%"+descripcion+"%"+medida+"%"+costo;
    }
}
