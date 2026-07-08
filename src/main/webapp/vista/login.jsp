<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/styleLogin.css">
</head>
<body>

    <div class="login-box">
        <h2>Iniciar Sesión</h2>
        
        <form action="../Login.do" method="POST">
            <div class="input-group">
                <label for="username">Usuario</label>
                <input type="text" id="username" name="username">
            </div>
            
            <div class="input-group">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" >
            </div>
            
            <input type="submit" class="btn-submit">
        </form>
    </div>

</body>
</html>
