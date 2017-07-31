package br.gov.rn.saogoncalo.ordemdeservico
import grails.converters.JSON
import grails.plugin.rendering.*

import java.text.SimpleDateFormat
import javax.mail.Header;



class OrdemDeServicoController {

	def index() {}
	

	
	/*RenderingService pdfRenderingService
	  
	  def gerarPdf() {
		  
		  
		 
		 ByteArrayOutputStream bytes = pdfRenderingService.render(template: "/pdf/teste", controller:"OrdemDeServico")
		  def fos= new FileOutputStream('listagemDeOs.pdf')
			fos.write(bytes.toByteArray())
			fos.close()
			
		     renderPdf(template: "/pdf/teste")
		  
		   print("passou pelo metodo") 
					  
		  }*/
	
	

	def salvarOrdemDeServico(){

		OrdemDeServico ordemDeServico = new OrdemDeServico(params)
	    ordemDeServico.interessado = params.interessado
		ordemDeServico.matricula = params.matricula
		//def matriculasOS = FuncionarioOs.findByMatricula(params.matricula)
		  def matriculasOS = FuncionarioOs.findByMatricula(params.matricula)
		
		ordemDeServico.telefone = params.telefone
		ordemDeServico.email = params.email
		ordemDeServico.problema = params.problema
		ordemDeServico.dataEmissao =  new Date()
		def status = Status.get(1)
		ordemDeServico.status = status
		def orgao = Orgao.get(params.orgao)
		ordemDeServico.orgao = orgao
		ordemDeServico.funcionarioOs = matriculasOS
		
		def lastOs = OrdemDeServico.executeQuery(" select os from OrdemDeServico os " +
												 " ORDER BY os.id desc")
				
		def num = lastOs[0].codLaudo
		
		ordemDeServico.codLaudo = num+1
		def usuariosOs = UsuariosOs.get(1)
		ordemDeServico.usuariosOs = usuariosOs
		
		  if (ordemDeServico.save(flush:true)){
			  
			  TecnicoOs tecnicoOs = new TecnicoOs()
			  tecnicoOs.ordemDeServico = ordemDeServico
			  tecnicoOs.usuariosOs = usuariosOs
			  //tecnicoOs.descricao = ""
			  tecnicoOs.save(flush:true)
			   
			  
			  EnviaEmailController envia = new EnviaEmailController()
			  envia.enviaEmail(ordemDeServico.id)

			  listarMensagem("Ordem de servico salva com  sucesso", "ok")
			  //redirect(controller:"OrdemDeServico", action:"cadastrarOrdemDeServico", params:[msg: "Chamado cadastrado com sucesso.", tipo:"ok"])
			  
		  }else{
		  
		  def erros
		  ordemDeServico.errors.each { erros = it }
		  print("erros aqui: "+erros)
			  
		render(view:"/error.gsp")
		  }
	     } 
     
	def cadastrarOrdemDeServico(){

		def orgao = Orgao.executeQuery("select o from Orgao o where o.situacao = 'ATIVO' order by o.nome")
		def status = Status.findAll()

		render(view:"/ordemDeServico/cadastrarOrdemDeServico.gsp", model:[orgao:orgao,status:status])

	}
	
	def editarOrdemDeServico(long id){
		
		OrdemDeServico ordemDeServico = OrdemDeServico.get(id)
		def usuariosOs = UsuariosOs.findAll()
		def tecnicosOs = TecnicoOs.findAllByOrdemDeServico(ordemDeServico)

				
		if (tecnicosOs.usuariosOs.id == [0,1]){
			
			tecnicosOs = TecnicoOs.get(session["userId"])
		}
		
		 def status = Status.findAll()
		render (view:"/ordemDeServico/editarOrdemDeServico.gsp", model:[ordemDeServico:ordemDeServico, status:status, usuariosOs:usuariosOs, tecnicosOs:tecnicosOs])
		
	}

