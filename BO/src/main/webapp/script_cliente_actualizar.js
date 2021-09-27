//Boton para verificar que el cliente existe
function verificarClientes(){
	var x = document.getElementById("cedula_cliente").value;
	var req = new XMLHttpRequest();
	var coincidencia = false;
	req.open('GET', 'http://localhost:8080/listarclientes', false);
	req.send(null);
	var clientes = null;
	if (req.status == 200){
		clientes = JSON.parse(req.responseText);
		console.log(JSON.parse(req.responseText));
	}
	for (i = 0; i < clientes.length; i++){
		console.log(clientes[i].cedula_cliente);
		if (clientes[i].cedula_cliente == x){
			console.log(clientes[i].cedula_cliente + " " + x);
			coincidencia = true;
			break;
		}
	}
	console.log(coincidencia);
	
	if (coincidencia == true) {
		//Visualizar el formulario para editar el cliente
		var element = document.getElementById("form-actualizar");
		element.classList.remove("visually-hidden");
		//Ocultar el mensaje de cliente actualizado
		var element2 = document.getElementById("mensaje-bien-cliente-actualizado");
		element2.classList.add("visually-hidden");
		//Ocultar el mensaje de error al buscar el cliente
		var element3 = document.getElementById("mensaje-error-coincidencia-cedula");
		element3.classList.add("visually-hidden")
		//agregar el numero de cedula en una caja de texto que no se puede editar
		document.getElementById("cedula_clientebien").value = document.getElementById("cedula_cliente").value;
		//vaciar la caja de texto de cedula
		document.getElementById("cedula_cliente").value = "";
		
	} else {
		//Visualizar el mensaje de error al buscar el cliente
		var element = document.getElementById("mensaje-error-coincidencia-cedula");
		element.classList.remove("visually-hidden");
		//ocultar el formulario para editar los datos si vuelve a escribir una cedula luego de haber escrito una correcta
		var element2 = document.getElementById("form-actualizar");
		element2.classList.add("visually-hidden");
		//Vaciar la caja de cedula que escribio erroneamente o no se encontro
		document.getElementById("cedula_cliente").value = "";
	}
}

//Boton para actualizar el cliente
function actualizar() {
	var formData = new FormData();
	formData.append("cedula_cliente", document.getElementById("cedula_clientebien").value);
	formData.append("nombre_cliente", document.getElementById("nombre_cliente").value);
	formData.append("email_cliente", document.getElementById("email_cliente").value);	
	formData.append("telefono_cliente", document.getElementById("telefono_cliente").value);
	formData.append("direccion_cliente", document.getElementById("direccion_cliente").value);
	var xhr = new XMLHttpRequest();
	xhr.open("PUT", "http://localhost:8080/actualizarcliente");
	
	//Luego de enviar los datos ocultamos de nuevo el form y se visualiza el mensaje de cliente creado con exito
	var element = document.getElementById("form-actualizar");
	element.classList.add("visually-hidden");
	var element2 = document.getElementById("mensaje-bien-cliente-actualizado");
	element2.classList.remove("visually-hidden");
	document.getElementById("cedula_cliente").value = "";
	
	//volvemos vacias las cajas de texto del formulario
	document.getElementById("cedula_clientebien").value = "";
	document.getElementById("nombre_cliente").value = "";
	document.getElementById("email_cliente").value = "";
	document.getElementById("telefono_cliente").value = "";
	document.getElementById("direccion_cliente").value = "";
	
	xhr.send(formData);	
}