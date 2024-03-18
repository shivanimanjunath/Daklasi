package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber" , glue="Tutorial.Framework.StepDefinition"
,monochrome=true ,tags="@Regressions" ,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunnerfile extends AbstractTestNGCucumberTests {
	

}
