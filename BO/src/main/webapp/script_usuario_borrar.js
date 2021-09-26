function borrar() {
			var x = document.getElementById("cedula_usuario").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', 'http://localhost:8080/listarusuarios', false);
			req.send(null);
			var usuarios = null;
			if (req.status == 200) {
				usuarios = JSON.parse(req.responseText);
			}
			
			console.log(JSON.parse(req.responseText));

			for (i = 0; i < usuarios.length; i++) {				
				console.log(usuarios[i].cedula_usuario);
				if (usuarios[i].cedula_usuario == x) {
					console.log(usuarios[i].cedula_usuario + " " + x);
					coincidencia = true
					break;
				}
			}
			//mensaje en consola
			console.log(coincidencia);	
			
			//Condicional: si encuentra el usuario con la cedula entonces entramos a eliminar
			if (coincidencia != false) {
				//variable que contiene verdadero o falso para la ventana de confirmacion de si esta seguro de eliminar el usuario
				var confirmacion = confirm("Esta seguro que desea eliminar el usuario!?");
				//Luego de confirmar que existe el usuario verificamos si esta seguro de eliminar, si es verdadero elimina, si no, no
				if (confirmacion == true){
					//guardamos la el valor de la cedula en la variable
					var cedula = document.getElementById("cedula_usuario").value;
					//Eliminamos el usuario
					var xhr = new XMLHttpRequest();
					xhr.open("DELETE", "http://localhost:8080/eliminarusuario?cedula_usuario=" + cedula);
					//Ocultamos el mensaje de error
					var element = document.getElementById("mensaje-error-eliminado");
					element.classList.add("visually-hidden");
					//Se visualiza el mensaje de usuario eliminado con exito
					var element2 = document.getElementById("mensaje-bien-eliminado");
					element2.classList.remove("visually-hidden");
					//Borramos la cedula que estaba en la caja
					document.getElementById("cedula_usuario").value = "";
					xhr.send();
				} else {
					//Si la verificacion es falsa entonces borramos los mensajes de alerta y dejamos en blanco la caja de texto de la cedula
					//Se muestra el mensaje de error
					var element = document.getElementById("mensaje-error-eliminado");
					element.classList.remove("visually-hidden");
					//Ocultamos el mensaje de usuario eliminado con exito
					var element2 = document.getElementById("mensaje-bien-eliminado");
					element2.classList.add("visually-hidden");
					//ocultamos el mensaje de usuario no encontrado
					var element3 = document.getElementById("mensaje-usuario-no-encontrado");
					element3.classList.add("visually-hidden");
					//Borramos la cedula que estaba en la caja
					document.getElementById("cedula_usuario").value = "";
				}
			} else {
				//Se visualiza el mensaje de error por si cancelo el borrado o por si no se encontro el usuario con ese numero de cedula
				var element = document.getElementById("mensaje-usuario-no-encontrado");
				element.classList.remove("visually-hidden");
				//Ocultamos el mensaje de eliminado con exito
				var element2 = document.getElementById("mensaje-bien-eliminado");
				element2.classList.add("visually-hidden");
				//Borramos la cedula que estaba en la caja
				document.getElementById("cedula_usuario").value = "";;
			}
		}