	def atualizar(){
		
		def ordemDeServico = OrdemDeServico.get(params.id)
			ordemDeServico.solucao = params.solucao
			ordemDeServico.problema = params.problema
			//ordemDeServico.dataAgendamento = new Date()
			def usuariosOs = UsuariosOs.get(session["userId"])
			ordemDeServico.usuariosOs = usuariosOs
			
			 if(params.dataAgendamento != ""){
			     ordemDeServico.dataAgendamento = Date.parse('dd/MM/yyyy', params.dataAgendamento)
			  
			   }
			def status = Status.get(params.status)
			
			ordemDeServico.status = status
			  if(ordemDeServico.status.id == 3){ 
			    ordemDeServico.dataConclusao = new Date()
			  }
			  

			
			  def tot = TecnicoOs.findAllByOrdemDeServico(ordemDeServico)
			  if (tot.isEmpty()){
			  
				  params.tecnicosOs.each{
					  TecnicoOs to = new TecnicoOs()
					  def userOs = UsuariosOs.get(it)
					  to.ordemDeServico = ordemDeServico
					  to.usuariosOs = userOs
					  to.save(flush:true)
				  }
  
			  }else{
			  		
			  			params.tecnicosOs.each{
						  
						def usuarioOsBanco = UsuariosOs.get(it)   
						def tecnicosBanco = TecnicoOs.findAllByOrdemDeServicoAndUsuariosOs(ordemDeServico,usuarioOsBanco)
						if (tecnicosBanco?.isEmpty()){
							
							TecnicoOs to = new TecnicoOs()
							def userOs = UsuariosOs.get(it)
							to.ordemDeServico = ordemDeServico
							to.usuariosOs = userOs
							to.save(flush:true)
							
						}
						  
					  }
					  
						 
					 tot.each{
						
						 def idTec = it.usuariosOs.id
						 //println("IT -- " + it.usuariosOs.id + " params -- " + params.tecnicosOs + " em  -- " + params.tecnicosOs.findAll{it == idTec.toString()} )
																	  
						if (params.tecnicosOs.findAll{it == idTec.toString()} == []){
							TecnicoOs.deleteAll(it)
							//println(" Deletar -- " + it)
						 }

						 
					 }
					 
			  }
			  
			  
			  
			  
			  if(ordemDeServico.save(flush:true)){
				EnviaEmailController envia = new EnviaEmailController()
				  if(ordemDeServico.status.id == 3 ){
					 
				   envia.enviaEmail(ordemDeServico.id)
				  }
				  
				  
				 redirect(controller:"ordemDeServico", action:"listarOrdemDeServico", params:[msg:"Ordem de servico atualizada com sucesso!", tipo:"ok"])
		     	//render(view:"/ordemDeServico/listarOrdemDeServico.gsp", model:[ordemDeServico:ordemDeServico])
				//listarMensagem("Ordem de servico atualizada com  sucesso", "ok")
				
			}else{
			
			def erros
			ordemDeServico.errors.each { erros = it }
			print("erros aqui: "+erros)
			}
		
	   }
	
	def listarOrdemDeServico(String msg, String tipo){
		
	if(session["user"] != null){
		
		msg = params.msg
		tipo = params.tipo
		def ordemDeServico = OrdemDeServico.executeQuery(" select oss from OrdemDeServico as oss where oss.status.id <> 3 order by oss.dataAgendamento ASC  ")
	   	//def oss = OrdemDeServico.findAll()
		
		render(view:"/ordemDeServico/listarOrdemDeServico.gsp", model:[ordemDeServico:ordemDeServico, ok:msg,tipo:tipo])
		}else{
		render(view:"/usuariosOs/login.gsp")
		}
	}
	
	def deletar(long id){
		
		OrdemDeServico.deleteAll(OrdemDeServico.get(id))
		def ordemDeServico = OrdemDeServico.findAll()
		redirect(action:"listarOrdemDeServico", params:[msg:"Deletado com sucesso!", tipo:"ok"])
			//redirect(action:"listarOrdemDeServico")
		
	}
	
