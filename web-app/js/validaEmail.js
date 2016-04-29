
    function validaEMAIL(Email){
    	var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    	if(!filter.test(document.getElementById("email").value)){
    	alert('Por favor, digite o email corretamente');
    	document.getElementById("email").focus();
    	return false
    	  }
    	}
