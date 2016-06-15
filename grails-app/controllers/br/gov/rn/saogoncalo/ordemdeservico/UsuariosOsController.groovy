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
		def user2 =  UsuariosOs.findByUsuarioAndSenha(params.usuario,params.senha)
		
		  if(user2.usuario!= ""){
			  session["user"] = user
			  session["pass"] = pass
			  redirect(controller:params.ctl, action:params.act)
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
