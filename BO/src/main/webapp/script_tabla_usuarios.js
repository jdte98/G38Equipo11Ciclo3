//---------------------------------Función para consultar la lista de usuarios------------------------------
var baseurl = "http://localhost:8080/listarusuarios";
function loadusuarios() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseurl, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
			var usuarios = JSON.parse(xmlhttp.responseText);
			var tbltop = "<table class='table tabla'><tr><th>Cedula</th><th>Correo</th><th>Nombre</th><th>Password</th><th>Usuario</th></tr>";
			var main = "";
			for (i = 0; i < usuarios.length; i++) {
				main += "<tr><td>" + usuarios[i].cedula_usuario
						+ "</td><td>" + usuarios[i].email_usuario
						+ "</td><td>" + usuarios[i].nombre_usuario
						+ "</td><td>" + usuarios[i].password + "</td><td>"
						+ usuarios[i].usuario + "</td></tr>";
			}
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("usuariosinfo").innerHTML = tbl;
		}
	};
	xmlhttp.send();
}
window.onload = function() {
	loadusuarios();
}