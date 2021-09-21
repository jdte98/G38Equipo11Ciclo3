//---------------------------------Modo oscuro------------------------------
const btnSwitch = document.querySelector('#switch');

btnSwitch.addEventListener('click', () =>{
  document.body.classList.toggle('dark');
  btnSwitch.classList.toggle('active');
})

//Funcion para el boton que envia a la lista de usuarios
function botonListaUsuarios(){
	window.location.href = "lista_usuarios.jsp"
}