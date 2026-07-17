<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/StyleProductos.css"/>
    </head>
    <body>
        <% if (session.getAttribute("usuario") == null) {
                response.sendRedirect(request.getContextPath() + "/vista/login.jsp");
                return;
            }
        %>
        <header class="main-header">
            <h1 class="logo">Gestión a la Mano</h1>
            <nav class="navbar">
                <!-- Enlace estilizado como botón para añadir productos -->
                <a href="${pageContext.request.contextPath}/vista/nuevoProducto.jsp" class="btn-create">+ Nuevo Producto</a>
            </nav>
        </header>
        <main class="content-container">
            <div class="table-card">
                <h2 class="section-title">Lista de Productos</h2>
                <c:if test="${not empty ListaProductos}">
                    <div class="table-responsive">
                        <table class="custom-table">
                            <tr>
                                <th>Nombre del Producto</th>
                                <th>Precio</th>
                                <th>Stock / Disponibilidad</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                            <tbody>
                                <c:forEach items="${ListaProductos}" var="producto">
                                    <tr>
                                        <td class="product-name">${producto.nombre}</td>
                                        <td class="product-price">$${producto.precio}</td>
                                        <td>
                                            <!-- Un pequeño condicional visual por si el stock se agota -->
                                            <span class="badge-stock ${producto.stock <= 5 ? 'stock-low' : 'stock-ok'}">
                                                ${producto.stock} unidades
                                            </span>
                                        </td>
                                        <td class="text-center">
                                            <!-- Botón de Editar Estilizado -->
                                            <a href="${pageContext.request.contextPath}/Product.do?accion=editar&id=${producto.id}" class="btn-edit-action">
                                                Editar
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </c:if>
            </div>
        </main>
    </body>
</html>
