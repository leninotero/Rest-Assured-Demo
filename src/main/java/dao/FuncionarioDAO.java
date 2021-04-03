package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDAO {
	private String admissao;
	private String cargo;
	private String comissao;
	private String cpf;
	private int departamentoId;
	private String nome;
	private String salario;
	private String sexo;
	private String tipoContratacao;
	
	
}
