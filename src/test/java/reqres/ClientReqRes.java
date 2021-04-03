package reqres;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.IOException;
import java.util.Properties;

import dao.FuncionarioDAO;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Utils;

public class ClientReqRes {
	Properties p;
	public static FuncionarioDAO body;
	private static Response response;	
	private static RequestSpecification request;

	public void initRequest() {
		request = RestAssured.given()
				.filter(new ResponseLoggingFilter(LogDetail.ALL));
	}
	
	public void userAuthentication() throws IOException {		
		p = Utils.getProp();		
		request.auth().basic(p.getProperty("usuario"), p.getProperty("senha"));			
	}
	
	public void buildBody(io.cucumber.datatable.DataTable dataTable) {
		body = new FuncionarioDAO();
		
		body.setAdmissao(dataTable.cell(0, 1));
		body.setCargo(dataTable.cell(1, 1));
		body.setComissao(dataTable.cell(2, 1));
		body.setCpf(dataTable.cell(3, 1));
		body.setDepartamentoId(Integer.parseInt(dataTable.cell(4, 1)));
		body.setSalario(dataTable.cell(6, 1));
		body.setTipoContratacao(dataTable.cell(8, 1));		
	}
	
	public void insertParameters(int parameter) {		
		request.with().pathParam("empregadoId", parameter);
	}
	
	public Response sendGetRequest(String pathRequest) {
		response = request.get(pathRequest);
		
		return response;
	}
	
	public Response sendPostRequest(String pathRequest) {
		response = request.body(body) 
				.post(pathRequest);
		
		return response;
	}
	
	public Response sendPutRequest(String pathRequest) {
		response = request.body(body) 
				.put(pathRequest);
		
		return response;
	}
	
	public Response sendDeleteRequest(String pathRequest) {
		response = request.delete(pathRequest);
		
		return response;
	}
	
	public void eschemaValidation(String path) {		
		response.then().and().body(matchesJsonSchemaInClasspath(path));
	}
	
}
