package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\cucumber",glue="StepDefination"
,monochrome=true,tags="@Purchase",plugin= {"html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
