#language: pt
#utf-8

Funcionalidade: Listar Todos os Funcionários Cadastrados

  @listar_funcionarios
  Cenario: Listar Todos Funcionários
    Dado que realizo a autenticação de acesso no endpoint do serviço
    Quando faco uma requisao GET no servico "/empregado/list_all"
    Entao devo validar o codigo de status 200