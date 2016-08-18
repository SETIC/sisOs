
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Ordem de Serviço . Módulo OS</title>
<meta name="layout" content="public" />
<meta content="width=device-width, initial-scale=1" name="viewport">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Pesquisa OS</h1>

				<!-- Tabela  -->

				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
					<li class="active">Pesquisa OS</li>
					<br>
				</ol>
<script>
 function mudarSelecao(){
			
			var x = document.getElementById('tipoBusca');
			value = x.options[x.selectedIndex].value;

           switch(value){
           case 'orgao':
           
        	   newInput.innerHTML = "<label>Orgão:</label/>" +
        	   "<div id='iDivSelectPicker' class='row'>"+
			   "<div class='col-sm-4'>"+
        	   "<select class='form-control selectpicker' data-size='5' data-live-search='true' " +
   			   "data-live-search='true' name='orgao' id='orgao'"+
   			   "<option value='0'>Orgao</option>" +
   			   "<g:each in="${orgao}">"+
   			   "<option value='${it.id}'>" +
   			   "${it.nome}</option></g:each></select></div>" +
   			   "<button type='submit' class='btn btn-primary btn-flat'>" +
			   "<i class='fa fa-search'></i>Buscar</button>" 
               break;

           case 'interessado':
  			  newInput.innerHTML = "<label>Nome do Interessado: </label/></br>"+
  			  "<input type='text' required = 'true' name ='interessado' id ='interessadoId'/>" +
  			  "<button style='margin-left: 10px;' type='submit' class='btn btn-primary btn-flat'>" +
  			  "<i class='fa fa-search'></i>Buscar</button>"
                break;   

  	       case 'data':
 			  newInput.innerHTML = "<label>Data Inicial: </label/><input type='date' name ='dataInicial' id='dataInicial' " +
 	 		  "<br>   <label>Data Final: </label/><input type='date' name ='dataFinal' id='dataFinal'/>" +
 	 		 "<button style='margin-left: 10px;' type='submit' class='btn btn-primary btn-flat'>" +
			  "<i class='fa fa-search'></i>Buscar</button>"
               // newInput.innerHTML = "<input data-provide='datepicker' value='09-10-2015' language='pt-br'/>"
              break;
            
  	       case 'dataAgendamento':
			  newInput.innerHTML = "<label>Data : </label/><input type='date' name ='dataAgendamento' id='dataAgendamento' " +
	 		  "<br><button style = 'margin-left:10px;' type='submit' class='btn btn-primary btn-flat'>" +
			  "<i class='fa fa-search'></i>Buscar</button>"

             break;
           }
			
		}
		</script>
					<section class="content-header"
						style="margin-left: 5%; margin-bottom: 2%;">

						<br>
						<g:form controller="ordemDeServico"
							action="pesquisarOrdemDeServico" class="form">
							<div class="form-heading" style="width: 150px;">
								<label>Tipo de Busca</label>
								<div class="controls">
									<select class="selectpicker" id="tipoBusca" name="tipoBusca"
										onchange="mudarSelecao();">
										<option value="null">SELECIONE...</option>
										<option value="orgao">ORGÃO</option>
										<option value="interessado">INTERESSADO</option>
										<option value="data">DATA DE EMISSÃO</option>
										<option value="dataAgendamento">DATA DE AGENDAMENTO</option>
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
											<th style="text-align: left; padding-left: 10px;">Orgão</th>
											<th style="text-align: left; padding-left: 10px;">Situação</th>
											<th style="text-align: left; padding-left: 10px;">Interessado</th>
										</tr>
									</thead>
									<tbody>
										<g:set var="i" value="${1}" />
										<g:each in='${ordens?}'>
											<tr class='linha_registro'>
												<td>
													${it.orgao.nome}
												</td>
												<td><g:if test="${it.status.nome == 'ABERTO'}">
														<span class="label label-danger">ABERTO</span>
													</g:if> <g:if test="${it.status.nome == 'PENDENTE'}">
														<span class="label label-warning">PENDENTE</span>
													</g:if> <g:if test="${it.status.nome =='CONCLUÍDO'}">
														<span class="label label-success">CONCLUIDO</span>
													</g:if></td>
												<td>
													${it.interessado}
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


