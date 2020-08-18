package myRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "/Users/easwarimuthu/IdeaProjects/CucumberAPI/src/test/java/Features/GetRequest.Feature"
        ,glue = {"stepDefinition"}
        ,plugin = {"pretty","html:target/cucumber"}
        ,dryRun = false
)

public class GetRequestRunner extends AbstractTestNGCucumberTests {
}
