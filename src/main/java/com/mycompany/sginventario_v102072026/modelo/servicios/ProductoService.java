package com.mycompany.sginventario_v102072026.modelo.servicios;

import com.mycompany.sginventario_v102072026.modelo.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductoService {

    private HashMap<Integer, Producto> productos;
    private int sigID;

    public ProductoService() {
        productos = new HashMap<>();
        sigID = 0;
    }

    public boolean agregar(Producto producto) {
        String nombre = producto.getNombre();
        boolean existe = existeNombre(nombre);

        if (existe) {
            return false;
        }
        generarCodigo(producto);
        productos.put(producto.getId(), producto);
        return true;

    }

    private boolean existeNombre(String nombre) {
        for (Producto p : productos.values()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    ;
    
    public Producto buscar(int id) {
        return productos.get(id);
    }

    ;
    public void actualizar(Producto producto, String nombre, Double precio, int stock) {
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
    }

    ;
    public void eliminar(int id) {
        productos.remove(id);
    }

    ;
    
    public List<Producto> listar() {
        return new ArrayList<>(productos.values());
    }

    private void generarCodigo(Producto producto) {
        producto.setId(++sigID);
    }
}
