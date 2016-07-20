	
    function validarMatricula() {
			var matriculasOS = document.getElementById("matricula").value;
			$.ajax({
				type : "GET",
				url : "http:ordemDeServico/validarMatriculaFuncOs?matriculasOS="+matriculasOS,
				//url : "http://192.168.1.252:8080/sisOs/ordemDeServico/validarMatriculaFuncOs?matriculasOS="+matriculasOS,
				dataType : "json",
				success : function(verifMatricula) {
					document.getElementById("interessado").value = "joao";
				if (verifMatricula == "") {
					alert("matricula invalida ou inexistente");
					document.getElementById("matricula").focus();

					}
				}
			});
      }

	
		           

	
