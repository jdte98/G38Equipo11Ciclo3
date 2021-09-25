<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

  <head>
    <link rel="shortcut icon" href="pagelines-brands.svg">
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width">
	  <title>E11 - Inicio de sesión</title>

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
    
    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top estilo-head">
        <div class="container-fluid">
          <a class="navbar-brand" href="index.html">
            <h1>E11</h1>
          </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false">
              <span>
                <i class="fas fa-chevron-down"></i>
              </span>
            </button>
          <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0"></ul>
            <div class="d-flex">
              <button class="btn bt-inicio-sesion" onclick="window.location.href='login.jsp'">Iniciar sesión</button>
            </div>
          </div>
        </div>
      </nav>
    </header>

    <main>
      <div class="container-fluid cont">
        <div class="container estilocontainer">
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
              <div id="errormensaje" class="alert errormensaje visually-hidden" role="alert">¡Contraseña o usuario incorrecto!</div>
              <div class="col">
                <input id="inputuser" type="text" class="form-control shadow-sm cajatexto" placeholder="Usuario">
              </div>
              <br>        
              <div class="col">
                <input id="inputpass" type="password" class="form-control shadow-sm cajatexto" placeholder="Contraseña">
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
                  <a href="https://github.com/jdte98/G38Equipo11Ciclo3" target="_blank"><i class="fab fa-github fa-2x iconcolor"></i></a>
                </div>
                <div class="col">
                  <a href="https://trello.com/b/n5pfp0fx/grupo-38-equipo-11" target="_blank"><i class="fab fa-trello fa-2x iconcolor"></i></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  
 
  
    
  <script src="script_login.js"></script>
  </body>
	
</html>