	def listarMensagem(String msg, String tipo){
		      
		def orgao = Orgao.findAll()
				if (tipo == "ok"){
					
				    render(view:"/ordemDeServico/cadastrarOrdemDeServico.gsp", model:[ok:msg,orgao:orgao])
					//render(view:"/cadastrarOrdemDeServico.gsp", model:[ok:msg,orgao:orgao])
					
					
					
				}else{
				
                    render(view:"/error.gsp")	             
				  }
		  }
	
	
	def pesquisarOrdemDeServico(){
		
		if(session["user"] != null){

		def ordens = []
		
		switch(params.tipoBusca){
			case 'orgao':
				ordens = OrdemDeServico.findAllByOrgao(Orgao.get(params.orgao))
				break;
			case 'interessado':
				ordens = OrdemDeServico.findAllByInteressadoIlike ("%"+params.interessado+"%")
				break;
				
				
			case 'status':
			   ordens  = OrdemDeServico.findAllByStatus(Status.get(params.status))
			   break;
			   print ("status aki " +params)	
				
				
			case 'data':
				
				def dataI = params.dataInicial.replaceAll("-", "")
				def dataF = params.dataFinal.replaceAll("-", "")

				def anoI = dataI.substring(0, 4)
				def mesI = dataI.substring(4, 6)
				def diaI = dataI.substring(6, 8)
				
				def anoF = dataF.substring(0, 4)
				def mesF = dataF.substring(4, 6)
				def diaF = dataF.substring(6, 8)
				

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String datainicial = diaI+"/"+mesI+"/"+anoI;
				String datafinal = diaF+"/"+mesF+"/"+anoF;
				
				Date dateformatteri = formatter.parse(datainicial);
				Date dateformatterf = formatter.parse(datafinal);	
						
				
				ordens = OrdemDeServico.findAllByDataEmissaoBetween(dateformatteri, dateformatterf)
				break;
				
				
			case 'dataAgendamento':
				println("Data do params - " + params.dataAgendamento)
			    def dataAgendamentoI = params.dataAgendamento.replaceAll("-", "")
				
				def anoI = dataAgendamentoI.substring(0, 4)
				def mesI = dataAgendamentoI.substring(4, 6)
				def diaI = dataAgendamentoI.substring(6, 8)
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String dataAgendamento = diaI+"/"+mesI+"/"+anoI;
				Date dateformatteri = formatter.parse(dataAgendamento);
				
				println("data de agendamento --- "+dataAgendamento)
				println("data de agendamento depois --- "+dateformatteri.toString())
	            			
				def st = Status.get(1)
				def st2 = Status.get(2)
				ordens = OrdemDeServico.findAllByDataAgendamentoAndStatusInList(dateformatteri,[st,st2])
				break;	
			
			case 'matricula':
				
			    //alteração saae e iprev 
				//ordens = OrdemDeServico.findAllByMatriculaIlike ("%"+params.matricula+"%")
				ordens = OrdemDeServico.findAllByMatricula(params.matricula)
				break;
		 
		}
		
		def orgao = Orgao.findAll()
		def status = Status.findAll()
		   
		 render(view:"/ordemDeServico/pesquisarOrdemDeServico.gsp", model:[ordens:ordens ,orgao:orgao , status:status])
		  
		 }
	
		 else{
	    render(view:"/usuariosOs/login.gsp")
	      } 
	   }
	
	    def graficoOsSituacoes(){
			
			if(session["user"] != null){
			
			def graficoDataInicial = new Date()
			if (params.graficoDataInicial != null) {
				graficoDataInicial = new Date().parse("dd/MM/yyyy", params.graficoDataInicial)
			}else{
				println("Vazio Inicial")
			}
			
			def graficoDataFinal = new Date()
			if (params.graficoDataFinal != null) {
				graficoDataFinal = new Date().parse("dd/MM/yyyy", params.graficoDataFinal)
			}else{
				println("Vazio Final")
			}
			 
			def abertos = Status.get(1)
			def pendentes = Status.get(2)
			def concluidos = Status.get(3)
		   
			def tipoStatusAberto = OrdemDeServico.countByDataEmissaoBetweenAndStatus(graficoDataInicial,graficoDataFinal,abertos)
			def tipoStatusPendente = OrdemDeServico.countByDataEmissaoBetweenAndStatus(graficoDataInicial,graficoDataFinal,pendentes)
			def tipoStatusConcluido = OrdemDeServico.countByDataEmissaoBetweenAndStatus(graficoDataInicial,graficoDataFinal,concluidos)
		    def totalStatus = tipoStatusAberto + tipoStatusPendente +tipoStatusConcluido
			 render(view:"/ordemDeServico/graficos.gsp", model:[tipoStatusAberto:tipoStatusAberto ,tipoStatusPendente:tipoStatusPendente , tipoStatusConcluido: tipoStatusConcluido,totalStatus:totalStatus])
			 } 
		    else{
			render(view:"/usuariosOs/login.gsp")
			}
	     }
		
		
		def validarMatriculaFuncOs(String matriculasOS){
			
			boolean verifMatricula
			def result
			def resultado
		   
			FuncionarioOs  matriculav  = FuncionarioOs.findByMatricula(matriculasOS)
			//FuncionarioOs  matriculav  = FuncionarioOs.executeQuery("select f from FuncionarioOs f where f.matricula = '11486'")
	
			print(" Funcionario: " + matriculav)
			 
			 if(matriculav == null){
				  resultado =  ["id":0, "nome":""]
			 }else{
			  
			   resultado = ["id":matriculav.id, "nome":matriculav.nomeFuncionario]
			  
			  }


			  result = resultado
			
			render (result as JSON)
		        }
		
		
		
		def verInfo(long id){
	              
					OrdemDeServico ordem = OrdemDeServico.get(id)
					def orgao = Orgao.findAll()
				    def status = Status.findAll()
 					def tecnicosOs = TecnicoOs.findAllByOrdemDeServico(ordem)
					 
					def data1 = ordem.dataEmissao
					def data2 = ordem.dataConclusao
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					
					def usuarios = UsuariosOs.findAll()
					
					def dataFormatada
					
					if (data2 != null){
						
						dataFormatada = getDiffernceInDates(data1, data2)
						//println(" Data -- " + data3)

					}					 
	
					render (view:"/ordemDeServico/verInfo.gsp", model:[ordem:ordem, orgao:orgao, status:status, tecnicosOs:tecnicosOs, dataFormatada:dataFormatada, usuarios:usuarios])
			
		}
		
