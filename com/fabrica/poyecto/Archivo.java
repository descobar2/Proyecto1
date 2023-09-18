package com.fabrica.poyecto;
import java.io.*;

public class Archivo {
    private int id;
    private String producto;
    private File fCliente = new File ("cliente.txt");
    private File fProveedor = new File ("proveedor.txt");
    private File fMaterial = new File ("material.txt");
    private File fProducto = new File ("producto.txt");
    private File fInventario = new File ("inventario.txt");
    
    public void registroCliente(String cliente){  
        id = contarLineas(fCliente)+1;
        cliente = "C"+id+"%"+cliente;
        registrarDatos(cliente, fCliente);
        System.out.println("Registro exitoso.");
    }
    public void registroProveedor(String porveedor){
        id = contarLineas(fProveedor)+1;
        porveedor = "P"+id+"%"+porveedor;
        registrarDatos(porveedor, fProveedor);
        System.out.println("Registro exitoso.");        
    }
    public void registroMaterial(String material){
        id = contarLineas(fMaterial)+1;
        material = "M"+id+"%"+material;
        registrarDatos(material, fMaterial);
        System.out.println("Registro exitoso.");
    }
    public void registroProducto(String producto){
        id = contarLineas(fProducto)+1;
        producto = "P"+id+"%"+producto;
        registrarDatos(producto, fProducto);
        System.out.println("Registro exitoso.");
    }
    public void registroInventario(String producto){
        registrarDatos(producto, fInventario);
        System.out.println("Registro exitoso.");
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
    public boolean buscarInventario(String buscar){
        if(buscarRegistro(retoranaIdM(buscar), fInventario, 0, 1)==true){
            return true;
        }else{
            return false;
        }
    }
    public boolean modificarInventario(String buscar, String nuevoValor, String operacion){
        if(modificarRegistro(buscar, fInventario, 0, 1, nuevoValor, operacion)==true){
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
    public String retornarProd(String buscar){
        try(FileReader fr = new FileReader(fProducto);
        BufferedReader br = new BufferedReader(fr);){
            String linea;
            while((linea = br.readLine()) !=null){
               String[] arreglo = linea.split("%");
                if(arreglo[1].equalsIgnoreCase(buscar)){
                    producto = linea;
                     break;
                }
            }               
        }catch(Exception e){
            System.out.println("Error E/S: " + e);
        }        
        return producto;
    }
    public int retornarDispI(String buscar){
        int valor=0;
        try(FileReader fr = new FileReader(fInventario);
        BufferedReader br = new BufferedReader(fr);){
            String linea;
            while((linea = br.readLine()) !=null){
               String[] arreglo = linea.split("%");
                if(arreglo[0].equalsIgnoreCase(buscar)){
                    valor = Integer.parseInt(arreglo[1]);
                     break;
                }
            }               
        }catch(Exception e){
            System.out.println("Error E/S: " + e);
        }        
        return valor;
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
    public boolean modificarRegistro(String buscar, File archivo, int campoBusqueda, int campoAModificar, String valorNuevo, String oparacion){
        boolean cambio = false;
        String campo;
        int valor=0;
        try {FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
            String linea;
            int numeroLineas = 0;
            int i=0;
            while((linea = br.readLine())!=null){
                numeroLineas++;
            }
            br.close(); fr.close();
            br = new BufferedReader(new FileReader(archivo));
            String[] registro= new String[numeroLineas];
            while((linea = br.readLine()) != null){
                String[] arreglo = linea.split("%");
                if(arreglo[campoBusqueda].equalsIgnoreCase(buscar)){
                    campo = arreglo[campoAModificar];
                    if(oparacion=="suma"){
                        valor = Integer.parseInt(campo)+Integer.parseInt(valorNuevo);
                    }
                    if(oparacion=="resta"){
                        valor = Integer.parseInt(campo)-Integer.parseInt(valorNuevo);
                    }
                    campo = "" + valor;
                    arreglo[campoAModificar]= campo;
                    linea ="";
                    for(int j = 0; j<arreglo.length; j++){
                        if (j == 0){
                            linea = arreglo[j];
                        }else{
                            linea = linea + "%" + arreglo[j];
                        }
                    } 
                    cambio = true;                       
                }
                registro[i] = linea;
                i++;
            }
            br.close(); fr.close();
            eliminaArchivo(archivo);
            for (int n = 0; n < i; n++){
                linea = registro[n];
                registrarDatos(linea, archivo);
            }
        }catch(Exception e){
            System.out.println("Error E/S: " + e);
        }
        return cambio;
    }
    public void registrarDatos(String datos, File archivo){
        try (FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);){
          
            if(archivo.exists() && (archivo.length() != 0)){
                bw.newLine();
                bw.write(datos);
            }else{
                fw.write(datos);
            }
        } catch (Exception e) {
            System.out.println("Error E/S: " + e);
        }   
    }
    public void eliminaArchivo(File archivo){
        try (FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);){
                archivo.delete();
        } catch (Exception e) {
            System.out.println("Error E/S: " + e);
        }   
    }    
}

