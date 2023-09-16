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
        Comprar comprar = new Comprar();

            do{
            menu.mostrarMenu();
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    comprar.realiazCompra();
                break;
                case 2:
                    // Venta
                break;
                case 3:
                    menu.menuCrear();
                    opcion = entrada.nextInt();
                    switch (opcion){
                        case 1:
                            producto.crearPoducto();
                        break;
                        case 2:
                            material.crearMaterial();
                        break;
                        case 3:
                            persona.crearProveedor();
                        break;
                        case 4:
                            persona.crearCliente();
                        break;
                        case 5:
                        break;
                        default:
                            System.out.println("Valor invalido");
                        break;                                                                
                    }
                break;
                case 4:
                    //Sin uso
                break;
                default:
                break;
            }
        }while(opcion!=0);
        entrada.close();
    }
}
