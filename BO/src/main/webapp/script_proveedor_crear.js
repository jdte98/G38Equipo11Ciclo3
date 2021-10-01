//Funcion para registrar/crear proveedor nuevo
function crear() {
			var x = document.getElementById("nombre_proveedor").value;
			var y = document.getElementById("nit_proveedor").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', 'http://localhost:8080/listarproveedores', false);
			req.send(null);
			var proveedores=null;
			if (req.status == 200)
				proveedores=JSON.parse(req.responseText);
			  	console.log(JSON.parse(req.responseText));
			  	
			for (i = 0; i < proveedores.length; i++) {
				console.log(proveedores[i].proveedor);
				console.log(proveedores[i].nit_proveedor);
				if (proveedores[i].proveedor ===x ) {
					console.log(proveedores[i].proveedor +" "+x);	
					coincidencia =true
					break;
				}
				
				if (proveedores[i].nit_proveedor ===y ) {
					console.log(proveedores[i].nit_proveedor +" "+y);	
					coincidencia =true
					break;
				}
			}
			console.log(coincidencia);	
			
			if (coincidencia==false){
				var formData = new FormData();
	 			formData.append("nit_proveedor", document.getElementById("nit_proveedor").value);
	 			formData.append("ciudad_proveedor", document.getElementById("ciudad_proveedor").value);
				formData.append("direccion_proveedor", document.getElementById("direccion_proveedor").value);
	 			formData.append("nombre_proveedor",document.getElementById("nombre_proveedor").value);
	 			formData.append("telefono_proveedor",document.getElementById("telefono_proveedor").value);
	 			var xhr = new XMLHttpRequest();
	 			xhr.open("POST", "http://localhost:8080/registrarproveedor");
	 			
				var element = document.getElementById("errorcrearproveedor");
				element.classList.add("visually-hidden");
				var element2 = document.getElementById("correctocrearproveedor");
				element2.classList.remove("visually-hidden");
				
				document.getElementById("nit_proveedor").value = "";
				document.getElementById("ciudad_proveedor").value = "";
				document.getElementById("direccion_proveedor").value = "";
				document.getElementById("nombre_proveedor").value = "";
				document.getElementById("telefono_proveedor").value = "";
	 			xhr.send(formData);

			}
			else{
				var element = document.getElementById("errorcrearproveedor");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correctocrearproveedor");
				element2.classList.add("visually-hidden");
				document.getElementById("nit_proveedor").value = "";
				document.getElementById("ciudad_proveedor").value = "";
				document.getElementById("direccion_proveedor").value = "";
				document.getElementById("nombre_proveedor").value = "";
				document.getElementById("telefono_proveedor").value = "";
			}	
		}