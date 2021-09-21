<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

  <head>
    <link rel="shortcut icon" href="pagelines-brands.svg">
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width">
	  <title>E11</title>

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

  <body class="fondo">
    
  <nav class="navbar fixed-top shadow-sm rounded">
    <div class="row align-items-center">
    <div class="col">
      <center>
      <a class="e11" href="#">
        <h1>E11</h1>
      </a>
      </center>
    </div>
    <div class="col">
    <button class="darkswitch" ::after id="switch">
      <span><i class="fas fa-sun"></i></span>
      <span><i class="fas fa-moon"></i></span>
    </button>
    </div>
    </div>
  </nav>
  
  <div class="container position-absolute top-50 start-50 translate-middle shadow-lg estilocontainer">
    <div class="row align-items-center">
      <div class="col" align="center">
        <i class="fab fa-pagelines fa-10x"></i>
      </div>
      <div class="col" align="center">
        <br>
        <div>
          <h1>
            Inicio de sesión
          </h1>
        </div>
        <br>
        <br>
        <div id="error" class="alert errormensaje visually-hidden" role="alert">
          ¡Contraseña o usuario incorrecto!
        </div>
        <div class="col-sm">
          <input type="text" class="form-control shadow-sm cajatexto" placeholder="Usuario" id="inputuser">
        </div>
        <br>        
        <div class="col-sm">
          <input type="password" class="form-control shadow-sm cajatexto" placeholder="Contraseña" id="inputpass">
        </div>
        <br>
        <div class="col-5 d-grid">
          <button class="btn boton1" type="button" onclick="comparar()">Iniciar sesión</button>
        </div>
        <br>
        <br>
        <br>
        <div class="row">
          <div class="col">
            <a href="https://www.facebook.com/?_rdr" target="_blank"><i class="fab fa-facebook fa-2x iconcolor"></i></a>
          </div>
          <div class="col">
            <a href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-2x iconcolor"></i></a>
          </div>
          <div class="col">
           <a href="https://web.whatsapp.com/" target="_blank"><i class="fab fa-whatsapp fa-2x iconcolor"></i></a>
          </div>
        </div>
      </div>
    </div>
  </div>
    
  <script src="script_login.js"></script>
  
  </body>
	
</html>