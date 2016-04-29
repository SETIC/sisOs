<!DOCTYPE html>
<html lang="pt-br">
	
  <head>
	<title>Editar ordem de serviço</title>
	<meta name="layout" content="public" />
  </head>
<body>
	<section class="content-header" style="margin-left: 5%; margin-bottom:-30px;">
	<script src="/sisOs/js/data.js"></script>
		<h1>
			Ordem de Serviço <small>Editar dados</small>
		</h1>
	    <br>
		<div id="navBar">
			<ul class="nav nav-tabs">
			</ul>
		</div>
		<br>
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
			<g:each in='${ordemDeServico?}'>
			</g:each>
			<div style="margin-left: 120px">
				<g:form controller="ordemDeServico" action="atualizar" class="form-horizontal">
					<g:hiddenField type="number" name="id" value="${it.id}" />
					<fieldset>
						<div class="form-group">
							<label for="inputinteressado" class="col-sm-2 control-label">Interessado</label>
							<div class="col-sm-4">
								<input class="form-control" required name="interessado" type="text"
									disabled
									value="${it.interessado}">
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputmatricula" class="col-sm-2 control-label">Matricula</label>
							<div class="col-sm-4">
								<input class="form-control" required name="matricula" type="text"
									disabled value="${it.matricula}">
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputtelefone"
								class="col-sm-2 control-label">Telefone</label>
							<div class="col-sm-4">
								<g:textField class="form-control" name="telefone"
									disabled value="${it.telefone}" />
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputdataemissao"
								class="col-sm-2 control-label">Data de Emissão</label>
							<div class="col-sm-4">
								<g:textField class="form-control" name="dataEmissao" 
									disabled value="${it.dataEmissao.format('dd/MM/yyyy')}" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputemail"
								class="col-sm-2 control-label">E-mail</label>
							<div class="col-sm-4">
								<g:textField class="form-control" name="email"
									disabled value="${it.email}" />
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputorgao"
								class="col-sm-2 control-label">Orgão</label>
							<div class="col-sm-4">
								<g:textField class="form-control" name="orgao"
									disabled value="${it.orgao.nome}" />
							</div>
						</div>
						<br>
                      <div>
							<div class="form-group">
								<label for="dataAgendamento" class="col-sm-2 control-label">Data
									de Agendamento</label>
								<div class="col-sm-4">
									<div class="input-group date" data-provide="datepicker">
										<input type="text" class="form-control" name="dataAgendamento"
											value="${it.dataAgendamento?.format('dd/MM/yyyy')}" />
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					<%--<script>  
					 $(document).ready(function () {
				            $('.datepicker').datepicker({
				            	format: 'dd/mm/yyyy',
				            	language: 'pt-BR'  				            	
				            });
				        });

				    </script>
				   	--%><br>
						<div class="form-group">
							<label for="problema"
								class="col-sm-2 control-label">Problema</label>
							<div class="col-sm-4">
								<textarea rows="5" cols="10" class="form-control" name="problema" placeholder="">${it.problema}</textarea>
								
							</div>
						</div>
						</br>
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
					</fieldset>
					<div style="margin: 0 17% auto">
						<button type="submit" class="btn btn-primary btn-flat">Atualizar</button>				
						<ul style="display: inline-block; margin-left: -30px">
							<li class="btn btn-default btn-flat"><a href="/sisOs/ordemDeServico/listarOrdemDeServico">Cancelar</a></li>
						</ul>
					</div>
				</g:form>
			</div>
		</div>
	</section>
</body>
</html>