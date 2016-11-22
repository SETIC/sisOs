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
  function printDiv(id)
  {
   
  var listaOs = document.getElementById('pequisarOs');
  newWin = window.open("");
  newWin.document.write("<style=''>");
  newWin.document.write("<table border='0'>");
  newWin.document.write("<tr>");

  newWin.document.write("<td><img src='${request.getRequestURL().substring(0, request.getRequestURL().indexOf('sisOs/'))}sisOs/static/images/brasao.jpg'; style='width:100px; float:left; margin-top:-9px;'></td>");
  newWin.document.write("<h4 style=' margin-left:220px; '>PREFEITURA MUNICIPAL DE SÃO GONÇALO DO AMARANTE - RN</h4>");
  newWin.document.write("<h4 style='margin-top:20px; margin-left:330px;'> ORDENS DE SERVIÇO</h4>");
  newWin.document.write("<style type='text/css' >");
  newWin.document.write("</style>");
  newWin.document.write("");
  newWin.document.write("<br>");
  newWin.document.write("</td>");
  newWin.document.write("</tr>");
  newWin.document.write("</table><br>");
  
  newWin.document.write(listaOs.outerHTML);
  newWin.print();
  newWin.close();
}
</script>			
				
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
      <section class="content-header" style="margin-left: 5%; margin-bottom: 2%;">
		<h1>
			Ordem de Serviço<small>Consulta</small>
		</h1>
		<br>
			<g:form controller="ordemDeServico" action="pesquisarOrdemDeServico" class="form">
			<div class="form-heading" style="width:150px;">
				<label>Tipo de Busca</label>
				<div class="controls">
					<select class="selectpicker"  id ="tipoBusca" name="tipoBusca" onchange = "mudarSelecao();">
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
					class="table table-striped table-hover example" border="1">
					<thead>
						<tr class="success">
						    <th style="text-align: left;padding-left:10px;">Orgão</th>
						    <th style="text-align: left;padding-left:10px;">Situação</th>
						    <th style="text-align: left;padding-left:10px;">Interessado</th>
						    <th style="text-align: left;padding-left:10px;">Problema</th>
						    <th style="text-align: left;padding-left:10px;">Soluçao</th> 
						</tr>
					</thead>
					<tbody>
					<g:set var="i" value="${1}" />
						<g:each in='${ordens?}'>
							<tr class='linha_registro'>
								<td class="info">
									${it.orgao.nome}	
								</td>
								<td class="info">
				       			<g:if test="${it.status.nome == 'ABERTO'}">
										<span class="label label-danger">ABERTO</span>
									</g:if>
								<g:if test="${it.status.nome == 'PENDENTE'}">
										<span class="label label-warning">PENDENTE</span>
									</g:if>
								
								 <g:if test="${it.status.nome =='CONCLUÍDO'}">
										<span class="label label-success">CONCLUIDO</span>
									</g:if>
								</td>
								<td class="info">
								   ${it.interessado}
								</td>
								<td class="info">
								   ${it.problema}
								</td>
							    <td class="info">
							       ${it.solucao}
							   </td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</div>
		</div>
		<%--<g:link action="gerarPdf">Download invoice</g:link>--%>

		<div style="margin: 0 5% auto;">
					<button class="btn btn-primary btn-flat"
						onclick="printDiv('divGrafico')">
						<i class="fa fa-print" aria-hidden="true"></i> Imprimir
					</button>
				</div>
	</section>
 </body>
</html>


