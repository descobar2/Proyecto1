package com.fabrica.poyecto;

import java.util.Scanner;

public class Menu {
    private Scanner entrada = new Scanner(System.in);
    private Integer opcion = 0;
    
    public void mostrarMenu(){
        //Detalle de menu de inicio
        System.out.println("\nFabrica de Muebles");
        System.out.println("1. Realizar una compra");
        System.out.println("2. Realizar una venta");
        System.out.println("3. Crear un producto");
        System.out.println("4. Buscar");
        System.out.println("0. Salir");
    }
    public void menuCompra(){

    }
    public void menuVenta(){

    }
    public void menuProducto(){

    }
    public void menuModificar(){

    }        
    public void menuBuscart(){
        
    }
    public boolean menuValorInvalido(){
        //Se valida opciones invalidas y se solicita nuevo intento al usuario.
        System.out.println("\nValor ingresado es invalido, desea intentar de nuevo: S/N");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = entrada.nextInt();
        if (opcion == 1){
            return true;
        }
    return false;
    }
}
