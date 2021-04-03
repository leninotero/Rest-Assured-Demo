package build;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.Constans;

public class UserBuilders {
	RequestSpecification requestSpecification;
	
			
	public static void setup() {
		RestAssured.baseURI = Constans.BASE_URL;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.requestSpecification = new RequestSpecBuilder()
					.setContentType(ContentType.JSON)
					.log(LogDetail.ALL)
					.build();
		
	}
	
	public static void terminate() {		
		RestAssured.responseSpecification = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
				//.log().body(true);
	}

	
}
