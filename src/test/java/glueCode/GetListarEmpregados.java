package glueCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import build.UserBuilders;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import reqres.ClientReqRes;

public class GetListarEmpregados {	
	private static Response response;	
	private static ClientReqRes reqRes;
		
	@Before
	public static void init() {
		UserBuilders.setup();
		reqRes = new ClientReqRes();
	}
			
	@Dado("^que realizo a autenticação de acesso no endpoint do serviço$")
	public void que_realizo_a_autenticação_de_acesso_no_endpoint_do_serviço() throws Throwable {
		reqRes.initRequest();
		reqRes.userAuthentication();
	}
	
	@Dado("^passo por parametro o id do empregado (\\d+)$")
	public void passo_por_parametro_o_id_do_empregado(int empregadoId) throws Throwable {
		reqRes.insertParameters(empregadoId);
	}

	@Quando("^faco uma requisao GET no servico \"([^\"]*)\"$")
	public void faco_uma_requisao_GET_no_servico(String servico) throws Throwable {	
		response = reqRes.sendGetRequest(servico);
	}	

	@Entao("^devo validar o codigo de status (\\d+)$")
	public void devo_validar_o_codigo_de_status(int statusCode) throws Throwable {		
		assertEquals(statusCode, response.getStatusCode(), "Valores não conferem");
		
	}
}
