package com.mycompany.sginventario_v102072026.servlet;

import com.mycompany.sginventario_v102072026.modelo.Usuario;
import com.mycompany.sginventario_v102072026.modelo.servicios.UsuarioService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
    
    private UsuarioService usuarioService;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String nombre = request.getParameter("username");
        String contrasena = request.getParameter("password");
        
        Usuario usuarioVerificado = usuarioService.autenticar(nombre, contrasena);
        
        if(usuarioVerificado != null){
            request.getSession().setAttribute("usuario", usuarioVerificado);
        } else {
            request.setAttribute("error", "No se puedo hacer el logueo");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/login.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    @Override
    public void init(){
        usuarioService = new UsuarioService();
        
    }

}
