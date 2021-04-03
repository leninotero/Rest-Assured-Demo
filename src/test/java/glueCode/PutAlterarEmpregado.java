package glueCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import build.UserBuilders;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import reqres.ClientReqRes;

public class PutAlterarEmpregado {
	Properties p;
	public static Response response;
	private static ClientReqRes reqRes;
	
	@Before
	public static void init() {
		UserBuilders.setup();
		reqRes = new ClientReqRes();
	}
	
	@Dado("insiro as informacoes a serem alteradas")
	public void insiro_as_informacoes_a_serem_alteradas(io.cucumber.datatable.DataTable dataTable) {
		reqRes.buildBody(dataTable);
	}
	@Dado("infomo o id do empregado a ser alterado {int}")
	public void infomo_o_id_do_empregado_a_ser_alterado(int empregadoId) {
		reqRes.insertParameters(empregadoId);
	}
		
	@Quando("^faco uma requisao PUT no servico \"([^\"]*)\"$")
	public void faco_uma_requisao_PUT_no_servico(String servico) throws Throwable {	
		reqRes.userAuthentication();
		response = reqRes.sendPutRequest(servico);
		
	}
	
	@Entao("^devo validar as informacoes alteradas$")
	public void devo_validar_as_informacoes_alteradas() throws Throwable {	    
		assertEquals(202, response.getStatusCode(), "Valores n�o conferem");
		
		assertEquals(response.jsonPath().get("nome"), ClientReqRes.body.getNome());
		assertEquals(response.jsonPath().get("cargo"), ClientReqRes.body.getCargo());
		assertEquals(response.jsonPath().get("comissao"), ClientReqRes.body.getComissao());		
		assertEquals(response.jsonPath().get("sexo"), ClientReqRes.body.getSexo());
		
		// schema validation
		reqRes.eschemaValidation("./schema/editaSchema.json");
		
	}
}
