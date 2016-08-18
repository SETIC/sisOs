package br.gov.rn.saogoncalo.ordemdeservico

class UsuariosOs {
	
	String usuario
	String senha
	
	//static hasmany=[ordemDeServico:OrdemDeServico]
    static constraints = {
		
		usuario blank:false, nullable:false
		senha blank:false, nullable:false
    }
	
	static mapping ={
		table name: "usuarios_os", schema:"administracao_ordem_de_servico"
		version false
		id generator: 'sequence', params:[sequence:'administracao_ordem_de_servico.usuarios_os_id_seq']
		
		
	}
}
