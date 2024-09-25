<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Crear Usuario</title>

</head>
<body>
    <h1>Crear un Usuario</h1>
    <form action="crearUsuario" method="post">
      <label for="nombre">Nombre:</label><br>
      <input type="text" name="nombre" id="nombre" required><br>
      <label for="email">Email:</label>
      <input type="email" name="email" id="email" required><br>
      <input type="submit" value="Crear">
    </form>

    <c:if test="${not empty usuario}">
      <h2>!Usuario registrado y creado exitosamente!</h2>
      <p>ID: ${usuario.id}</p>
      <p>Nombre: ${usuario.nombre}</p>
      <p>Email: ${usuario.email}</p>

    </c:if>

</body>
</html>