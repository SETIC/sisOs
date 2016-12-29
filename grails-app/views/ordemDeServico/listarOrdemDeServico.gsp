<html>
<head>
<meta name="layout" content="public" />
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SISOS</title>
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			
			<!-- CORPO DA PÁGINA -->
	<section class="content">
		<div class="">
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
			
			<script>
			 function deletar(id) {
			 var resposta = confirm("Deseja exluir esta OS?");
			
			 if (resposta == true){
			 location.href="/sisOs/OrdemDeServico/deletar/"+id }

             }
            </script>
				<h1>Listagem de Chamados</h1>
				<!-- Tabela  -->
				<ol class="breadcrumb">
				</ol>
				<br>
				<table id="listarChamados" class="table table-striped table-hover example">
					<thead>
						<tr>
							<th style="text-align: left; padding-left: 10px;">Nº</th>
							<th style="text-align: left; padding-left: 10px;">Situação</th>
							<th style="text-align: left; padding-left: 10px;">Interessado</th>
							<th style="text-align: left; padding-left: 10px;">Data de Emissão</th>
							<th style="text-align: left; padding-left: 10px;">Data de Agendamento</th>
							<th style="text-align: left; padding-left: 10px;">Orgão</th>
							<th style="text-align: left; padding-left: 10px;">Telefone</th>
							<th style="text-align: left; padding-left: 10px;">Funções</th>
						</tr>
					</thead>
					<tbody>
						<g:set var="i" value="${1}" />
						<g:each in='${ordemDeServico?}'>
							<tr class='linha_registro'>
								<td>
									${i++}
								</td>
								<td><g:if test="${it.status.id == 1}">
										<span class="label label-danger">ABERTO</span>
									</g:if> <g:if test="${it.status.id == 2}">
										<span class="label label-warning">PENDENTE</span>
									</g:if> <g:if test="${it.status.id == 3}">
										<span class="label label-success">CONCLUIDO</span>
									</g:if></td>
								<td>
									${it.interessado}
								</td>

								<td><g:formatDate format="dd/MM/yyyy" type="datetime"
										style="MEDIUM" date="${it.dataEmissao}" /></td><%--
							    <td><g:formatDate format="dd/MM/yyyy" type="date"
										style="MEDIUM" date="${it.dataAgendamento}" /></td>
								
								
								
								--%><td><g:formatDate format="dd/MM/yyyy" type="date"
										style="MEDIUM" date="${it.dataAgendamento}" />
										
								 <g:if test ="${it.dataAgendamento == null}">
                                    ${'----'}								
								 </g:if>		
								</td>
								
								<td>
									${it.orgao.nome}
								</td>
								<td>
									${it.telefone}
								</td>

								<td>
									<div class="opcoes">
										<div style="display: inline">
											<div title="Editar" class="btn btn-primary btn-xs btn-flat">
												<a style="color: #fff"
													href="/sisOs/ordemDeServico/editarOrdemDeServico/${it.id}"><span>
														<i class="fa fa-pencil"></i>
												</span></a>
											</div>
											<div title="Remover" onclick="deletar(${it.id})"
												class="btn btn-danger btn-xs btn-flat">
												<span class="fa fa-times"></span>
											</div>
															
										</div>
									</div>
								</td>
							</tr>
						</g:each>
					</tbody>
					
					
					
				</table>
			</section>


	
	<script>
		var htm = document.getElementById('listarChamados').innerHTML; 
		
	</script>
		
	<% def html1 = htm %>
	
	<g:link action="gerarPDF" params="[html1:"${html1}"]" > Download PD </g:link>
	
	
	

	<!-- ./wrapper -->

	<!-- jQuery 2.2.3 -->
	<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/app.min.js"></script>
	<!-- Sparkline -->
	<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- SlimScroll 1.3.0 -->
	<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- ChartJS 1.0.1 -->
	<script src="plugins/chartjs/Chart.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="dist/js/pages/dashboard2.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="dist/js/demo.js"></script>
</body>
</html>





























