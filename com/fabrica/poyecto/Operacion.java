package com.fabrica.poyecto;
import java.io.*;

public class Operacion {
    private File fCliente = new File ("cliente.txt");
    private File fProveedor = new File ("proveedor.txt");
    private File fMaterial = new File ("material.txt");
    private File fProducto = new File ("producto.txt");
    private int id;

    public void registroCliente(String cliente){  
        id = contarLineas(fCliente)+1;
        cliente = "C"+id+"%"+cliente;
        regitrarDatos(cliente, fCliente);
    }
    public void registroProveedor(String porveedor){
        id = contarLineas(fProveedor);
        porveedor = "P"+id+"%"+porveedor;
        regitrarDatos(porveedor, fProveedor);
    }
    public void registroMaterial(String material){
        id = contarLineas(fMaterial);
        
        regitrarDatos(material, fMaterial);
    }
    public void registroProducto(String producto){
        regitrarDatos(producto, fProducto);
    }

    public void regitrarDatos(String datos, File archivo){
        try (FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);){
          
            if(archivo.exists() && (archivo.length() != 0)){
                bw.newLine();
                bw.write(datos);
                System.out.println("Registro exitoso");
            }else{
                fw.write(datos);
                System.out.println("CA: Registro exitoso");
            }
        } catch (Exception e) {
            System.out.println("Error E/S: " + e);
        }
    }
    public int contarLineas(File archivo) {
        int contadorLineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            
            if(archivo.exists() && (archivo.length() != 0)){
                String linea;
                while ((linea = br.readLine()) != null) {
                contadorLineas++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contadorLineas;
    }
}

