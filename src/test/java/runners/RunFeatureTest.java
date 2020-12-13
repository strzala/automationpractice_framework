package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue={"classpath:stepsDefinition", "/hooks"},
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        tags = ""
)
public class RunFeatureTest {

}

