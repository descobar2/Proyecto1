package com.fabrica.poyecto;

import java.util.Scanner;

public class Menu {
    private Scanner entrada = new Scanner(System.in);
    private String opcion;
    
    public void principal(){
        //Detalle de menu de inicio
        System.out.println("\nFabrica de Muebles");
        System.out.println("1. Realizar una compra");
        System.out.println("2. Realizar una venta");
        System.out.println("3. Editar");
        System.out.println("4. Crear");
        System.out.println("5. Bucar");
        System.out.println("0. Salir");
    }
    public void crear(){
        System.out.println("\nMenu Crear");
        System.out.println("1. Nuevo producto");
        System.out.println("2. Nuevo material");
        System.out.println("3. Nuevo proveedor");   
        System.out.println("4. Nuevo cliente");
        System.out.println("5. Regresar");
    }
    public void venta(){
        System.out.println("\nRealizar Venta");
        System.out.println("Ingrese nombre de producto:");
        opcion = entrada.nextLine();
        System.out.println("Ingrese cantidad");
        opcion = entrada.nextLine();
        System.out.println("Ingrese nombre del cliente");
        opcion = entrada.nextLine();
        System.out.println("Se ingreso orden de fabricacion No. 10:");
        System.out.println("Estado: Materiales en bodega");
    }
    public void compra(){
        System.out.println("\nRealizar Compra de material");
        System.out.println("Ingrese nombre de proveedor:");
        opcion = entrada.nextLine();
        System.out.println("Ingrese nombre del material:");
        opcion = entrada.nextLine();
        System.out.println("Ingrese cantidad:");
        opcion = entrada.nextLine();
        System.out.println("Compra ingresada exitosamente.");
    }
    public void editar(){
        System.out.println("\nMenu Editar");
        System.out.println("1. Estado de orden");
        System.out.println("2. Proveedor");
        System.out.println("3. Cliente");   
        System.out.println("4. Regresar");        
        opcion = entrada.nextLine();        
    }
    public void editarEstado(){
        //System.out.println("Editar orden");
        //System.out.println("Ingresar No. de orden:");
        //System.out.println("Actual: Materiales en bodega");

        System.out.println("1. Proceso de corte");
        System.out.println("2. Proceso de ensamble");
        System.out.println("3. Proceso de acabados");
        System.out.println("4. Proceso de entrega");
    }        
    public void buscar(){
        System.out.println("\nMenu Buscar");
        System.out.println("1. Orden de fabricacion");
        System.out.println("2. Proveedor");
        System.out.println("3. Cliente");   
        System.out.println("4. Regresar");        
    }
    public boolean menuSiNo(){
        boolean continuar=true;
        do{
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = entrada.nextLine();

            switch (opcion){
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Valor invalido intente de nuevo: ");
                break;
            }
        }while(continuar);
    return continuar;
    }
}
