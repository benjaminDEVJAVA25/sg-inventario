package com.mycompany.sginventario_v102072026.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String nombre = request.getParameter("username");
        String contrasena = request.getParameter("password");
        
        System.out.println(nombre);
        System.out.println(contrasena);
    }

}
