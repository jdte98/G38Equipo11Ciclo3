//Funcion para consultar un cliente
function consultar() {
	var req = new XMLHttpRequest();
	var cedula = document.getElementById("cedula_cliente").value;
	req.open('GET', 'http://localhost:8080/consultarcliente?cedula_cliente='+ cedula, false);
	req.send(null);
	var cliente = null;
	if (req.status == 200) {
		cliente = JSON.parse(req.responseText);
	}
	
	console.log(JSON.parse(req.responseText));
	console.log(cliente.toString());	
	
	if (cliente.toString() != "") {
		//Se agrega la información en cada una de las cajas de texto
		document.getElementById("cedula_clienteinfo").value = cliente[0].cedula_cliente;
		document.getElementById("nombre_clienteinfo").value = cliente[0].nombre_cliente;
		document.getElementById("email_clienteinfo").value = cliente[0].email_cliente;
		document.getElementById("telefono_clienteinfo").value = cliente[0].telefono_cliente;
		document.getElementById("direccion_clienteinfo").value = cliente[0].direccion_cliente;
		
		//Se vacia la caja de texto para escribir la cedula de nuevo
		document.getElementById("cedula_cliente").value = "";
		//Se oculta el mensaje de error al consultar cliente por que no existe o por otro error
		var element = document.getElementById("mensaje-error-consultar-cliente");
		element.classList.add("visually-hidden");
		//Se visualiza la información del cliente
		var element2 = document.getElementById("form-info");
		element2.classList.remove("visually-hidden");	
	} else {
		//Se vacia la caja de texto para escribir la cedula de nuevo
		document.getElementById("cedula_cliente").value = "";
		//Se visualiza el mensaje de error al consultar cliente por que no existe o por otro error 
		var element = document.getElementById("mensaje-error-consultar-cliente");
		element.classList.remove("visually-hidden");
		//Se oculta la información del cliente
		var element2 = document.getElementById("form-info");
		element2.classList.add("visually-hidden");
		//Vaciamos todas las cajas donde se muestra la información del cliente
		document.getElementById("cedula_cliente").value = "";
		document.getElementById("nombre_cliente").value = "";
		document.getElementById("email_cliente").value = "";
		document.getElementById("telefono_cliente").value = "";
		document.getElementById("direccion_cliente").value = "";
	}
	
}