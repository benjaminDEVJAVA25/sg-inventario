package com.mycompany.sginventario_v102072026.servlet;

import com.mycompany.sginventario_v102072026.modelo.Producto;
import com.mycompany.sginventario_v102072026.modelo.servicios.ProductoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductoServlet extends HttpServlet {
    private ProductoService productos;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Producto> lista = productos.listar();
        request.setAttribute("ListaProductos", lista);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/productos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre, precio, stock;
        
        nombre = request.getParameter("nombre");
        precio = request.getParameter("precio");
        stock = request.getParameter("stock");
        
        Producto producto = new Producto(nombre, Double.parseDouble(precio), Integer.parseInt(stock));
        productos.agregar(producto);
        
        response.sendRedirect(request.getContextPath() + "/Product.do");
    }
    
    
    
    @Override
    public void init(){
        productos = new ProductoService();
        
    }

}
