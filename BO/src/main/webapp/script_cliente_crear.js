//Funcion para registrar/crear cliente nuevo
function crear() {
			var x = document.getElementById("nombre_cliente").value;
			var y = document.getElementById("cedula_cliente").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', 'http://localhost:8080/listarclientes', false);
			req.send(null);
			var clientes=null;
			if (req.status == 200)
				clientes=JSON.parse(req.responseText);
			  	console.log(JSON.parse(req.responseText));
			  	
			for (i = 0; i < clientes.length; i++) {
				console.log(clientes[i].cliente);
				console.log(clientes[i].cedula_cliente);
				if (clientes[i].cliente ===x ) {
					console.log(clientes[i].cliente +" "+x);	
					coincidencia =true
					break;
				}
				
				if (clientes[i].cedula_cliente ===y ) {
					console.log(clientes[i].cedula_cliente +" "+y);	
					coincidencia =true
					break;
				}
			}
			console.log(coincidencia);	
			
			if (coincidencia==false){
				var formData = new FormData();
	 			formData.append("nombre_cliente", document.getElementById("nombre_cliente").value);
	 			formData.append("cedula_cliente", document.getElementById("cedula_cliente").value);
	 			formData.append("email_cliente", document.getElementById("email_cliente").value);
	 			formData.append("telefono_cliente",document.getElementById("telefono_cliente").value);
	 			formData.append("direccion_cliente",document.getElementById("direccion_cliente").value);
	 			var xhr = new XMLHttpRequest();
	 			xhr.open("POST", "http://localhost:8080/registrarcliente");
	 			
				var element = document.getElementById("errorcrearcliente");
				element.classList.add("visually-hidden");
				var element2 = document.getElementById("correctocrearcliente");
				element2.classList.remove("visually-hidden");
				
				document.getElementById("nombre_cliente").value = "";
				document.getElementById("cedula_cliente").value = "";
				document.getElementById("email_cliente").value = "";
				document.getElementById("telefono_cliente").value = "";
				document.getElementById("direccion_cliente").value = "";
	 			xhr.send(formData);

			}else{
				var element = document.getElementById("errorcrearcliente");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correctocrearcliente");
				element2.classList.add("visually-hidden");
				document.getElementById("cedula_usuario").value = "";
				document.getElementById("email_usuario").value = "";
				document.getElementById("nombre_usuario").value = "";
				document.getElementById("telefono_cliente").value = "";
				document.getElementById("direccion_cliente").value = "";
			}
		}