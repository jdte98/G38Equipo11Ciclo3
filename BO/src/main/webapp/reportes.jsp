<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

  <head>
    <link rel="shortcut icon" href="pagelines-brands.svg">
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width">
	  <title>E11 - Reportes</title>

	  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	  crossorigin="anonymous">

	  <script     src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	  crossorigin="anonymous">
	  </script>

	  <script src="https://kit.fontawesome.com/8e9e769e03.js" crossorigin="anonymous">
	  </script>

	  <!--Mis estilos-->
	  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Crimson+Pro">
	  <link href="style.css" rel="stylesheet" type="text/css" />

  </head>

  <body class="fondo m-2">

  <nav class="navbar fixed-top shadow-sm rounded">
    <div class="row align-items-center">
      <div class="col">
        <center>
        <a class="e11" href="pagina_inicio.jsp">
          <h1>E11</h1>
        </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="usuarios.jsp">
            <h6>Usuarios</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="">
            <h6>Clientes</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="">
            <h6>Proveedores</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="">
            <h6>Productos</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="">
            <h6>Ventas</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="reportes.jsp">
            <h6>Reportes</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="index.jsp">
            <h6>Cerrar sesión</h6>
          </a>
        </center>
      </div>
      <div class="col" align="right">
        <button class="darkswitch" ::after id="switch">
          <span><i class="fas fa-sun"></i></span>
          <span><i class="fas fa-moon"></i></span>
        </button>
      </div>
    </div>
  </nav>

  <div class="container position-absolute top-50 start-50 translate-middle shadow-lg estilocontainer" align="center">
    <div class="row align-items-center">
      <div class="col-1">
        <i class="fab fa-pagelines fa-3x"></i>
      </div>
      <div class="col">
        <h1>
          Reportes
        </h1>
      </div>
    </div>
    <br>
    <div class="row justify-content-center">
      <div class="col-1"></div> <!--Caja vacia para centrar el titulo-->
      <div class="col-4 align-self-center">
        <div class="row d-grid">
          <!--Boton Lista de usuarios-->
          <a></a>
          <button class="btn boton1" type="button" onclick="botonListaUsuarios()">Lista de usuarios</button>
        </div>
        <br>
        <div class="row d-grid">
          <!--Boton Lista de clientes-->
          <button class="btn boton1" type="button">Lista de clientes</button>
        </div>
        <br>
        <div class="row d-grid">
          <!--Boton Ventas por Cliente-->
          <button class="btn boton1" type="button">Ventas por cliente</button>
        </div>
      </div>
    </div>
  </div>
  
  
  <!--Script para el modo oscuro-->
  <script src="script_reportes.js"></script>
  </body>
	
</html>