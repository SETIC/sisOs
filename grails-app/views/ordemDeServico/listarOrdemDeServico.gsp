<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Listar</title>
<meta name="layout" content="public" />
</head>
<body>
	<section class="content-header" style="margin-left: 5%; margin-bottom: 2%;">
		<h1>
			Chamados<small> Visualização e Gerenciamento</small>
		</h1>
		<div id="navBar">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">Listagem de Chamados</a></li>
				<%--<li role="presentation"><a href="/sisOs/ordemDeServico/listarOrdemDeServico">Listagem de OS</a></li>
				--%><li role="presentation"><a
					href="/sisOs/ordemDeServico/cadastrarOrdemDeServico">Novo
						Chamado</a></li>
			</ul>
		</div>
		<!--<ol class="breadcrumb">
			<li class="active"><g:link controller="Layout" action="index">
					<i class="fa fa-dashboard"></i> Inicio</g:link></li>
			<li><g:link controller="OrdemDeServico"
					action="listarOrdemDeServico">ordem de servico</g:link></li>
			<li><g:link controller="OrdemDeServico"
					action="cadastrarOrdemDeServico">cadastro</g:link></li>

		</ol>-->
	</section>
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
			<div class="box box-white">
				<table id="listarChamados"
					class="table table-striped table-hover example">
					<thead>
						<tr>
							<th style="width: 40px;"></th>
							<th style="text-align: left;padding-left:10px;">Nº</th>
							<th style="text-align: left;padding-left:10px;">Interessado</th>
							<th style="text-align: left;padding-left:10px;">Matricula</th>
							<th style="text-align: left;padding-left:10px;">Data de Emissão</th>
							<th style="text-align: left;padding-left:10px;">E-mail</th>
							<th style="text-align: left;padding-left:10px;">Orgão</th>
							<th style="text-align: left;padding-left:10px;">Situação</th>
						</tr>
					</thead>
					<tbody>
					<g:set var="i" value="${1}" />
						<g:each in='${ordemDeServico?}'>
							<tr class='linha_registro'>
								<td>
									<div class="opcoes" >
										<div style="display: inline">
											<div title="Editar" class="btn btn-primary btn-xs btn-flat">
												<a style="color: #fff"
													href="/sisOs/ordemDeServico/editarOrdemDeServico/${it.id}"> <span>
													<i class="fa fa-pencil"></i></span></a>
											</div>
											<div title="Remover" onclick="deletar(${it.id})"
											class="btn btn-danger btn-xs btn-flat" >
											<span class="fa fa-times"></span></a>

											</div>
										</div>
									</div>
								</td>
								<td>
							         ${i++}
						       </td>
								<td>
									${it.interessado}
								</td>
								<td>
									${it.matricula}
								</td>
								<td><g:formatDate format="dd/MM/yyyy" type="datetime"
										style="MEDIUM" date="${it.dataEmissao}" /></td>

								<td>
									${it.email}
								</td>
								<td>
									${it.orgao.sigla}
								</td>
								<td>
								<g:if test="${it.status.id == 1}">
										<span class="label label-danger">ABERTO</span>
									</g:if>
								<g:if test="${it.status.id == 2}">
										<span class="label label-warning">PENDENTE</span>
									</g:if>
								
								 <g:if test="${it.status.id == 3}">
										<span class="label label-success">CONCLUIDO</span>
									</g:if>
								</td>
							</tr>
						</g:each>
					</tbody>
				</table>
			 </div>
			<br>
		</div>
	</section>
</body>
</html>