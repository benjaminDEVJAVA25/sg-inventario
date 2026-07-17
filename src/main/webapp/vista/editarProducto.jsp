<%@page import="com.mycompany.sginventario_v102072026.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto - Gestión a la Mano</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/StyleEditarProducto.css">
    </head>
    <body>
        <%
            Producto producto = (Producto) request.getAttribute("producto");
        %>
        <!-- Encabezado consistente -->
        <header class="main-header">
            <h1 class="logo">Gestión a la Mano</h1>
        </header>

        <main class="content-container">
            <div class="form-card">
                <h2>Editar Producto</h2>

                <form action="${pageContext.request.contextPath}/Product.do" method="GET">                   
                                        
                    <input type="hidden" name="accion" value="actualizar">
                    
                    <!-- ID oculto necesario para la actualización en BD -->
                    <input type="hidden" name="id" value="<%= producto.getId()%>">

                    <div class="input-group">
                        <label for="nombre">Nombre del Producto</label>
                        <input name="nombre" id="nombre" type="text" value="<%= producto.getNombre()%>" required>
                    </div>

                    <div class="input-group">
                        <label for="precio">Precio</label>
                        <input name="precio" id="precio" type="number" step="0.01" min="0" value="<%= producto.getPrecio()%>" required>
                    </div>

                    <div class="input-group">
                        <label for="stock">Stock Actual</label>
                        <input name="stock" id="stock" type="number" min="0" value="<%= producto.getStock()%>" required>
                    </div>

                    <!-- Grupo de botones alineados horizontalmente -->
                    <div class="button-group-row">
                        <button type="submit" class="btn-submit">Guardar Cambios</button>
                        <a href="${pageContext.request.contextPath}/Product.do?accion=listar" class="btn-cancel">Cancelar</a>
                    </div>
                </form>
            </div>
        </main>
    </body>
</html>
