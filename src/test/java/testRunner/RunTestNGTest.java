package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",glue={"com.qa.test2"})
public class RunTestNGTest extends AbstractTestNGCucumberTests {
	
}