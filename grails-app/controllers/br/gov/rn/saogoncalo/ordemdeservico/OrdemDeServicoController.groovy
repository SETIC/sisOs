package br.gov.rn.saogoncalo.ordemdeservico
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
			def status = Status.get(params.status)
			ordemDeServico.status = status
			  if(ordemDeServico.status.id == 3){
				  
			     ordemDeServico.dataConclusao = new Date()
			  }
			  

               
			  if(ordemDeServico.save(flush:true)){
				EnviaEmailController envia = new EnviaEmailController()
				  if(ordemDeServico.status.id == 3  ){
				   envia.enviaEmail(ordemDeServico.id)
				  }
				 //redirect(controller:"ordemDeServico",action:"listarOrdemDeServico", params:[msg:"Ordem de servico atualizada com sucesso!", tipo:"ok"])
		     	//render(view:"/ordemDeServico/listarOrdemDeServico.gsp", model:[ordemDeServico:ordemDeServico])
				listarMensagem("Ordem de servico atualizada com  sucesso", "ok")
				
			}
		
	   }
	
	def listarOrdemDeServico(){
		def ordemDeServico = OrdemDeServico.findAll()
		render(view:"/ordemDeServico/listarOrdemDeServico.gsp", model:[ordemDeServico:ordemDeServico])

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
	
	
	}


