<!DOCTYPE html>
<html>

<head>
    <link rel="shortcut icon" href="pagelines-brands.svg" />
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>E11 - Ventas</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/8e9e769e03.js" crossorigin="anonymous"></script>

    <!--Mis estilos-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Crimson+Pro" />
    <link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body class="fondo m-2">
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top estilo-head">
            <div class="container-fluid">
                <a class="navbar-brand" href="pagina_inicio.jsp">
                    <h1>E11</h1>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false">
                    <span>
                        <i class="fas fa-chevron-down"></i>
                    </span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                            <a class="nav-link" href="usuarios.jsp">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="clientes.jsp">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="proveedores.jsp">Proveedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="productos.jsp">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ventas.jsp">Ventas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="reportes.jsp">Reportes</a>
                        </li>
                    </ul>
                    <div class="d-flex">
                        <button class="btn bt-inicio-sesion" onclick="window.location.href='index.html'">
                            Cerrar sesión
                        </button>
                    </div>
                </div>
            </div>
        </nav>
    </header>

    <main>
        <div class="container-fluid cont">
            <div class="container-md estilocontainer" align="center">
                <div class="row align-items-center align-middle">
                    <div class="col">
                        <i class="fab fa-pagelines fa-3x"></i>
                    </div>
                    <div class="col">
                        <h1>Ventas</h1>
                    </div>
                    <div class="col">
                        <a class="flecha-volver" href="pagina_inicio.jsp">
                            <i class="fas fa-arrow-left fa-2x"></i>
                        </a>
                    </div>
                </div>
                <br />
                <div class="row align-middle">
                    <!--Mensajes de alerta-->
                    <div id="errorcrearusuario" class="alert errormensaje visually-hidden" role="alert">
                        <span><i class="fas fa-user-times fa-2x"></i></span>
                        El usuario no se ha podido crear
                    </div>
                    <div id="correctocrearusuario" class="alert mensaje-bien visually-hidden" role="alert">
                        <span><i class="fas fa-user-check fa-2x"></i></span>
                        El usuario fue creado con éxito
                    </div>
                </div>
                <br />
                <form action="">
                    <div class="row align-items-center">
                        <div class="col">
                            <h5>Cédula cliente</h5>
                        </div>
                        <div class="col-2 d-grid">

                        </div>
                        <div class="col">
                            <h5>Cliente</h5>
                        </div>
                        <div class="col">
                            <h5>Consec.</h5>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <!--Caja texto cedula del cliente-->
                            <input id="cedula_cliente" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="CÃ©dula Cliente" required />
                        </div>
                        <div class="col-2 d-grid">
                            <!--Boton consultar-->
                            <button id="btn_consultar" class="btn botonnormal" type="button" onclick="" data-bs-toggle="tooltip"
                                data-bs-placement="top" title="Consultar cliente" disabled>
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                        <div class="col">
                            <!--Caja nombre del cliente si existe-->
                            <input id="nombre_usuario_info" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Cliente" readonly />
                        </div>
                        <div class="col">
                            <input type="text" class="form-control shadow-sm cajatexto" placeholder="Consec."
                                readonly />
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row align-items-center">
                        <div class="col">
                            <h5>Cod. Producto</h5>
                        </div>
                        <div class="col-1 d-grid">
                            <h5></h5>
                        </div>
                        <div class="col">
                            <h5>Producto</h5>
                        </div>
                        <div class="col">
                            <h5>Cantidad</h5>
                        </div>
                        <div class="col">
                            <h5>Total Producto</h5>
                        </div>
                    </div>
                    <div class="row align-middle">
                        <div class="col">
                            <input id="cod_producto1" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Cod." required />
                        </div>
                        <div class="col-1 d-grid">
                            <button class="btn botonnormal" type="button" onclick="">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                        <div class="col">
                            <input id="info_producto1" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Producto" readonly />
                        </div>
                        <div class="col">
                            <input id="cantidad_producto1" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Cant." required />
                        </div>
                        <div class="col">
                            <input id="total_producto1" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Total" readonly />
                        </div>
                    </div>
                    <br>
                    <div class="row align-middle">
                        <div class="col">
                            <input id="cod_producto2" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Cod." required />
                        </div>
                        <div class="col-1 d-grid">
                            <button class="btn botonnormal" type="button" onclick="">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                        <div class="col">
                            <input id="info_producto2" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Producto" readonly />
                        </div>
                        <div class="col">
                            <input id="cantidad_producto2" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Cant." required />
                        </div>
                        <div class="col">
                            <input id="total_producto2" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Total" readonly />
                        </div>
                    </div>
                    <br>
                    <div class="row align-middle">
                        <div class="col">
                            <input id="cod_producto3" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Cod." required />
                        </div>
                        <div class="col-1 d-grid">
                            <button class="btn botonnormal" type="button" onclick="">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                        <div class="col">
                            <input id="info_producto3" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Producto" readonly />
                        </div>
                        <div class="col">
                            <input id="cantidad_producto3" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Cant." required />
                        </div>
                        <div class="col">
                            <input id="total_producto3" type="text" class="form-control shadow-sm cajatexto"
                                placeholder="Total" readonly />
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row align-items-center">
                        <div class="col d-grid">
                            <button class="btn botonnormal" type="button" onclick="crear()">
                                <h4>Confirmar</h4>
                            </button>
                        </div>
                        <div class="col-3">
                            <div class="">
                                <h4 class="text-end">Total</h4>
                            </div>
                            <br>
                            <div class="">
                                <h4 class="text-end">Total Iva</h4>
                            </div>
                            <br>
                            <div class="">
                                <h4 class="text-end">Total con Iva</h4>
                            </div>
                        </div>
                        <div class="col align-middle">
                            <div class="">
                                <input id="total_venta" type="text" class="form-control shadow-sm cajatexto"
                                    placeholder="Total" readonly />
                            </div>
                            <br>
                            <div class="">
                                <input id="total_iva" type="text" class="form-control shadow-sm cajatexto"
                                    placeholder="Total Iva" readonly />
                            </div>
                            <br>
                            <div class="">
                                <input id="total_coniva" type="text" class="form-control shadow-sm cajatexto"
                                    placeholder="Total con Iva" readonly />
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>

    <script src="script_ventas.js"></script>
</body>

</html>