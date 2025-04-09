package Framework;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@IncludeEngines("cucumber")
@RunWith( Cucumber.class )
@CucumberOptions(features =
        {"classpath:features/"},
        plugin = {
                "pretty",
                "html:build/reports/cucumber"
                ,"json:build/reports/cucumber-tests/test.json"}
)
public class RunCucumberTest
{
}