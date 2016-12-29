	
    function validarMatricula() {
<<<<<<< HEAD
			var matriculasOS = document.getElementById("matricula").value;
			$.ajax({
				type : "GET",
				 url: "http://sistemas.saogoncalo.rn.gov.br:8080/sisOs/ordemDeServico/validarMatriculaFuncOs?matriculasOS="+matriculasOS,
				
				//url : "http:ordemDeServico/validarMatriculaFuncOs?matriculasOS="+matriculasOS,
				//url : "http://192.168.1.252:8080/sisOs/ordemDeServico/validarMatriculaFuncOs?matriculasOS="+matriculasOS,
				dataType : "json",
				success : function(verifMatricula) {
				if(verifMatricula.id == 0) {
					document.getElementById("mensagemErro").innerHTML = "Matricula invalida ou inexistente";
					document.getElementById("matricula").focus();
					
				}else{    
					
					document.getElementById("interessado").value = verifMatricula.nome;	
					document.getElementById("mensagemErro").innerHTML = ""; 
				  }  
				}
			});
=======
    	var matriculasOS = document.getElementById("matricula").value;
		$.ajax({
			type : "GET",
			url: "http://sistemas.saogoncalo.rn.gov.br:8080/sisOs/ordemDeServico/validarMatriculaFuncOs?matriculasOS="+matriculasOS,
			//url: "http://localhost:8080/sisOs/ordemDeServico/validarMatriculaFuncOs?matriculasOS="+matriculasOS,
			dataType : "json",
			success : function(verifMatricula) {
			if(verifMatricula.id == 0) {
				document.getElementById("mensagemErro").innerHTML = "Matricula invalida ou inexistente";
				document.getElementById("matricula").focus();
				document.getElementById("interessado").value = " ";	
				
			}else{    
				
				document.getElementById("interessado").value = verifMatricula.nome;	
				document.getElementById("mensagemErro").innerHTML = ""; 
			  }  
			}
		});
		
>>>>>>> 6878574c6d522a568a59eeea7b47c42ef62d69d4
      }

	
		           

	
