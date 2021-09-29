//Funcion para consultar un proveedor
function consultar() {
	var req = new XMLHttpRequest();
	var nit = document.getElementById("nitproveedor").value;
	req.open('GET', 'http://localhost:8080/consultarproveedor?nitproveedor='+ nit, false);
	req.send(null);
	var proveedor = null;
	if (req.status == 200) {
		proveedor = JSON.parse(req.responseText);
	}
	
	console.log(JSON.parse(req.responseText));
	console.log(proveedor.toString());	
	
	if (proveedor.toString() != "") {
		//Se agrega la información en cada una de las cajas de texto
		document.getElementById("nitproveedorinfo").value = proveedor[0].nitproveedor;
		document.getElementById("ciudad_proveedorinfo").value = proveedor[0].ciudad_proveedor;
		document.getElementById("direccion_proveedorinfo").value = proveedor[0].direccion_proveedor;
		document.getElementById("nombre_proveedorinfo").value = proveedor[0].nombre_proveedor;
		document.getElementById("telefono_proveedorinfo").value = proveedor[0].telefono_proveedor;
		
		//Se vacia la caja de texto para escribir el nit de nuevo
		document.getElementById("nitproveedor").value = "";
		//Se oculta el mensaje de error al consultar proveedor por que no existe o por otro error
		var element = document.getElementById("mensaje-error-consultar-proveedor");
		element.classList.add("visually-hidden");
		//Se visualiza la información del proveedor
		var element2 = document.getElementById("form-info");
		element2.classList.remove("visually-hidden");	
	} else {
		//Se vacia la caja de texto para escribir la nit de nuevo
		document.getElementById("nitproveedor").value = "";
		//Se visualiza el mensaje de error al consultar proveedor por que no existe o por otro error 
		var element = document.getElementById("mensaje-error-consultar-proveedor");
		element.classList.remove("visually-hidden");
		//Se oculta la información del proveedor
		var element2 = document.getElementById("form-info");
		element2.classList.add("visually-hidden");
		//Vaciamos todas las cajas donde se muestra la información del proveedor
		document.getElementById("nitproveedorinfo").value = "";
		document.getElementById("ciudad_proveedorinfo").value = "";
		document.getElementById("direccion_proveedorinfo").value = "";
		document.getElementById("nombre_proveedorinfo").value = "";
		document.getElementById("telefono_proveedorinfo").value = "";
	}
	
}