package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*To execute the scenarios, please insert the name of the scenario feature
 * @cadastrar_funcionario 
 * @listar_funcionarios"
 * @listar_um_funcionario 
 * @alterar_funcionario 
 * @deletar_funcionario
 */
@RunWith(Cucumber.class)
@CucumberOptions(		
		features = "classpath:features", tags="@listar_um_funcionario", 
		glue = {"glueCode"},
		plugin = { "pretty", "json:target/cucumber/report.json",
				 			"junit:target/cucumber/report.xml",
				 			"html:target/cucumber/report.html"},
		publish=true
	)

public class TestRunner {

}
