<%@ page import="java.util.List" %>
<%@ page import="com.hitogrupalaccesodatos.logica.LogicaBD" %>
<%@ page import="com.hitogrupalaccesodatos.model.Recomendacion" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!--Elementos SEO-->
    <meta charset="UTF-8">
    <meta name="Menu" content="Recomendaciones de juegos">
    <meta name="keywords" content="HTML, CSS, Java, JSP, JPA, Hibernate">
    <meta name="author" content="Angel Lopez y Diego Gomez">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hito Grupal Ángel López y Diego Gómez</title>

    <!--CSS materialize-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!--CSS propio-->
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>

<!--Formulario-->
<h1>Bienvenido a las recomendaciones</h1>
<form action="Servlet" method="post">
    <label  id="formUser">Usuario</label>
    <input type="text" name="user">
    <label  id="formPass">Password</label>
    <input type="password" name="pass">
    <input type="submit" name="Enviar" value="Iniciar sesion">
</form>

<!--Tabla recomendaciones-->
<h2>Recomendaciones</h2>
<hr>
<table id="tabla">
    <tr>
        <th><h4><strong>User</strong></h4></th>
        <th><h4><strong>Juego</strong></h4></th>
        <th><h4><strong>Genero</strong></h4></th>
        <th><h4><strong>Valoracion</strong></h4></th>
    </tr>
    <!--Código java (función allRecomendacion() para mostrar las recomendaciones-->
    <%
        LogicaBD logica = new LogicaBD();
        List<Recomendacion> recomendaciones = logica.allRecomendacion();
        for (Recomendacion p : recomendaciones) {%>
    <tr>
        <td><h6><%= p.getLogin().getId() %></h6></td>
        <td><h6><%= p.getJuego() %></h6></td>
        <td><h6><%= p.getGenero() %></h6></td>
        <td><h6><%= p.getValoracion() %></h6></td>
    </tr>
    <%}%>
</table>

<!--Script materialize -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>