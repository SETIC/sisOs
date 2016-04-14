<!DOCTYPE html>
<html lang="pt-br">
<head>
 <script src="/sisOs/js/jQuery/jQuery-2.1.3.min.js" type="text/javascript"></script>
<title>Grafico</title>
<meta name="layout" content="public" />
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Painel <small>Estatisticas</small>
		</h1>
		<ol class="breadcrumb">
			<li><g:link controller="ordemDeServico" action="graficoOsSituacoes">
			<i class="fa fa-dashboard"></i> Inicio</g:link></li>
			<li class="active">Painel</li>
		</ol>
		<script src="/sisOs/js/jQuery/Chart.min.js"></script>
      <style type="text/css">
    .box {
        margin: 0px auto;
        width: 70%;
    }

    .box-chart {
        width: 70%;
        margin: 0 auto;
        padding: 10px;
    }

    </style>
		<div class="box">
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
                    {
                        value: total,
                        color: "#1E7AD0",
                        highlight: "#3333FF",
                        label: "Total"
                    }

                    
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
							<td class="legendColorBox"><div
									style="border: 1px solid #ccc; padding: 1px">
									<div
										style="width: 4px; height: 0; border: 5px solid #1E7AD0; overflow: hidden"></div>
								</div></td>
							<td class="legendLabel">Total</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	</body>
</html>