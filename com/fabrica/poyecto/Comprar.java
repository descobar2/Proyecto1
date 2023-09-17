package com.fabrica.poyecto;

import java.util.Scanner;

public class Comprar implements Operaciones{
    private String id;
    private String nombre;
    private String cantidad;
    private Scanner scan = new Scanner(System.in);
    private Archivo archivo = new Archivo();

    @Override
    public void realizar() {
        System.out.println("Ingrese producto de compra:");
        nombre = scan.nextLine();
        if(archivo.buscarMaterial(nombre)){
            if(archivo.buscarInventario(nombre)){
                //funcion agregar material
            }else{
                System.out.println("Ingrese cantidad:");
                cantidad = scan.nextLine();
                id = archivo.retoranaIdM(nombre);
                archivo.registroInventario(id + "%" + cantidad);
            }
            
        }else{
            System.out.println("No es posible realizar accion. Producto no existe.");
        }

    }
    
}
