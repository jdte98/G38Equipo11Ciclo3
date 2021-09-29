//---------------------------------Función para consultar la lista de clientes------------------------------
var baseurl = "http://localhost:8080/listarproveedores";
function loadproveedores() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseurl, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
			var proveedores = JSON.parse(xmlhttp.responseText);
			var tbltop = "<table class='table tabla'><tr><th>Nit</th><th>Nombre</th><th>Ciudad</th><th>Telefono</th><th>Direccion</th></tr>";
			var main = "";
			for (i = 0; i < proveedores.length; i++) {
				main += "<tr><td>" + proveedores[i].nit_proveedor
						+ "</td><td>" + proveedores[i].nombre_proveedor
						+ "</td><td>" + proveedores[i].ciudad_proveedor
						+ "</td><td>" + proveedores[i].telefono_proveedor
						+ "</td><td>" + proveedores[i].direccion_proveedor + "</td></tr>";
			}
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("proveedoresinfo").innerHTML = tbl;
		}
	};
	xmlhttp.send();
}
window.onload = function() {
	loadproveedores();
}