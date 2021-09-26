//Funcion para consultar un usuario
function consultar() {
	var req = new XMLHttpRequest();
	var cedula = document.getElementById("cedula_usuario").value;
	req.open('GET', 'http://localhost:8080/consultarusuario?cedula_usuario='+ cedula, false);
	req.send(null);
	var usuario = null;
	if (req.status == 200) {
		usuario = JSON.parse(req.responseText);
	}
	
	console.log(JSON.parse(req.responseText));
	console.log(usuario.toString());	
	
	if (usuario.toString() != "") {
		//Se agrega la información en cada una de las cajas de texto
		document.getElementById("cedula_usuarioinfo").value = usuario[0].cedula_usuario;
		document.getElementById("nombre_usuarioinfo").value = usuario[0].nombre_usuario;
		document.getElementById("email_usuarioinfo").value = usuario[0].email_usuario;
		document.getElementById("userinfo").value = usuario[0].usuario;
		document.getElementById("passwordinfo").value = usuario[0].password;
		
		//Se vacia la caja de texto para escribir la cedula de nuevo
		document.getElementById("cedula_usuario").value = "";
		//Se oculta el mensaje de error al consultar usuario por que no existe o por otro error
		var element = document.getElementById("mensaje-error-consultar-usuario");
		element.classList.add("visually-hidden");
		//Se visualiza la información del usuario
		var element2 = document.getElementById("form-info");
		element2.classList.remove("visually-hidden");	
	} else {
		//Se vacia la caja de texto para escribir la cedula de nuevo
		document.getElementById("cedula_usuario").value = "";
		//Se visualiza el mensaje de error al consultar usuario por que no existe o por otro error 
		var element = document.getElementById("mensaje-error-consultar-usuario");
		element.classList.remove("visually-hidden");
		//Se oculta la información del usuario
		var element2 = document.getElementById("form-info");
		element2.classList.add("visually-hidden");
		//Vaciamos todas las cajas donde se muestra la información del usuario
		document.getElementById("cedula_usuarioinfo").value = "";
		document.getElementById("nombre_usuarioinfo").value = "";
		document.getElementById("email_usuarioinfo").value = "";
		document.getElementById("userinfo").value = "";
		document.getElementById("passwordinfo").value = "";
	}
	
}