#language: pt
#utf-8

Funcionalidade: Deletar um funcionário

	@deletar_funcionario
	Cenario: Deletar Funcioário
	Dado que realizo a autenticação de acesso no endpoint do serviço
	E informo o id do funcionario a ser deletado 1234
	Quando faco uma requisicao DELETE no servico "/empregado/deletar/{empregadoId}"
	Entao devo validar o codigo do status 202