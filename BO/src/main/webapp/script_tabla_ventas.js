//---------------------------------Función para consultar la lista de usuarios------------------------------
var baseurl = "http://localhost:8080/listarventas";
function loadventas() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseurl, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
			var ventas = JSON.parse(xmlhttp.responseText);
			var tbltop = "<table class='table tabla'><tr><th>Cod.Venta</th><th>C.Cliente</th><th>C.Usuario</th><th>IVA</th><th>T.Venta</th><th>V.Venta</th></tr>";
			var main = "";
			for (i = 0; i < ventas.length; i++) {
				main += "<tr><td>" + ventas[i].codigo_venta
						+ "</td><td>" + ventas[i].cedula_cliente
						+ "</td><td>" + ventas[i].cedula_usuario
						+ "</td><td>" + ventas[i].ivaventa 
						+ "</td><td>" + ventas[i].total_venta
						+ "</td><td>" + ventas[i].valor_venta		 
						+ "</td></tr>";
			}
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("ventasinfo").innerHTML = tbl;
		}
	};
	xmlhttp.send();
}
window.onload = function() {
	loadventas();
}