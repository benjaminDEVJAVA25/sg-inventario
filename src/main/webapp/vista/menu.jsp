<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu - Gestion a la Mano</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/StyleMenu.css"/>
    </head>
    <body>      
        <% if (session.getAttribute("usuario") == null) {
                response.sendRedirect(request.getContextPath() + "/vista/login.jsp");
                return;
            }
        %>
        <header class="main-header">
            <h1 class="logo">Gestión a la mano</h1>
            <nav class="navbar">
                <div class="nav-links">
                    <a href="#">Productos</a>
                    <a href="#">Ventas</a>
                    <a href="#">Usuarios</a>
                </div>
                <form action="../Logout.do" method="POST" class="logout-form">
                    <button type="submit" class="btn-logout">Cerrar sesión</button>
                </form>
            </nav>
        </header>
        <main class="content-container">
            <div class="welcome-card">
                <h2>¡Hola de nuevo!</h2>
                <p class="user-info">Bienvenido, <strong>${sessionScope.usuario.username}</strong></p>
                <span class="badge-role">Rol: ${sessionScope.usuario.rol}</span>
            </div>
        </main>
    </body>
</html>
