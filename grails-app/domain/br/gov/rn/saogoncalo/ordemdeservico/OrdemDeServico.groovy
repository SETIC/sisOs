package br.gov.rn.saogoncalo.ordemdeservico

class OrdemDeServico {
	
	String interessado
	Date dataEmissao
	Date dataConclusao
	Date dataAgendamento
	String matricula
	String telefone
	String email
	String problema
	String solucao
	long codLaudo
	
	static belongsTo = [status:Status, orgao:Orgao, funcionarioOs:FuncionarioOs, usuariosOs:UsuariosOs]
	static hasMany = [tecnicoOS:TecnicoOs]
	
	static constraints = {
		interessado blank:false, nullable:false
		dataEmissao blank:false, nullable:false
		dataConclusao blank:true, nullable:true 
		problema blank:false, nullable:false
		solucao blank:true, nullable:true
		email blank:false, nullable:false
		matricula blank:false, nullable:false
		telefone blank:false, nullable:false
		dataAgendamento blank:true, nullable:true
		codLaudo blank:true, nullable:true


	}
	
	static mapping = {
		table name: "ordem_de_servico", schema:"administracao_ordem_de_servico"
		version false
		id generator: 'sequence', params:[sequence:'administracao_ordem_de_servico.ordem_de_servico_id_seq']
	}
}