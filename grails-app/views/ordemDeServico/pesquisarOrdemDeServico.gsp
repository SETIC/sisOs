 <section class="content-header">
		<h1>
			Protocolo <small>Consulta de Documentos</small>
		</h1>
		<ol class="breadcrumb">
			<li class="active"><g:link controller="Layout" action="index">
					<i class="fa fa-dashboard"></i> Inicio</g:link></li>
		</ol>
		<br>
			<g:form controller="protocolo" action="pesquisarProtocolos" class="form">
			<div class="form-heading" style="width:150px;">
				<label>Tipo de Busca</label>
				<div class="controls">

					<select class="form-control selectpicker" id ="tipoBusca" name="tipoBusca" onchange = "mudarSelecao();">
						<option value="null">SELECIONE...</option>
						<option value="numero">NUMERO</option>
						<option value="data">DATA</option>
						<option value="setor">SETOR</option>
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
				<table id="pequisarprotocolo"
					class="table table-striped table-hover example">
					<thead>
						<tr>
							<th style="width:60px;padding-left:60px">Funções</th>
							<th>Número</th>
							<th>Data do Protocolo</th>
							<th>Data da Emissão</th>
							<th>Número do Documento</th>
							<th>Assunto</th>
							<th>Situação</th>
							<th>Interessado</th>
							
						</tr>
					</thead>
					<tbody>
						<g:each in='${protocolos?}'>
							<tr class='linha_registro'>
								<td>
									<div style="margin-left: 10px" class="opcoes">
										<ul style="display: inline">
											<li title="Ver detalhes do protocolo"
												class="btn btn-success btn-xs btn-flat"><a
												style="color: #fff"
												href="/projetoMetafora/protocolo/verInfoProtocolo/${it.protocolo_id}"><span
													class="glyphicon glyphicon-eye-open"></span></a></li> 
																					
											<g:if test="${ (it.funcionario_setor_destino_id == funcionarioSetorLogado[0].id)}">
												<li title="Editar protocolo" class="btn btn-primary btn-xs btn-flat"><a
													style="color: #fff"
													href="/projetoMetafora/Protocolo/editar/${it.protocolo_id}"><span
														class="glyphicon glyphicon-pencil"></span></a></li>
											</g:if>
										</ul>
									</div>
								</td>
								<td>
									${it.numero}
								</td>

								<td>
								    <g:formatDate type="datatime" style="MEDIUM" date="${it.data_disponibilizacao}" />
								</td>

								<td> 
									<g:formatDate type="datatime" style="MEDIUM" date="${it.data_recebimento}" />
								</td>

								<td>
									${it.numero_Documento}
								</td>

								<td>
									${it.assunto}
								</td>
								
								<td>
									${it.nome}
								</td>
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