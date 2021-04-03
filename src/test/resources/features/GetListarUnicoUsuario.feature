#language: pt
#utf-8

Funcionalidade: Listar um único Funcionario realizando a pesquisa por empregadoID

  @listar_um_funcionario
  Cenario: Listar Unico Funcionario
    Dado que realizo a autenticação de acesso no endpoint do serviço
    E passo por parametro o id do empregado 7
    Quando faco uma requisao GET no servico "/empregado/list/{empregadoId}"    
    Entao devo validar o codigo de status 202
