<!DOCTYPE html>
<html lang="pt-br">
<head>
 <script src="/sisOs/js/jQuery/jQuery-2.1.3.min.js" type="text/javascript"></script>
 <script src="/sisOs/js/data.js"></script>
<title>Grafico</title>
<meta name="layout" content="public" />
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header" style="margin-left: 5%; margin-bottom:2px;">
		<h1>
			Painel <small>Estatisticas</small>
		</h1>
	    <br>
		<div id="navBar">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="/sisOs/ordemDeServico/listarOrdemDeServico"><strong>Listagem de Chamados</strong></a></li>
				<li role="presentation"><a href="/sisOs/ordemDeServico/cadastrarOrdemDeServico"><strong>Novo Chamado</strong></a></li>
				<li role="presentation"><a href="/sisOs/ordemDeServico/pesquisarOrdemDeServico"><strong>Pesquisar Os</strong></a></li>
				<li role="presentation"><a href="/sisOs/ordemDeServico/graficoOsSituacoes"><strong>Gráfico Os</strong></a></li>
			</ul>
		</div>
		<br>
		<script src="/sisOs/js/jQuery/Chart.min.js"></script>
     		 <style type="text/css">
		    .box {
		        margin: 0px auto;
		        width: 65%;
		        top:-175px;
		        margin-left:20%;
		    }
		
		    .box-chart {
		        width: 70%;
		        margin: 0 auto;
		        padding: 10px;
		    }

    		</style>
    		<g:form controller="ordemDeServico" action=" graficoOsSituacoes" class="form">
				<div class="form-group">
					<label for="graficoDataInicial" class="col-sm-2 control-label">Data
						de Inicial</label><br>
						<div style="margin-top:5px;">
					<div class="col-sm-2">
						<div class="input-group date" data-provide="datepicker">
							<input type="text" class="form-control" name="graficoDataInicial"
								value="${new Date().format('dd/MM/yyyy')}"/>
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
						</div>
					</div>
				</div>
			 </div>
			 <br>
			 <br>
			 <div class="form-group">
					<label for="graficoDataFinal" class="col-sm-2 control-label">Data
						de Final</label><br>
						<div style="margin-top:10px;">
					<div class="col-sm-2">
						<div class="input-group date" data-provide="datepicker">
							<input type="text" class="form-control" name="graficoDataFinal"
								value="${new Date().format('dd/MM/yyyy')}"/>
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
						</div>
					</div>
				</div>
			 </div>
			 <br>
			 <br>
			 <div style="margin-top:10px; margin-left:16px;">
				<button style="margin-top:10px;width:200px"type="submit" class="btn btn-primary btn-flat">
				  <i class="fa fa-pie-chart" aria-hidden="true"></i>Gerar Gráfico</button>
			  </div>	
			 </g:form>			
		<div class="box">
		<div style="margin-top:20px;margin-left: 20px;">
		<label>Total :${totalStatus}</label>
		</div>
			<div class="box-chart">
			<canvas id="GraficoPizza" style="width: 100%;"></canvas>
			<script type="text/javascript">
            
             var abertos =  ${tipoStatusAberto}
             var pendentes = ${tipoStatusPendente}
             var concluidos  = ${tipoStatusConcluido}
             var total = ${totalStatus}

             //grafico 
                var options = {
                        
                    responsive:true
                };

                var data = [
                            
                    {
                        value:abertos,
                        color:"#FF5A5E ",
                        highlight:"#FF3333",
                        label: "Abertos"
                    },
                    {
                        value:concluidos,
                        color: "#00994C",
                        highlight:"#336600",
                        label: "Concluidos"
                    },
                    {
                        value: pendentes,
                        color: "#FFC870",
                        highlight:"#FFA500",
                        label: "Pendentes"
                    },
                    
                ]
                
                window.onload = function(){
                    var ctx = document.getElementById("GraficoPizza").getContext("2d");
                    var PizzaChart = new Chart(ctx).Pie(data, options);
                        } 

            </script>
				<table
					style="position: absolute; top: 5px; right: 5px; font-size: smaller; color: #545454">
					<tbody>
						<tr>
							<td class="legendColorBox">
								<div style="border: 1px solid #ccc; padding: 1px">
									<div
								    style="width: 4px; height: 0; border: 5px solid #FF3333; overflow: hidden"></div>
								</div>
							</td>
							<td class="legendLabel">Abertos</td>
						</tr>
						<tr>
							<td class="legendColorBox"><div
									style="border: 1px solid #ccc; padding: 1px">
									<div
										style="width: 4px; height: 0; border: 5px solid #FFA500; overflow: hidden"></div>
								</div></td>
							<td class="legendLabel">Pendentes</td>
						</tr>
						<tr>
							<td class="legendColorBox">
								<div style="border: 1px solid #ccc; padding: 1px">
									<div
										style="width: 4px; height: 0; border: 5px solid #336600; overflow: hidden"></div>
								</div>
							</td>
							<td class="legendLabel">Concluidos</td>
						   </tr>
						  <tr>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	</body>
</html>