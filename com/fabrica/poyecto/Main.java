package com.fabrica.poyecto;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        int opcion=0;
        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();
        Persona persona = new Persona();
        Producto producto = new Producto();
        Material material = new Material();

        menu.mostrarMenu();
        opcion = entrada.nextInt();
        switch(opcion){
            case 1:
                persona.crearCliente();
            break;
            case 2:
                persona.crearProveedor();
            break;
            case 3:
                producto.crearPoducto();
            break;
            case 4:
                material.crearMaterial();
            break;
            default:
            break;
        }
    }
}
