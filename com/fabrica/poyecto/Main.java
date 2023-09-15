package com.fabrica.poyecto;

import java.util.Scanner;

public class Main{


    public static void main(String[] args) {
        int opcion=0;
        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();

        menu.mostrarMenu();
        opcion = entrada.nextInt();
        switch(opcion){
            case 1:
                Persona persona = new Persona();
                persona.crearCliente();
            break;
            case 2:
            break;
            case 3:
            break;
            default:
            break;
        }
    entrada.close();
    }
}
