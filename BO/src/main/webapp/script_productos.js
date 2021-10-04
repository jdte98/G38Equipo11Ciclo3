function subirArchivo() {	
	try {
		var csvFile = document.getElementById("archivo");

		var input = csvFile.files[0];
		var reader = new FileReader();

		reader.onload = function(e) {

			var text = e.target.result;

			var arrayLineas = text.split("\n");

			var xhr = new XMLHttpRequest();
			xhr.open("DELETE", "http://localhost:8080/eliminartodoproducto",true);
			xhr.send();

			for (var i = 0; i < arrayLineas.length; i += 1) {
				var arraydatos = arrayLineas[i].split(",");

				if (arrayLineas[i] == "") {
					continue;
				}

				for (var j = 0; j < arraydatos.length; j += 1) {
					console.log(i + " " + j + "->" + arraydatos[j]);
				}

				var formData = new FormData();
				formData.append("codigo_producto", arraydatos[0]);
				formData.append("nombre_producto", arraydatos[1]);
				formData.append("nitproveedor", arraydatos[2]);
				formData.append("precio_compra", arraydatos[3]);
				formData.append("iva_compra", arraydatos[4]);
				formData.append("precio_venta", arraydatos[5]);
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "http://localhost:8080/registrarproducto");

				xhr.send(formData);
				}

			var element = document.getElementById("mensaje-error-archivo");
			element.classList.add("visually-hidden");
			var element2 = document.getElementById("mensaje-bien-archivo");
			element2.classList.remove("visually-hidden");

			document.getElementById("archivo").value = "";
		};

		reader.readAsText(input);
	} catch (error) {
		
		var element = document.getElementById("mensaje-error-archivo");
		element.classList.remove("visually-hidden");
		var element2 = document.getElementById("mensaje-bien-archivo");
		element2.classList.add("visually-hidden");

		document.getElementById("archivo").value = "";
	}
}
