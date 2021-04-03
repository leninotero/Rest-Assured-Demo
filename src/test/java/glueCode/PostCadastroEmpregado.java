package glueCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import build.UserBuilders;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import reqres.ClientReqRes;

public class PostCadastroEmpregado {	
	private int empregadoID;
	public static Response response;
	private static ClientReqRes reqRes;
	
	@Before
	public static void init() {
		UserBuilders.setup();
		reqRes = new ClientReqRes();
	}
	
	@Dado("que valido o payload a ser enviado com os dados")
	public void que_valido_o_payload_a_ser_enviado_com_os_dados(io.cucumber.datatable.DataTable dataTable) {
		reqRes.initRequest();
		reqRes.buildBody(dataTable);
		
	}

	@Quando("^faco uma requisao POST no servico \"([^\"]*)\"$")
	public void faco_uma_requisao_POST_no_servico(String servico) throws Throwable {
		reqRes.userAuthentication();
		response = reqRes.sendPostRequest(servico);
	}

	@Entao("^devo capturar ID gerado pro novo funcionario$")
	public void devo_capturar_ID_gerado_pro_novo_funcionario() throws Throwable {	
		
		assertEquals(response.jsonPath().get("cpf"), ClientReqRes.body.getCpf());
		assertEquals(response.jsonPath().get("cargo"), ClientReqRes.body.getCargo());
		assertEquals(response.jsonPath().get("nome"), ClientReqRes.body.getNome());
		assertEquals(response.jsonPath().get("sexo"), ClientReqRes.body.getSexo());
		assertEquals(response.jsonPath().get("tipoContratacao"), ClientReqRes.body.getTipoContratacao());
		assertEquals(response.getStatusCode(), 202);

		empregadoID = response.jsonPath().get("empregadoId");
		System.out.println("ID do Empregado: " + empregadoID);
		
		// schema validation
		reqRes.eschemaValidation("./schema/cadastroSchema.json");
	}
}
