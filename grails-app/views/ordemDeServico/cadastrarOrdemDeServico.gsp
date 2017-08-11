<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastro de OS</title>
<meta name="layout" content="public2" />
<meta content="width=device-width, initial-scale=1" name="viewport">

</head>
<body>
<p id="alertVerificador" class="text-red"></p>
	<section class="content-header" style="margin-left: 5%; margin-bottom:auto;">
		<h1>
			Ordem De Serviço <small>Cadastro</small>
		</h1>

		<ul class="nav nav-tabs"> 
		<!--  <div style= "text-align:right;"><a href="/sisOs/usuariosOs/login.gsp">Acesso</a></div></ul> --> 
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
			<div style="margin-left: 150px">

				<g:form name="ordemDeServico" controller="ordemDeServico" action="salvarOrdemDeServico" class="form-horizontal">
					<fieldset>
					   <div class="alert alert-info"><strong>Aviso. </strong> A SETIC informa que o SisOS é de uso exclusivo para a abertura 
						  de suporte técnico do setor  de Tecnologia da Informação da Administração Municipal.
						</div>
						<script src="/sisOs/js/validarMatricula.js"></script>
						<div class="form-group">
							<label for="matricula" class="col-sm-2 control-label">Matricula</label> 
							<div class="col-sm-4">
								<input class="form-control" id="matricula" placeholder="Matricula do interessado" required name="matricula" type="text" value="" onblur="validarMatricula();"/>
								<font style="color: red;font-size: 0.88em;"><strong>* Matr&iacute;culas do SAAE, acrescentar "S" ao seu final, e IPREV "I" (Ex.: 1234S ou 1234I, respectivamente)</strong></font>
							</div>
								<p id="mensagemErro" class="text-red">${erro}</p>
						
							
						</div>
												
						<div class="form-group">
							<label for="interessado" class="col-sm-2 control-label">Interessado</label>
							<div class="col-sm-4">
								<input class="form-control" placeholder="Interessado" id="interessado" required name="interessado" type="text" value="">
							</div>
						</div>
						<br>


						<!-- Início - Script para formatar telefone -->
						<script src="/sisOs/js/FormatarTelefone.js"></script>
						<!-- Fim - Script para formatar telefone -->

						
						<script src="/sisOs/js/validaTelefone.js"></script>
						<div class="form-group">
							<label for="telefone" class="col-sm-2 control-label">Telefone</label>
							<div class="col-sm-4">
								<g:textField class="form-control" placeholder="Digite apenas números" id="telefone" name="telefone" value="" onkeypress="mascara(this,mtel);" onblur="validaTelefone(telefone);" maxlength="10"/>
							</div>
							<p id="mensagemErroTelefone" class="text-red">${erro}</p>
						</div>
						<br>

						<script src="/sisOs/js/validaEmail.js"></script>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">E-mail</label>
							<div class="col-sm-4">
								<g:textField type="email" class="form-control"
									placeholder="E-mail" id="email" name="email" value="" required="true"
									name="email" onblur="validaEMAIL(email)" />
							</div>
							<p id="mensagemErroEmail" class="text-red">${erro}</p>
						</div>
						<br>

						<div class="form-group">
							<label for="orgao" class="col-sm-2 control-label">Orgão</label>
							<div class="col-sm-6">
								<select name="orgao" id="comboorgao"
									class="form-control" data-size="5"
									data-live-search="true" onclick="habilitaCampo();" required>
									
									<option value="">Selecione um orgão</option>
									
									<g:each in="${orgao}">
										<option value="${it.id}">
											${it.nome}
										</option>
									</g:each>
								</select>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="problema" class="col-sm-2 control-label">Problema</label>
							<div class="col-sm-4">
								<textarea rows="4" cols="5" class="form-control" placeholder="Descreva o Problema" name="problema" required></textarea>
							</div>
						</div>
					</fieldset>
					<div style="margin: 0 17% auto">
						<button type="submit" class="btn btn-primary btn-flat">
							Salvar
						</button>
						<ul style="display: inline-block; margin-left: -30px">
							<li class="btn btn-default btn-flat"><a
								href="/sisOs/ordemDeServico/cadastrarOrdemDeServico/">Cancelar</a></li>
						</ul>
					</div>
				</g:form>
			</div>
		</div>
	</section>
</body>
</html>