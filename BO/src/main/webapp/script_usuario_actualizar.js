//Boton para verificar que el usuario existe
function verificarUser(){
	var x = document.getElementById("cedula_usuario").value;
	var req = new XMLHttpRequest();
	var coincidencia = false;
	req.open('GET', 'http://localhost:8080/listarusuarios', false);
	req.send(null);
	var usuarios = null;
	if (req.status == 200){
		usuarios = JSON.parse(req.responseText);
		console.log(JSON.parse(req.responseText));
	}
	for (i = 0; i < usuarios.length; i++){
		console.log(usuarios[i].cedula_usuario);
		if (usuarios[i].cedula_usuario == x){
			console.log(usuarios[i].cedula_usuario + " " + x);
			coincidencia = true;
			break;
		}
	}
	console.log(coincidencia);
	
	if (coincidencia == true) {
		//Visualizar el formulario para editar el usuario
		var element = document.getElementById("form-actualizar");
		element.classList.remove("visually-hidden");
		//Ocultar el mensaje de usuario actualizado
		var element2 = document.getElementById("mensaje-bien-usuario-actualizado");
		element2.classList.add("visually-hidden");
		//Ocultar el mensaje de error al buscar el usuario
		var element3 = document.getElementById("mensaje-error-coincidencia-cedula");
		element3.classList.add("visually-hidden")
		//agregar el numero de cedula en una caja de texto que no se puede editar
		document.getElementById("cedula_usuariobien").value = document.getElementById("cedula_usuario").value;
		
	} else {
		//Visualizar el mensaje de error al buscar el usuario
		var element = document.getElementById("mensaje-error-coincidencia-cedula");
		element.classList.remove("visually-hidden");
		//ocultar el formulario para editar los datos si vuelve a escribir una cedula luego de haber escrito una correcta
		var element2 = document.getElementById("form-actualizar");
		element2.classList.add("visually-hidden");
		//Vaciar la caja de cedula que escribio erroneamente o no se encontro
		document.getElementById("cedula_usuario").value = "";
	}
}

//Boton para actualizar el usuario
function actualizar() {
	var formData = new FormData();
	formData.append("cedula_usuario", document.getElementById("cedula_usuariobien").value);
	formData.append("nombre_usuario", document.getElementById("nombre_usuario").value);
	formData.append("email_usuario", document.getElementById("email_usuario").value);	
	formData.append("usuario", document.getElementById("user").value);
	formData.append("password", document.getElementById("password").value);
	var xhr = new XMLHttpRequest();
	xhr.open("PUT", "http://localhost:8080/actualizarusuarios");
	
	//Luego de enviar los datos ocultamos de nuevo el form y se visualiza el mensaje de usuario creado con exito
	var element = document.getElementById("form-actualizar");
	element.classList.add("visually-hidden");
	var element2 = document.getElementById("mensaje-bien-usuario-actualizado");
	element2.classList.remove("visually-hidden");
	document.getElementById("cedula_usuario").value = "";
	
	//volvemos vacias las cajas de texto del formulario
	document.getElementById("cedula_usuariobien").value = "";
	document.getElementById("nombre_usuario").value = "";
	document.getElementById("email_usuario").value = "";
	document.getElementById("user").value = "";
	document.getElementById("password").value = "";
	
	xhr.send(formData);
	
}
