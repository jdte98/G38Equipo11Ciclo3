<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

  <head>
    <link rel="shortcut icon" href="pagelines-brands.svg">
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width">
	  <title>E11 - Usuarios</title>

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
          <a class="boton-menu" href="#">
            <h6>Clientes</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="#">
            <h6>Proveedores</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="#">
            <h6>Productos</h6>
          </a>
        </center>
      </div>
      <div class="col">
        <center>
          <a class="boton-menu" href="#">
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
    <div class="row align-middle">
      <div class="col-1">
        <i class="fab fa-pagelines fa-3x"></i>
      </div>
      <div class="col">
        <h1>Usuarios</h1>
      </div>
    </div>
    <br>
    <!-- Mensajes de alerta -->
    <div class="row">
      <!--Mensajes de alerta para consultar-->
      <div class="alert errormensaje visually-hidden" role="alert">No fue posible encontrar el usuario</div>
      <!--Mensajes de alerta para crear-->
      <div id="errorcrearusuario" class="alert errormensaje visually-hidden" role="alert">No fue posible crear el usuario</div>
      <div id="correctocrearusuario" class="alert mensaje-bien visually-hidden" role="alert">El usuario fue creado con exito</div>
      <!--Mensajes de alerta para Actualizar-->
      <div class="alert errormensaje visually-hidden" role="alert">No fue posible actualizar el usuario</div>
      <div class="alert mensaje-bien visually-hidden" role="alert">El usuario fue actualizado con exito</div>
      <!--Mensajes de alerta para Borrar-->
      <div class="alert errormensaje visually-hidden" role="alert">No fue posible borrar el usuario</div>
      <div class="alert mensaje-bien visually-hidden" role="alert">El usuario fue borrado con exito</div>
    </div>
    <br>
    <form id="form" action="">
    <!-- Usuario y boton Consultar -->
    <div class="row">
      <div class="col-1"></div>
      <div class="col">
        <!--Caja texto usuario-->
        <input id="user" type="text" class="form-control shadow-sm cajatexto" placeholder="Usuario">
      </div>
      <div class="col-3 d-grid">
        <!--Boton Consultar-->
        <button class="btn boton1" type="button">Consultar</button>
      </div>
    </div>
    <br>
    <!-- Contraseña y boton Crear -->
    <div class="row">
      <div class="col-1"></div>
      <div class="col">
        <!--Caja texto contraseña-->
        <input id="password" type="password" class="form-control shadow-sm cajatexto" placeholder="Contraseña" autocomplete>
      </div>
      <div class="col-3 d-grid">
        <!--Boton crear-->
        <button class="btn boton1" type="button" onclick="crear()" >Crear</button>
      </div>
    </div>
    <br>
    <!-- Nombre Completo y boton Actualizar -->
    <div class="row">
      <div class="col-1"></div>
      <div class="col">
        <!--Caja texto Nombre completo-->
        <input id="nombre_usuario" type="text" class="form-control shadow-sm cajatexto" placeholder="Nombre completo">
      </div>
      <div class="col-3 d-grid">
        <!--Boton Actualizar-->
        <button class="btn boton1" type="button">Actualizar</button>
      </div>
    </div>
    <br>
    <!-- Cédula y boton Borrar -->
    <div class="row">
      <div class="col-1"></div>
      <div class="col">
        <!--Caja texto cedula-->
        <input id="cedula_usuario" type="text" class="form-control shadow-sm cajatexto" placeholder="Cédula">
      </div>
      <div class="col-3 d-grid">
        <!--Boton Borrar-->
        <button class="btn boton1" type="button">Borrar</button>
      </div>
    </div>
    <br>
    <!-- Correo y espacio libre -->
    <div class="row">
      <div class="col-1"></div>
      <div class="col">
        <!--Caja texto correo-->
        <input id="email_usuario" type="email" class="form-control shadow-sm cajatexto" placeholder="Correo">
      </div>
      <div class="col-3 d-grid">
      </div>  
    </div>
  	</form>
  </div>
  
  
  <!--Script para el modo oscuro-->
  <script src="script_usuario.js"></script>
  </body>
	
</html>