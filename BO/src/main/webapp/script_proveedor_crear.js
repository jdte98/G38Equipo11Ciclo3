//Funcion para registrar/crear proveedor nuevo
function crear() {
			var x = document.getElementById("nombre_proveedor").value;
			var y = document.getElementById("nitproveedor").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', 'http://localhost:8080/listarproveedores', false);
			req.send(null);
			var proveedores=null;
			if (req.status == 200)
				proveedores=JSON.parse(req.responseText);
			  	console.log(JSON.parse(req.responseText));
			  	
			for (i = 0; i < proveedores.length; i++) {
				console.log(proveedores[i].proveedore);
				console.log(proveedores[i].nitproveedor);
				if (proveedores[i].proveedore ===x ) {
					console.log(proveedores[i].proveedore +" "+x);	
					coincidencia =true
					break;
				}
				
				if (proveedores[i].nitproveedor ===y ) {
					console.log(proveedores[i].nitproveedor +" "+y);	
					coincidencia =true
					break;
				}
			}
			console.log(coincidencia);	
			
			if (coincidencia==false){
				var formData = new FormData();
	 			formData.append("nitproveedor", document.getElementById("nitproveedor").value);
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
				
				document.getElementById("nitproveedor").value = "";
				document.getElementById("ciudad_proveedor").value = "";
				document.getElementById("direccion_proveedor	").value = "";
				document.getElementById("nombre_proveedor").value = "";
				document.getElementById("telefono_proveedor").value = "";
	 			xhr.send(formData);

			}else{
				var element = document.getElementById("errorcrearproveedor");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correctocrearproveedor");
				element2.classList.add("visually-hidden");
				document.getElementById("nitproveedor").value = "";
				document.getElementById("ciudad_proveedor").value = "";
				document.getElementById("direccion_proveedor").value = "";
				document.getElementById("nombre_proveedor").value = "";
				document.getElementById("telefono_proveedor").value = "";
			}	
		}