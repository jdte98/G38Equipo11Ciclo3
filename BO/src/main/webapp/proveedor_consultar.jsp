<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

  <head>
    <link rel="shortcut icon" href="pagelines-brands.svg">
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width">
	  <title>E11 - Consultar proveedor</title>

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

    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top estilo-head">
        <div class="container-fluid">
          <a class="navbar-brand" href="pagina_inicio.jsp">
            <h1>E11</h1>
          </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false">
              <span>
                <i class="fas fa-chevron-down"></i>
              </span>
            </button>
          <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
              <li class="nav-item">
                <a class="nav-link"  href="usuarios.jsp">Usuarios</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="clientes.jsp">Clientes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="proveedores.jsp">Proveedores</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="productos.jsp">Productos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="ventas.jsp">Ventas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="reportes.jsp">Reportes</a>
              </li>
            </ul>
            <div class="d-flex">
              <button class="btn bt-inicio-sesion" onclick="window.location.href='index.html'">Cerrar sesi?n</button>
            </div>
          </div>
        </div>
      </nav>
    </header>

    <main>
      <div class="container-fluid cont">
        <div class="container estilocontainer" align="center">
          <div class="row align-items-center align-middle">
            <div class="col">
              <i class="fab fa-pagelines fa-3x"></i>
            </div>
            <div class="col">
              <h1>Consultar Proveedor</h1>
            </div>
            <div class="col">
              <a class="flecha-volver" href="usuarios.jsp">
                <i class="fas fa-arrow-left fa-2x"></i>
              </a>
            </div>
          </div>
          <br>
          <div class="row">
            <!--Mensajes de alerta para consultar-->
            <div id="mensaje-error-consultar-proveedor" class="alert errormensaje visually-hidden" role="alert">No fue posible encontrar el proveedor</div>
          </div>
          <br>
          <div class="row">
            <div class="col-3"></div>
            <div class="col">
              <!--Caja texto Nit proveedor-->
              <input id="nitproveedor" type="text" class="form-control shadow-sm cajatexto" placeholder="NIT">
            </div>
            <div class="col-3"></div>
          </div>
          <br>
          <div class="row flex-nowrap align-middle">
            <div class="col"></div>
            <div class="col-2 d-grid">
              <button class="btn botonnormal" type="button" onclick="consultar()">
                <i class="fas fa-search"></i>
              </button>
            </div>
            <div class="col"></div>
          </div>
          <br>
          <!-- Datos del proveedor acultos hasta que coincida el NIT y su existencia -->
          <form id="form-info" class="visually-hidden" action="">
            <div class="row align-items-center align-middle">
              <div class="col"></div>
              <div class="col">
                <h4>Datos del Proveedor</h4>
              </div>
              <div class="col"></div>
            </div>
            <div class="row">
              <div class="col-3"></div>
              <div class="col">
                <!--Caja texto con el nit del proveedor deshabilitada-->
                <input id="nit_proveedorinfo" type="text" class="form-control shadow-sm cajatexto" readonly>
              </div>
              <div class="col-3"></div>
            </div> 
            <br>
            <div class="row">
              <div class="col-3"></div>
              <div class="col">
                <!--Caja texto Nombre proveedor deshabilitada-->
                <input id="nombre_proveedorinfo" type="text" class="form-control shadow-sm cajatexto" readonly>
              </div>
              <div class="col-3"></div>
            </div>
            <br>
            <div class="row">
              <div class="col-3"></div>
              <div class="col">
                <!--Caja texto Ciudad proveedor deshabilitada-->
                <input id="ciudad_proveedorinfo" type="email" class="form-control shadow-sm cajatexto" readonly>
              </div>
              <div class="col-3"></div>
            </div>
            <br>
            <div class="row">
              <div class="col-3"></div>
              <div class="col">
                <!--Caja texto telefono deshabilitada-->
                <input id="telefono_proveedorinfo" type="text" class="form-control shadow-sm cajatexto" readonly>
              </div>
              <div class="col-3"></div>
            </div>
            <br>
            <div class="row">
              <div class="col-3"></div>
              <div class="col">
                <!--Caja texto direcci?n deshabilitada-->
                <input id="direccion_proveedorinfo" type="text" class="form-control shadow-sm cajatexto" readonly>
              </div>
              <div class="col-3"></div>
            </div> 
          </form>   
        </div>
      </div>
    </main>

    <script src="script_proveedor_consultar.js"></script>
  </body>
	
</html>