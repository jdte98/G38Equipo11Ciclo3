function subirArchivo() {	
	try {
		var csvFile = document.getElementById("archivo");

		var input = csvFile.files[0];
		var reader = new FileReader();

		reader.onload = function(e) {

			var text = e.target.result;

			var arrayLineas = text.split("\n");

			var xhr = new XMLHttpRequest();
			xhr.open("DELETE", "http://localhost:8080/eliminartodoproducto",true);
			xhr.send();

			for (var i = 0; i < arrayLineas.length; i += 1) {
				var arraydatos = arrayLineas[i].split(",");

				if (arrayLineas[i] == "") {
					continue;
				}

				for (var j = 0; j < arraydatos.length; j += 1) {
					console.log(i + " " + j + "->" + arraydatos[j]);
				}

				var formData = new FormData();
				formData.append("codigo_producto", arraydatos[0]);
				formData.append("nombre_producto", arraydatos[1]);
				formData.append("nitproveedor", arraydatos[2]);
				formData.append("precio_compra", arraydatos[3]);
				formData.append("iva_compra", arraydatos[4]);
				formData.append("precio_venta", arraydatos[5]);
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "http://localhost:8080/registrarproducto");

				xhr.send(formData);
				}

			var element = document.getElementById("mensaje-error-archivo");
			element.classList.add("visually-hidden");
			var element2 = document.getElementById("mensaje-bien-archivo");
			element2.classList.remove("visually-hidden");
			var element3 = document.getElementById("verTabla");
			element3.classList.remove("visually-hidden");

			document.getElementById("archivo").value = "";
		};

		reader.readAsText(input);
	} catch (error) {
		
		var element = document.getElementById("mensaje-error-archivo");
		element.classList.remove("visually-hidden");
		var element2 = document.getElementById("mensaje-bien-archivo");
		element2.classList.add("visually-hidden");

		document.getElementById("archivo").value = "";
	}
}

//funcion para mostrar tabla de productos
var baseurl = "http://localhost:8080/listarproductos";
function cargarTabla(){
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseurl, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
			var productos = JSON.parse(xmlhttp.responseText);
			var tbltop = "<table class='table tabla'><tr><th>Codigo</th><th>IVA</th><th>NIT Proveedor</th><th>Producto</th><th>Precio compra</th></tr><th>Precio venta</th></tr>";
			var main = "";
			for (i = 0; i < productos.length; i++) {
				main += "<tr><td>" + productos[i].codigo_producto
						+ "</td><td>" + productos[i].iva_compra + " %"
						+ "</td><td>" + productos[i].nitproveedor
						+ "</td><td>" + productos[i].nombre_producto
						+ "</td><td>" + productos[i].precio_compra
						+ "</td><td>" + productos[i].precio_venta + "</td></tr>";
			}
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("tablaProductos").innerHTML = tbl;
		}
	};
	xmlhttp.send();
}
window.onload = function() {
	cargarTabla();
}

//Funcion boton para ver tabla
function verTabla(){
	var element = document.getElementById("tablaProductos");
	element.classList.remove("visually-hidden");
	var element1 = document.getElementById("verTabla");
	element1.classList.add("visually-hidden");
	var element2 = document.getElementById("ocultarTabla");
	element2.classList.remove("visually-hidden");
	var element3 = document.getElementById("mensaje-bien-archivo");
	element3.classList.add("visually-hidden");
}

//Funcion boton para ocultar tabla
function ocultarTabla(){
	var element = document.getElementById("tablaProductos");
	element.classList.add("visually-hidden");
	var element1 = document.getElementById("verTabla");
	element1.classList.remove("visually-hidden");
	var element2 = document.getElementById("ocultarTabla");
	element2.classList.add("visually-hidden");
}





