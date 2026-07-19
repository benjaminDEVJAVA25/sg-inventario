package com.mycompany.sginventario_v102072026.servlet;

import com.mycompany.sginventario_v102072026.modelo.Producto;
import com.mycompany.sginventario_v102072026.modelo.servicios.ProductoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductoServlet extends HttpServlet {

    private ProductoService productos;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String id, nombre, stock, precio;
        Producto producto;
        
        System.out.println("Accion = " + accion);
        switch (accion) {
            case "listar":
                List<Producto> listaProductos = productos.listar();
                request.setAttribute("ListaProductos", listaProductos);
                request.setAttribute("sms", request.getSession().getAttribute("mensaje"));
                request.getSession().removeAttribute("mensaje");
                request.getRequestDispatcher("/vista/productos.jsp")
                        .forward(request, response);
                break;

            case "editar":
                id = request.getParameter("id");
                producto = productos.buscar(Integer.parseInt(id));
                request.setAttribute("producto", producto);
                request.getRequestDispatcher("/vista/editarProducto.jsp").
                        forward(request, response);
                break;

            case "actualizar":
                nombre = request.getParameter("nombre");
                stock = request.getParameter("stock");
                precio = request.getParameter("precio");
                id = request.getParameter("id");

                producto = productos.buscar(Integer.parseInt(id));
                productos.actualizar(producto, nombre, Double.parseDouble(precio), Integer.parseInt(stock));
                response.sendRedirect(request.getContextPath() + "/Product.do?accion=listar");
                break;
            case "eliminar":
                id = request.getParameter("id");
                productos.eliminar(Integer.parseInt(id));
                response.sendRedirect(request.getContextPath() + "/Product.do?accion=listar");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre, precio, stock;

        nombre = request.getParameter("nombre");
        precio = request.getParameter("precio");
        stock = request.getParameter("stock");

        Producto producto = new Producto(nombre, Double.parseDouble(precio), Integer.parseInt(stock));
        boolean agregado = productos.agregar(producto);
        
        if(agregado){
            request.getSession().setAttribute("mensaje", "Producto "+ producto.getNombre() +" agregado correctamente");
        } else {
            request.getSession().setAttribute("mensaje", "Producto "+ producto.getNombre() +" ya existe, imposible agregar");
        }
        
        
        response.sendRedirect(request.getContextPath() + "/Product.do?accion=listar");
    }

    @Override
    public void init() {
        productos = new ProductoService();

    }

}
