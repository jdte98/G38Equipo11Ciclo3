//---------------------------------Función para consultar la lista de clientes------------------------------
var baseurl = "http://localhost:8080/listarproveedores";
function loadclientes() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseurl, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
			var clientes = JSON.parse(xmlhttp.responseText);
			var tbltop = "<table class='table tabla'><tr><th>Nit</th><th>Nombre</th><th>Ciudad</th><th>Telefono</th><th>Direccion</th></tr>";
			var main = "";
			for (i = 0; i < clientes.length; i++) {
				main += "<tr><td>" + clientes[i].nombre_cliente
						+ "</td><td>" + clientes[i].cedula_cliente
						+ "</td><td>" + clientes[i].email_cliente
						+ "</td><td>" + clientes[i].telefono_cliente + "</td><td>"
						+ clientes[i].direccion_cliente + "</td></tr>";
			}
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("clientesinfo").innerHTML = tbl;
		}
	};
	xmlhttp.send();
}
window.onload = function() {
	loadclientes();
}