		def homeGrafico(){
			
			def abertos = Status.get(1)
			def pendentes = Status.get(2)
			def concluidos = Status.get(3)
		   
			def tipoStatusAberto = OrdemDeServico.countByStatus(abertos)
			def tipoStatusPendente = OrdemDeServico.countByStatus(pendentes)
			def tipoStatusConcluido = OrdemDeServico.countByStatus(concluidos)
			def totalStatus = tipoStatusAberto + tipoStatusPendente +tipoStatusConcluido
			
			render(view:"/ordemDeServico/homeGrafico.gsp", model:[tipoStatusAberto:tipoStatusAberto ,tipoStatusPendente:tipoStatusPendente , tipoStatusConcluido: tipoStatusConcluido,
				   totalStatus:totalStatus])
			   }
			 
			 
		RenderingService pdfRenderingService

		def gerarPDF(){
	
/*	def msg = "ok"
	def tipo = "ok"
	def ordemDeServico = OrdemDeServico.executeQuery("select os from OrdemDeServico os where os.status.id <> 3 order by os.dataAgendamento ASC ")
		
	println("teste aqui!")
	
	render( filename: "teste.pdf",
		view:"/ordemDeServico/listarOrdemDeServico",
		model:[ordemDeServico:ordemDeServico, ok:msg,tipo:tipo],
		header:"teste",
		footer:"teste",
		marginLeft:20,
		marginTop:35,
		marginBottom:20,
		marginRight:20,
		headerSpacing:10)
*/
	
	
	def os = OrdemDeServico.findAll()
	//HTML htm = new HTML() 
	def htm
	
	//ByteArrayOutputStream bytes = pdfRenderingService.render(template: "teste", controller:"OrdemDeServico")
	ByteArrayOutputStream bytes = pdfRenderingService.render(template: "teste2", controller:"OrdemDeServico")
	def fos = new FileOutputStream('listagemDeOs.pdf')
	  fos.write(bytes.toByteArray())
	  fos.close()
	  
	  htm = ("<table border='1'><tr><td>Orgao</td><td>Situação</td><td>Interessado</td><td>Problema</td></tr><tr><td>1</td><td>2</td><td>3</td><td>4</td></tr></table>")
	 	  
	   //renderPdf(template: "teste", model:[os:os])
	  renderPdf(template: "teste2", model:[htm:htm, html1:params.html1])
	  //renderPdf(template: "teste2", text:htm, contentType:"text/html, encoding:"UTF-8")
	   print("passou pelo metodo")
	
	
}
      
		
		def getOrdemDeServicoById(long id){
			
			def os= OrdemDeServico.findById(id)
			def result = ["id":os.id, "dataEmissao":os.dataEmissao, "email":os.email, "interessado":os.interessado, "matricula":os.matricula, "orgao":os.orgao.nome,
						  "problema":os.problema, "solucao":os.solucao, "status":os.status.nome, "dataAgendamento":os.dataAgendamento, "funcionario":os.funcionarioOs.nomeFuncionario,
						  "codLaudo":os.codLaudo]
						
			render (result as JSON)
			
		}
		
		
		public static Map getDiffernceInDates(Date oldDate, Date newDate = new Date()) {
			Long difference = newDate.time - oldDate.time
			Map diffMap =[:]
			difference = difference / 1000
			diffMap.seconds = difference % 60
			difference = (difference - diffMap.seconds) / 60
			diffMap.minutes = difference % 60
			difference = (difference - diffMap.minutes) / 60
			diffMap.hours = difference % 24
			difference = (difference - diffMap.hours) / 24
			diffMap.years = (difference / 365).toInteger()
			if(diffMap.years)
			   difference = (difference) % 365
			diffMap.days = difference % 7
			diffMap.weeks = (difference - diffMap.days) / 7
			return diffMap
		  }
		
		
		def salvarLaudo(int osId){
			
			
			def os
			os = OrdemDeServico.get(osId.toInteger())
			def vOsLaudo 
			vOsLaudo = Laudo.findAllByOrdemDeServico(os)
			
			if (vOsLaudo.empty)
			 {
				 def laudo = new Laudo()
				 //laudo.numero = 0 
				 laudo.ordemDeServico = os
				 laudo.ativo = "ATIVO"
				 laudo.save(flush:true)
				 println("laço")
			 }
			
			 
			//chamada da view com o laudo e as informações da os
			//render(view:"/ordemDeServico/laudo.gsp", model:[laudo:laudo])
				
			
		}
		
		
}	
		



	
			
             
	
	
	
        
      


	
	