package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "@target/rerun.txt",
        glue={"classpath:stepsDefinition", "/hooks"},
        plugin = {"pretty",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber.json"}
)
public class RunFailedScenariosTest {
}
