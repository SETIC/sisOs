<!DOCTYPE html>
<html lang="pt-br">
<head>

<meta name="layout" content="public" />
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SISOS</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h3>Editar Ordem de Serviço</h3>

				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
					<li class="active">Editar Ordem de Serviço</li>
				</ol>
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
						<g:each in='${ordemDeServico?}'>
						</g:each>
						<div style="margin-left: 120px">
							<g:form controller="ordemDeServico" action="atualizar"
								class="form-horizontal">
								<g:hiddenField type="number" name="id" value="${it.id}" />
								<fieldset>
									<div class="form-group">
										<label for="inputmatricula" class="col-sm-2 control-label">Matricula</label>
										<div class="col-sm-4">
											<input class="form-control" required name="matricula"
												type="text" disabled value="${it.matricula}">
										</div>
									</div>
									<br>
									<div class="form-group">
										<label for="inputinteressado" class="col-sm-2 control-label">Interessado</label>
										<div class="col-sm-4">
											<input class="form-control" required name="interessado"
												type="text" disabled value="${it.interessado}">
										</div>
									</div>
									<br>
									<div class="form-group">
										<label for="inputtelefone" class="col-sm-2 control-label">Telefone</label>
										<div class="col-sm-4">
											<g:textField class="form-control" name="telefone" disabled value="${it.telefone}" />
										</div>
									</div>
									<br>
									<div class="form-group">
										<label for="inputdataemissao" class="col-sm-2 control-label">Data
											de Emissão</label>
										<div class="col-sm-4">
											<g:textField class="form-control" name="dataEmissao" disabled value="${it.dataEmissao.format('dd/MM/yyyy')}" />
										</div>
									</div>
									<div class="form-group">
										<label for="inputemail" class="col-sm-2 control-label">E-mail</label>
										<div class="col-sm-4">
											<g:textField class="form-control" name="email" disabled value="${it.email}" />
										</div>
									</div>
									<br>
									<div class="form-group">
										<label for="inputorgao" class="col-sm-2 control-label">Orgão</label>
										<div class="col-sm-4">
											<g:textField class="form-control"  name="orgao" disabled value="${it.orgao.nome}" />
										</div>
									</div>
									<br>
									
									<style>.datepicker{z-index:1200 !important;}</style>
									<div>
									   <script src="/sisOs/js/data.js"></script>
										<div class="form-group">
											<label for="dataAgendamento" class="col-sm-2 control-label">Data
												de Agendamento</label>
											<div class="col-sm-4">
												<div class="input-group date" data-provide="datepicker">
													<input type="text" class="form-control"
														name="dataAgendamento" id ="dataAgendamento"
														value="${it.dataAgendamento?.format('dd/MM/yyyy')}" />
													   <label class="input-group-addon btn">
														<span class="fa fa-calendar"></span>
													</label>
												</div>
											</div>
										</div>
									</div>
								<br>
									<div class="form-group">
										<label for="problema" class="col-sm-2 control-label">Problema</label>
										<div class="col-sm-4">
											<textarea rows="5" cols="4" class="form-control" name="problema">${it.problema}</textarea>
										</div>
									</div>
									
									
									<div class="form-group">
										<label for="inputstatus" class="col-sm-2 control-label">Status</label>
										<div class="col-sm-4">
											<select name="status" id="comboStatus" class="form-control">
												<g:each in="${status}">
													<g:if test="${it.id == ordemDeServico.status.id}">
														<option value="${it.id}" selected>
															${it.nome}
														</option>
													</g:if>
													<g:else>
														<option value="${it.id}">
															${it.nome}
														</option>
													</g:else>
												</g:each>
											</select>
										</div>
									</div>
									<br>
									
									
									<div class="form-group">
										<label for="inputmatricula3" class="col-sm-2 control-label">Solução</label>
										<div class="col-sm-4">
											<textarea rows="4" cols="5" class="form-control" name="solucao" placeholder="Descreva a solução">${ordemDeServico.solucao}</textarea>
										</div>
									</div>
									<br>
									
									<div class="form-group">
										<label for="inputmatricula3" class="col-sm-2 control-label">Técnico</label>
										<div class="col-sm-4">

											<g:select class="form-control select2 select2-hidden-accessible" optionKey="id" optionValue="nome" name="tecnicosOs" from="${usuariosOs}" name="tecnicosOs" multiple="True" 
																						value="${tecnicosOs?.usuariosOs?.id}" required="True" />	


											<%--
											<g:if test="${tecnicosOs?.usuariosOs?.id == 1}">
												<g:select class="form-control select2 select2-hidden-accessible" optionKey="id" optionValue="nome" name="tecnicosOs" from="${usuariosOs}" name="tecnicosOs" multiple="True" 
																						value="${session['userId']}" required="True" />
											</g:if>
											<g:else>
												<g:select class="form-control select2 select2-hidden-accessible" optionKey="id" optionValue="nome" name="tecnicosOs" from="${usuariosOs}" name="tecnicosOs" multiple="True" 
																						value="${tecnicosOs?.usuariosOs?.id}" required="True" />	
											</g:else>
											--%>
										</div>
									</div>
									<br>

								</fieldset>
								<div style="margin: 0 17% auto">
									<button type="submit" class="btn btn-primary btn-flat">Atualizar</button>
									<ul style="display: inline-block; margin-left: -30px">
										<li class="btn btn-default btn-flat"><a
											href="/sisOs/ordemDeServico/listarOrdemDeServico">Cancelar</a></li>
									</ul>
								</div>
							</g:form>
						</div>
					</div>
				</section>
        </body>
</html>