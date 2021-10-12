var cedula = document.getElementById("cedula_cliente").value;

if (cedula === null) {
    document.getElementById("btn_consultar").setAttribute("disabled","true");
} else {
    document.getElementById("btn_consultar").removeAttribute("disabled");
}