<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <title>Crear Producto</title>

</head>
<body>

<h1>Crear un Producto</h1>
<form action="crearProducto" method="post">
    <label for="nombre">Nombre:</label><br>
    <input type="text" name="nombre" id="nombre" required><br>
    <label for="descripcion">Descripcion:</label>
    <input type="text" name="descripcion" id="descripcion" required><br>
    <input type="submit" value="Crear">
</form>

<c:if test="${not empty producto}">
    <h2>!Producto registrado y creado exitosamente!</h2>
    <p>ID: ${producto.id}</p>
    <p>Nombre: ${producto.nombre}</p>
    <p>Descripcion: ${producto.descripcion}</p>

</c:if>

</body>
</html>