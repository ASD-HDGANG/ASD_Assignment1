
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Memoona Anwar DZ
 */
@RunWith(Cucumber.class)
//@Cucumber.Options(format={"pretty","html:reports/test-report"},tags= "@smokeTest")
@CucumberOptions(
        features = {"src/test/java"},
        snippets = SnippetType.CAMELCASE)
public class CucumberRunnerTest {
}
