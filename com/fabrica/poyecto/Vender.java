package com.fabrica.poyecto;

import java.util.Scanner;

public class Vender implements Operaciones{
    private Scanner scan = new Scanner(System.in);
    private Archivo archivo = new Archivo();
    private String nombre;
    private String cProducto;
    private String cantidad;
    private String producto;
    private String id;
    private int i=3;
    private int valor=0;

    @Override
    public void realizar() {
        System.out.println("Ingrese nombre de producto");                
        nombre = scan.nextLine();
        System.out.println("Ingrese cantidad");
        cProducto = scan.nextLine();
        
        if(archivo.buscarProducto(nombre)){
            producto = archivo.retornarProd(nombre);
            String[] arreglo = producto.split("%");
            while(i<arreglo.length){
                id = arreglo[i];
                i++;
                cantidad = arreglo[i];
                valor = Integer.parseInt(cantidad) * Integer.parseInt(cProducto);
                i++;
                //Hacer llamada a funcion para validar inventario
                if(archivo.retornarDispI(id)>valor){
                    archivo.modificarInventario(id, "" + valor, "resta");
                }else{
                    //Crear funcion para generar un pedido.
                }
            }
        }else{
            System.out.println("No es posible realizar accion. Producto no existe");
        }
    }
}
