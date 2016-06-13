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

		if ((params.usuario == "123") && (params.senha == "123")) {
		    redirect(controller:params.ctl, action:params.act)
		}else{
			render(view:"/usuariosOs/login.gsp", model:[erro:"O usuario ou a senha inseridos estao incorretos."])
		}
		
	}
}
