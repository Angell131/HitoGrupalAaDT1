<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Recomendaciones</title>
  <%-- CSS materialize--%>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>

<body>

<!--Formulario-->
<h3>Recomendaciones</h3>
<hr>
<h1>Escriba su recomendación</h1>
<form action="Servlet2" method="post" id="form">
  <label  id="formJuego">Juego</label>
  <input type="text" name="game">
  <label  id="formGenero">Género</label>
  <input type="text" name="genre">
  <label  id="formValoracion">Valoración</label>
  <input type="number" name="rating">
  <input type="submit" value="Insertar" name="Enviar" >
</form>
</body>
</html>
