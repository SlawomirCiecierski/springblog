package pl.myblog.springblog;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * zdefiniowanie parametrów scenariusza oraz raportu
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/pl.myblog.springblog/",
        plugin={"pretty", "html:cucumber"})
public class SpringblogApplicationTests {

}
