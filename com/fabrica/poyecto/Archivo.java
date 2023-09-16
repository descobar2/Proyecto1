package com.fabrica.poyecto;
import java.io.*;

public class Archivo {
    private int id;
    private File fCliente = new File ("cliente.txt");
    private File fProveedor = new File ("proveedor.txt");
    private File fMaterial = new File ("material.txt");
    private File fProducto = new File ("producto.txt");
    private File fInventario = new File ("inventario.txt");
    
    public void registroCliente(String cliente){  
        id = contarLineas(fCliente)+1;
        cliente = "C"+id+"%"+cliente;
        registrarDatos(cliente, fCliente);
    }
    public void registroProveedor(String porveedor){
        id = contarLineas(fProveedor)+1;
        porveedor = "P"+id+"%"+porveedor;
        registrarDatos(porveedor, fProveedor);
    }
    public void registroMaterial(String material){
        id = contarLineas(fMaterial)+1;
        material = "M"+id+"%"+material;
        registrarDatos(material, fMaterial);
    }
    public void registroProducto(String producto){
        id = contarLineas(fProducto)+1;
        producto = "P"+id+"%"+producto;
        registrarDatos(producto, fProducto);
    }
    public void registroInventario(String producto){
        registrarDatos(producto, fInventario);
    }

    public void registrarDatos(String datos, File archivo){
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
                while ((br.readLine()) != null) {
                contadorLineas++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contadorLineas;
    }

    public boolean buscarMaterial(String buscar){
        if(buscarRegistro(buscar, fMaterial, 1, 0)==true){
            return true;
        }else{
            return false;
        }
    }
    public boolean buscarProducto(String buscar){
        if(buscarRegistro(buscar, fProducto, 1, 0)==true){
            return true;
        }else{
            return false;
        }        
    }
    public String retoranaIdM(String buscar){
        String id=null;
        try(FileReader fr = new FileReader(fMaterial);
        BufferedReader br = new BufferedReader(fr);){
            String linea;
            while((linea = br.readLine()) !=null){
               String[] arreglo = linea.split("%");
                if(arreglo[1].equalsIgnoreCase(buscar)){
                     id = arreglo[0];
                     break;
                }
            }               
        }catch(Exception e){
            System.out.println("Error E/S: " + e);
        }
        return id;        
    }
    public boolean buscarRegistro(String buscar, File archivo, int campoBusqueda, int campoRetorno){
        boolean existe = false;
        try(FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);){
            String linea;
            while((linea = br.readLine()) !=null){
               String[] arreglo = linea.split("%");
                if(arreglo[campoBusqueda].equalsIgnoreCase(buscar)){
                     existe = true;
                     break;
                }
            }               
        }catch(Exception e){
            System.out.println("Error E/S: " + e);
        }
        return existe;
    }
}

