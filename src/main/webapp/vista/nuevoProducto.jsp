<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/StyleNuevoProducto.css"/>
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
                <a href="${pageContext.request.contextPath}/vista/productos.jsp" class="btn-back">← Volver a Productos</a>
            </nav>
        </header>
        <main class="content-container">
            <div class="form-card">
                <h2>Registrar Nuevo Producto</h2>
                <form action="${pageContext.request.contextPath}/Product.do" method="POST">
                    <div class="input-group">
                        <label for="nombre">Nombre del Producto</label>
                        <input name="nombre" id="nombre" type="text" placeholder="Ej. Computador Portátil" required>
                    </div>

                    <div class="input-group">
                        <label for="precio">Precio</label>
                        <input name="precio" id="precio" type="number" step="0.01" min="0" placeholder="0.00" required>
                    </div>

                    <div class="input-group">
                        <label for="stock">Stock Inicial</label>
                        <input name="stock" id="stock" type="number" min="0" placeholder="Ej. 10" required>
                    </div>

                    <button type="submit" name="Guardar" class="btn-submit">Guardar Producto</button>
                </form>
            </div>
        </main>
    </body>
</html>
