package br.gov.rn.saogoncalo.ordemdeservico

class UsuariosOsController {

    def index() { }
	
	def login(){
		
		render(view:"/usuariosOs/login.gsp")
		
	}
	
	def static usuario = null
	def static senha  = null
	
	def autenticar(){
	 	
		def user = params.usuario
		def pass = params.senha
		def user2 =  UsuariosOs.findByUsuarioAndSenha(user,pass)
		
		  if(user2.usuario != ""){
			  
			  session["user"] = user
			  session["pass"] = pass
			  
			  
			  //teste
			  
			def abertos = Status.get(1)
			def pendentes = Status.get(2)
			def concluidos = Status.get(3)
		   
			def tipoStatusAberto = OrdemDeServico.countByStatus(abertos)
			def tipoStatusPendente = OrdemDeServico.countByStatus(pendentes)
			def tipoStatusConcluido = OrdemDeServico.countByStatus(concluidos)
			def totalStatus = tipoStatusAberto + tipoStatusPendente +tipoStatusConcluido
			
			render(view:"/ordemDeServico/homeGrafico.gsp", model:[tipoStatusAberto:tipoStatusAberto ,tipoStatusPendente:tipoStatusPendente , tipoStatusConcluido: tipoStatusConcluido,totalStatus:totalStatus])
			
			  //------
			  
			  
			  //redirect(controller:params.ctl, action:params.act)
			  // render("view:/index.gsp")
		  }else{
		  
		  	render(view:"/usuariosOs/login.gsp", model:[erro:"O usuario ou a senha inseridos estao incorretos."])
		  }
		
	 }   
	   def logout(){
		   
	    session["user"] = null
		session["pass"] = null
		render(view:"/usuariosOs/login.gsp")
	} 
}
