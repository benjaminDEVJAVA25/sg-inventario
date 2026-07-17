package com.mycompany.sginventario_v102072026.modelo.servicios;

import com.mycompany.sginventario_v102072026.modelo.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductoService {
    
    private HashMap <Integer, Producto> productos;
    private int sigID;

    public ProductoService() {
        productos = new HashMap<>();
        sigID=0;
    }
     
    public void agregar(Producto producto){
        generarCodigo(producto);
        productos.put(producto.getId(), producto);
    };
    public Producto buscar(int id){
        return productos.get(id);
    };
    public void actualizar(Producto producto, String nombre, Double precio, int stock){
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
    };
    public void eliminar(){};
    
    public List<Producto> listar(){
        return new ArrayList<>(productos.values());
    }
    
    private void generarCodigo(Producto producto){
        producto.setId(++sigID);
    }  
}
