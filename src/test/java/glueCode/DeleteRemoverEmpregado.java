package glueCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import build.UserBuilders;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import reqres.ClientReqRes;

public class DeleteRemoverEmpregado {
	private static Response response;	
	private static ClientReqRes reqRes;
	
	@Before
	public static void init() {
		UserBuilders.setup();
		reqRes = new ClientReqRes();
	}
	

	@Dado("informo o id do funcionario a ser deletado {int}")
	public void informo_o_id_do_funcionario_a_ser_deletado(int empregadoId) {
		reqRes.insertParameters(empregadoId);
	}

	@Quando("faco uma requisicao DELETE no servico {string}")
	public void faco_uma_requisicao_delete_no_servico(String servico) {
	    response = reqRes.sendDeleteRequest(servico);
	}

	@Entao("devo validar o codigo do status {int}")
	public void devo_validar_o_codigo_do_status(Integer statusCode) {
		assertEquals(statusCode, response.getStatusCode(), "Valores n�o conferem");		
	}
}
