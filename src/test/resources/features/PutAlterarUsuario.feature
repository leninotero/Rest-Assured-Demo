#language: pt
#utf-8
Funcionalidade: Alterar Funcionário realizando a pesquisa por empregadoID

  @alterar_funcionario
  Esquema do Cenario: Alterar Funcionário
    Dado insiro as informacoes a serem alteradas
      | admissao        | <admissao_input>        |
      | cargo           | <cargo_input>           |
      | comissao        | <comissao_input>        |
      | cpf             | <cpf_input>             |
      | departamentoId  | <departamentoId_input>  |
      | nome            | <nome_input>            |
      | salario         | <salario_input>         |
      | sexo            | <sexo_input>            |
      | tipoContratacao | <tipoContratacao_input> |
    E infomo o id do empregado a ser alterado 7
    Quando faco uma requisao PUT no servico "/empregado/alterar/{empregadoId}"
    Entao devo validar as informacoes alteradas

    Exemplos: 
      | admissao_input | cargo_input        			| comissao_input | cpf_input      | departamentoId_input | nome_input  		| salario_input 	| sexo_input | tipoContratacao_input |
      | 04/03/2021     | Automatizador Senior III |         100,00 | 006.939.437-77 |                    1 | Helber Ribeiro |      11.000,00 	| m          | pj                   |
