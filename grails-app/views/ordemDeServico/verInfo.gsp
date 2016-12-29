<!DOCTYPE html>
<html>
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
			
<script>

function printDiv(id)
{
  var divToPrint=document.getElementById(id);
  newWin= window.open("");
  newWin.document.write("<style=''>");

  newWin.document.write("<table border='0'>");
  newWin.document.write("<tr>");
  newWin.document.write("<td> <img src='${ request.getRequestURL().substring(0, request.getRequestURL().indexOf('sisOs/'))}sisOs/static/images/sga.png'; style='width:100px; float:left; margin-top:-9px;'> </td>");
  newWin.document.write("<td>");
  newWin.document.write("<p style='text-align:center; '>PREFEITURA MUNICIPAL DE SÃO GONÇALO DO AMARANTE - RN</p>");
  newWin.document.write("<p style='text-align:center; margin-top:-8px;'>SUBSECRETARIA DE TECNOLOGIA DA INFORMAÇÃO E CIÊNCIA - SETIC</p>");
  newWin.document.write("</td>");
  newWin.document.write("</tr>");
  newWin.document.write("</table><br>");
  newWin.document.write("<h4 style='text-align:center'>${session["escname"]}</h4><br/><br/>");
  newWin.document.write("<h4 style='margin-top:-38px; text-align:center'>INFORMAÇÕES DOS CHAMADOS</h4>");
  newWin.document.write("<hr>");
  newWin.document.write("<style type='text/css' >");
  newWin.document.write("#"+id+'{border:none; font-size: 12pt; }');
  newWin.document.write("body{font-family:Arial;}");
  newWin.document.write("img{margin-lefth: 10px;}");
  newWin.document.write("label{text-transform: uppercase; font-weight:bold; }");
  newWin.document.write("</style>");
  newWin.document.write(" ");
  newWin.document.write(divToPrint.outerHTML);
  var now = new Date();

  meses = new Array(12);

  meses[0] = "Janeiro";
  meses[1] = "Fevereiro";
  meses[2] = "Março";
  meses[3] = "Abril";
  meses[4] = "Maio";
  meses[5] = "Junho";
  meses[6] = "Julho";
  meses[7] = "Agosto";
  meses[8] = "Setembro";
  meses[9] = "Outubro";
  meses[10] = "Novembro";
  meses[11] = "Dezembro";
  
  newWin.document.write ("<center style='font-size:11px;'><br/>Gerado dia " + now.getDate() + " de " + meses[now.getMonth()] + " de " + now.getFullYear() + " às " + now.getHours()+":"+now.getMinutes()+"</center>");
  newWin.print();
  newWin.close();
}
</script>

	<section class="content-header">
		<h3>
			Chamados <small>Visualizar Dados</small>
		</h3>
		<ol class="breadcrumb">
			<li class="active"><g:link controller="Layout" action="index">
					<i class="fa fa-dashboard"></i> Inicio</g:link></li>
			<li><g:link controller="OrdemDeServico" action="verInfo">ordens de Serviço</g:link></li>
		</ol>
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
	
			<div style="margin-left: 190px">
				<g:form controller="OrdemDeServico" action="verInfo"
					class="form-horizontal">
					<g:hiddenField type="number" name="id" value="${ordem?.id}" />
					<fieldset id="print">
						<div class="form-group">
							<label for="inputNome3" class="col-sm-2 control-label">Situacão</label>
							<div class="col-s-10">
								<h5>${ordem.status.nome}</h5>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputNome3" class="col-sm-2 control-label">Interessado</label>
							<div class="col-s-10">
								<h5>${ordem.interessado}</h5>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputNome3" class="col-sm-2 control-label">Data de Emissão</label>
							<div class="col-s-10">
								<h5>${ordem.dataEmissao}</h5>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputDataInicio3" class="col-sm-2 control-label">Data
								de Agendamento</label>
							<div class="col-s-10">
								<h5><g:formatDate format="dd/MM/yyyy - HH:mm" date="${ordem.dataAgendamento}" /></h5>
							</div>
						</div>
						<br>
						
						<div class="form-group">
							<label for="inputCpfCnpj3" class="col-sm-2 control-label">Orgão</label>
							<div class="col-s-10">
								<h5>${ordem.orgao.nome}</h5>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="inputCpfCnpj3" class="col-sm-2 control-label">Telefone</label>
							<div class="col-sm-10">
								<h5>${ordem.telefone}</h5>
							</div>
						</div>
						<br>	
						<div class="form-group">
							<label for="inputCpfCnpj3" class="col-sm-2 control-label">Problema</label>
							<div class="col-sm-10">
								<h5>${ordem.problema}</h5>
							</div>
						</div>
						<br>					
					</fieldset>
					<div style="margin: 0 7% auto">
						<button class="btn btn-primary btn-flat"
							onClick="printDiv('print')">
							<i class="fa fa-print"></i> Imprimir
						</button>
						<ul style="display: inline-block; margin-left: -30px">
							<li class="btn btn-info btn-flat"><a style="color: #fff;"
								href="/sisOs/ordemDeServico/listarOrdemDeServico/">Voltar</a></li>
						</ul>
					</div>
				 </g:form>
			  </div>
		    </div>
	     </section>
  </body>
</html>