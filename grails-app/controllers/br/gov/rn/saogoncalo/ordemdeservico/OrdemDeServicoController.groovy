package br.gov.rn.saogoncalo.ordemdeservico
import grails.converters.JSON

import java.util.Date
import java.text.DateFormat
import java.text.SimpleDateFormat

import javax.swing.RowFilter.AndFilter;

import org.grails.plugin.mail.*

class OrdemDeServicoController {

	def index() {}


	def salvarOrdemDeServico(){

		OrdemDeServico ordemDeServico = new OrdemDeServico(params)
		ordemDeServico.interessado = params.interessado
		ordemDeServico.matricula = params.matricula
		ordemDeServico.telefone = params.telefone
		ordemDeServico.email = params.email
		ordemDeServico.problema = params.problema
		//ordemDeServico.solucao = params.solucao
		ordemDeServico.dataEmissao =  new Date()
		//ordemDeServico.dataConclusao = ""
		def status = Status.get(1)
		ordemDeServico.status = status
		def orgao = Orgao.get(params.orgao)
		ordemDeServico.orgao = orgao

		  if (ordemDeServico.save(flush:true)){
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

		def orgao = Orgao.findAll()
		def status = Status.findAll()

		render(view:"/ordemDeServico/cadastrarOrdemDeServico.gsp", model:[orgao:orgao,status:status])

	}
	
	def editarOrdemDeServico(long id){
		
		OrdemDeServico ordemDeServico = OrdemDeServico.get(id)
		 def status = Status.findAll()
		render (view:"/ordemDeServico/editarOrdemDeServico.gsp", model:[ordemDeServico:ordemDeServico, status:status])
		
		
	}

	def atualizar(){
		
		def ordemDeServico = OrdemDeServico.get(params.id)
			ordemDeServico.solucao = params.solucao
			ordemDeServico.problema = params.problema
			//ordemDeServico.dataAgendamento = new Date()
			
			 if(params.dataAgendamento != ""){
			     ordemDeServico.dataAgendamento = Date.parse('dd/MM/yyyy', params.dataAgendamento)
			  
			   }
			def status = Status.get(params.status)
			
			ordemDeServico.status = status
			  if(ordemDeServico.status.id == 3){
			    ordemDeServico.dataConclusao = new Date()
			  }
			  
			  
			  if(ordemDeServico.save(flush:true)){
				  println(" passou ")
				EnviaEmailController envia = new EnviaEmailController()
				  if(ordemDeServico.status.id == 3  ){
					 
				   envia.enviaEmail(ordemDeServico.id)
				  }
				  
				  
				 redirect(controller:"ordemDeServico",action:"listarOrdemDeServico", params:[msg:"Ordem de servico atualizada com sucesso!", tipo:"ok"])
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
		def ordemDeServico = OrdemDeServico.executeQuery("select os from OrdemDeServico os where os.status.id <> 3 order by os.dataAgendamento ASC ")
		
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
		 
		}
		
		def orgao = Orgao.findAll()
		render(view:"/ordemDeServico/pesquisarOrdemDeServico.gsp", model:[ordens:ordens ,orgao:orgao])
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
		
		def homeGrafico(){
			
			def abertos = Status.get(1)
			def pendentes = Status.get(2)
			def concluidos = Status.get(3)
		   
			def tipoStatusAberto = OrdemDeServico.countByStatus(abertos)
			def tipoStatusPendente = OrdemDeServico.countByStatus(pendentes)
			def tipoStatusConcluido = OrdemDeServico.countByStatus(concluidos)
			def totalStatus = tipoStatusAberto + tipoStatusPendente +tipoStatusConcluido
			
			println("total de os abertas" +tipoStatusAberto)
			 render(view:"/ordemDeServico/homeGrafico.gsp", model:[tipoStatusAberto:tipoStatusAberto ,tipoStatusPendente:tipoStatusPendente , tipoStatusConcluido: tipoStatusConcluido,totalStatus:totalStatus])
			 
			 }
		
      }
		
		



	
			
             
	
	
	
        
      


	
	