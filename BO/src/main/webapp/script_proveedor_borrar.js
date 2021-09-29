function borrar() {
			var x = document.getElementById("nit_proveedor").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', 'http://localhost:8080/listarproveedores', false);
			req.send(null);
			var proveedores = null;
			if (req.status == 200) {
				proveedores = JSON.parse(req.responseText);
			}
			
			console.log(JSON.parse(req.responseText));

			for (i = 0; i < proveedores.length; i++) {				
				console.log(proveedores[i].nit_proveedor);
				if (proveedores[i].nit_proveedor == x) {
					console.log(proveedores[i].nit_proveedor + " " + x);
					coincidencia = true
					break;
				}
			}
			//mensaje en consola
			console.log(coincidencia);	
			
			//Condicional: si encuentra el proveedor con la NIT entonces entramos a eliminar
			if (coincidencia != false) {
				//variable que contiene verdadero o falso para la ventana de confirmacion de si esta seguro de eliminar el proveedor
				var confirmacion = confirm("Esta seguro que desea eliminar el proveedor!?");
				//Luego de confirmar que existe el proveedor verificamos si esta seguro de eliminar, si es verdadero elimina, si no, no
				if (confirmacion == true){
					//guardamos la el valor del NIT en la variable
					var nit = document.getElementById("nitproveedor").value;
					//Eliminamos el proveedor
					var xhr = new XMLHttpRequest();
					xhr.open("DELETE", "http://localhost:8080/eliminarproveedor?nit_proveedor=" + nit);
					//Ocultamos el mensaje de error
					var element = document.getElementById("mensaje-error-eliminado");
					element.classList.add("visually-hidden");
					//Se visualiza el mensaje de proveedor eliminado con exito
					var element2 = document.getElementById("mensaje-bien-eliminado");
					element2.classList.remove("visually-hidden");
					//Borramos la NIT que estaba en la caja
					document.getElementById("nit_proveedor").value = "";
					xhr.send();
				} else {
					//Si la verificacion es falsa entonces borramos los mensajes de alerta y dejamos en blanco la caja de texto de la NIT
					//Se muestra el mensaje de error
					var element = document.getElementById("mensaje-error-eliminado");
					element.classList.remove("visually-hidden");
					//Ocultamos el mensaje de proveedor eliminado con exito
					var element2 = document.getElementById("mensaje-bien-eliminado");
					element2.classList.add("visually-hidden");
					//ocultamos el mensaje de proveedor no encontrado
					var element3 = document.getElementById("mensaje-proveedor-no-encontrado");
					element3.classList.add("visually-hidden");
					//Borramos la NIT que estaba en la caja
					document.getElementById("nit_proveedor").value = "";
				}
			} else {
				//Se visualiza el mensaje de error por si cancelo el borrado o por si no se encontro el proveedor con ese numero de NIT
				var element = document.getElementById("mensaje-proveedor-no-encontrado");
				element.classList.remove("visually-hidden");
				//Ocultamos el mensaje de eliminado con exito
				var element2 = document.getElementById("mensaje-bien-eliminado");
				element2.classList.add("visually-hidden");
				//Borramos la NIT que estaba en la caja
				document.getElementById("nit_proveedor").value = "";;
			}
		}