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
        System.out.println("3. Crear");
        System.out.println("0. Salir");
    }
    public void menuCrear(){
        System.out.println("\nMenu Crear");
        System.out.println("1. Nuevo producto");
        System.out.println("2. Nuevo material");
        System.out.println("3. Nuevo proveedor");   
        System.out.println("4. Nuevo cliente");
        System.out.println("5. Regresar");
    }
    public void menuVenta(){

    }
    public void menuProducto(){

    }
    public void menuModificar(){

    }        
    public void menuBuscar(){
        
    }
    public boolean menuSiNo(){
        boolean continuar=true;
        do{
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Valor invalido intente de nuevo: ");
                break;
            }
        }while(continuar);
    return continuar;
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
