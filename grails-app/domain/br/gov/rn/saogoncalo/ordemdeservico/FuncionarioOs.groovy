package br.gov.rn.saogoncalo.ordemdeservico

class FuncionarioOs {
	
	String matricula
	String nomeFuncionario
	String status
	
	static hasmany=[ordemDeServico:OrdemDeServico]
	
    
	static constraints = {
		matricula blank:false, nullable:false
		nomeFuncionario blank:false, nullable:false
		status blank:false, nullable:false
		
    }
	static mapping = {
		table name: "funcionario_os", schema:"administracao_ordem_de_servico"
		version false
		id generator: 'sequence', params:[sequence:'administracao_ordem_de_servico.funcionario_os_id_seq']
	}
}
