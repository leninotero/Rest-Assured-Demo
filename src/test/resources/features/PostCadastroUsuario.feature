#language: pt
#utf-8
Funcionalidade: Cadastrar um novo funcionário

  @cadastrar_funcionario
  Esquema do Cenario: Cadastrar Funcionário
    Dado que valido o payload a ser enviado com os dados
      | admissao        | <admissao_input>        |
      | cargo           | <cargo_input>           |
      | comissao        | <comissao_input>        |
      | cpf             | <cpf_input>             |
      | departamentoId  | <departamentoId_input>  |
      | nome            | <nome_input>            |
      | salario         | <salario_input>         |
      | sexo            | <sexo_input>            |
      | tipoContratacao | <tipoContratacao_input> |
    E que realizo a autenticação de acesso no endpoint do serviço
    Quando faco uma requisao POST no servico "/empregado/cadastrar"
    Entao devo capturar ID gerado pro novo funcionario

    Exemplos: 
      | admissao_input | cargo_input        	| comissao_input | cpf_input      | departamentoId_input | nome_input  			| salario_input | sexo_input 	| tipoContratacao_input |
      | 12/01/2010     | Especialista Testes 	|         500,00 | 660.196.670-30 |                    1 | Automacao nova  	|      12.500,00 | m       		| clt                   |
