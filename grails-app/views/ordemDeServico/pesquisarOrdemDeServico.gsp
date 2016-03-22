
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Ordem de Serviço . Módulo OS</title>
<meta name="layout" content="public" />
</head>
<body>
 <script>
 function mudarSelecao(){
			
			var x = document.getElementById('tipoBusca');
			value = x.options[x.selectedIndex].value;

           switch(value){
           case 'numero':

			  newInput.innerHTML = "<label>Número do protocolo: </label/></br>"+
			  "<input type='text' required = 'true' name ='numeroProtocolo' id ='numeroProtocolo'/>" +
			  "<button style='margin-left: 10px;' type='submit' class='btn btn-primary btn-flat'>" +
			  "<i class='glyphicon glyphicon-search'></i>Buscar</button>"
              break;

           case 'data':
 			  newInput.innerHTML = "<label>Data Inicial: </label/><input type='date' name ='dataInicial' id='dataInicial' " +
 	 		  "<br>   <label>Data Final: </label/><input type='date' name ='dataFinal' id='dataFinal'/>" +
 	 		 "<button style='margin-left: 10px;' type='submit' class='btn btn-primary btn-flat'>" +
			  "<i class='glyphicon glyphicon-search'></i>Buscar</button>"
               // newInput.innerHTML = "<input data-provide='datepicker' value='09-10-2015' language='pt-br'/>"
              break;
           
           case 'setor':
        	   newInput.innerHTML = "<label>Setor:</label/>" +
        	   "<div id='iDivSelectPicker' class='row'>"+
			   "<div class='col-sm-2'>"+
        	   "<select class='form-control selectpicker' " +
   			   "data-live-search='true' name='setor' id='setor'"+
   			   "<option value='0'>Setor</option>" +
   			   "<g:each in="${setor}">"+
   			   "<option value='${it.id}'>" +
   			   "${it.nome}</option></g:each></select></div>" +
   			   "<button type='submit' class='btn btn-primary btn-flat'>" +
			   "<i class='glyphicon glyphicon-search'></i>Buscar</button>" 
              break;

           case 'interessado':
 			  newInput.innerHTML = "<label>Nome do Interessado: </label/></br>"+
 			  "<input type='text' required = 'true' name ='interessado' id ='interessadoId'/>" +
 			  "<button style='margin-left: 10px;' type='submit' class='btn btn-primary btn-flat'>" +
 			  "<i class='glyphicon glyphicon-search'></i>Buscar</button>"
               break;   
           }
			
		}
        
		</script>
 
 <section class="content-header">
		<h1>
			ordem de serviço<small>Consulta</small>
		</h1>
		<ol class="breadcrumb">
			<li class="active"><g:link controller="Layout" action="index">
					<i class="fa fa-dashboard"></i> Inicio</g:link></li>
		</ol>
		<br>
			<g:form controller="ordemDeServico" action="pesquisarOrdemDeServico" class="form">
			<div class="form-heading" style="width:150px;">
				<label>Tipo de Busca</label>
				<div class="controls">

					<select class="form-control selectpicker" id ="tipoBusca" name="tipoBusca" onchange = "mudarSelecao();">
						<option value="null">SELECIONE...</option>
						<option value="numero">NUMERO</option>
						<option value="data">DATA</option>
						<option value="interessado">INTERESSADO</option>
						
					</select>
				</div>
			</div>
			<br>
			<div id='newInput'>
			<!-- lugar onde aparecerao os campos -->
		   	</div>
			</g:form>
		</section>
	<!-- CORPO DA PÁGINA -->
	<section class="content">
		<div>
			<g:if test="${ok}">
				<div class="alert alert-success">
					${ok}
				</div>
			</g:if>
			<g:if test="${erro}">
				<div class="alert alert-danger">
					${erro}
				</div>
			</g:if>
                       
			<div class="box box-white">
				<table id="pequisarOs"
					class="table table-striped table-hover example">
					<thead>
						<tr>
							<th style="width:60px;padding-left:60px">Funções</th>
							<th>Número</th>
							<th>Data da Emissão</th>
						</tr>
					</thead>
					<tbody>
						<g:each in='${ordens?}'>
							<tr class='linha_registro'>
								<td>
									<div style="margin-left: 10px" class="opcoes">
										<ul style="display: inline">
											<li title="Ver detalhes do protocolo"
												class="btn btn-success btn-xs btn-flat"><a
												style="color: #fff"
												href="/sisOs/ordemDeServico/verInfoProtocolo/${it.protocolo_id}"><span
													class="glyphicon glyphicon-eye-open"></span></a></li> 
																					
												<li title="Editar protocolo" class="btn btn-primary btn-xs btn-flat"><a
													style="color: #fff"
													href="/sisOs/ordemDeServico/editar/${it.protocolo_id}"><span
														class="glyphicon glyphicon-pencil"></span></a></li>
										</ul>
									</div>
								</td>
								<td>
									${it.numero}
								</td>
								<td>
								    <g:formatDate type="datatime" style="MEDIUM" date="${it.dataEmissao}" />
								</td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</body>
</html>