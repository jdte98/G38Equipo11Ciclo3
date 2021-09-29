//Boton para verificar que el proveedor existe
function verificarProveedores(){
	var x = document.getElementById("nit_proveedor").value;
	var req = new XMLHttpRequest();
	var coincidencia = false;
	req.open('GET', 'http://localhost:8080/listarproveedores', false);
	req.send(null);
	var proveedores = null;
	if (req.status == 200){
		proveedores = JSON.parse(req.responseText);
		console.log(JSON.parse(req.responseText));
	}
	for (i = 0; i < proveedores.length; i++){
		console.log(proveedores[i].nit_proveedor);
		if (proveedores[i].nit_proveedor == x){
			console.log(proveedores[i].nit_proveedor + " " + x);
			coincidencia = true;
			break;
		}
	}
	console.log(coincidencia);
	
	if (coincidencia == true) {
		//Visualizar el formulario para editar el proveedor
		var element = document.getElementById("form-actualizar");
		element.classList.remove("visually-hidden");
		//Ocultar el mensaje de cliente actualizado
		var element2 = document.getElementById("mensaje-bien-proveedor-actualizado");
		element2.classList.add("visually-hidden");
		//Ocultar el mensaje de error al buscar el proveedor
		var element3 = document.getElementById("mensaje-error-coincidencia-NIT");
		element3.classList.add("visually-hidden")
		//agregar el numero de nit en una caja de texto que no se puede editar
		document.getElementById("nit_proveedorbien").value = document.getElementById("nit_proveedor").value;
		//vaciar la caja de texto de nit_proveedor
		document.getElementById("nit_proveedor").value = "";
		
	} else {
		//Visualizar el mensaje de error al buscar el provedoor
		var element = document.getElementById("mensaje-error-coincidencia-NIT");
		element.classList.remove("visually-hidden");
		//ocultar el formulario para editar los datos si vuelve a escribir una cedula luego de haber escrito una correcta
		var element2 = document.getElementById("form-actualizar");
		element2.classList.add("visually-hidden");
		//Vaciar la caja de cedula que escribio erroneamente o no se encontro
		document.getElementById("nit_proveedor").value = "";
	}
}

//Boton para actualizar el cliente
function actualizar() {
	var formData = new FormData();
	formData.append("nit_proveedor", document.getElementById("nit_proveedorbien").value);
	formData.append("ciudad_proveedor", document.getElementById("ciudad_proveedor").value);
	formData.append("direccion_proveedor", document.getElementById("direccion_proveedor").value);	
	formData.append("nombre_proveedor", document.getElementById("nombre_proveedor").value);
	formData.append("telefono_proveedor", document.getElementById("telefono_proveedor").value);
	var xhr = new XMLHttpRequest();
	xhr.open("PUT", "http://localhost:8080/actualizarproveedor");
	
	//Luego de enviar los datos ocultamos de nuevo el form y se visualiza el mensaje de cliente creado con exito
	var element = document.getElementById("form-actualizar");
	element.classList.add("visually-hidden");
	var element2 = document.getElementById("mensaje-bien-proveedor-actualizado");
	element2.classList.remove("visually-hidden");
	document.getElementById("nit_proveedor").value = "";
	
	//volvemos vacias las cajas de texto del formulario
	document.getElementById("nit_proveedorbien").value = "";
	document.getElementById("ciudad_proveedor").value = "";
	document.getElementById("direccion_proveedor").value = "";
	document.getElementById("nombre_proveedor").value = "";
	document.getElementById("telefono_proveedor").value = "";
	
	xhr.send(formData);	
}