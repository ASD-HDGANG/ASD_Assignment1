
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester1 {

    WebDriver driver;

    @Given("^I have opened the browser$")
    public void givenStatment() throws InstantiationException, IllegalAccessException {

        Class<? extends WebDriver> driverClass = ChromeDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        //driver.get("https://maven-app-heroku.herokuapp.com/");						
        //driver.get("https://asd-demo-app1.herokuapp.com/");						
        //driver.get("https://asd-assignment-app.herokuapp.com/");						

        System.out.println("Given statement executed successfully");
    }

    @When("^I visit website$")
    public void whenStatement() {
        driver.get("https://asd-assignment-app.herokuapp.com/");
    }

    @Then("^website return Application Error$")
    public void thenStatment() {
        Assert.assertEquals("Application Error", driver.getTitle()); // need to match with the homepage title on html <head> section?
    }
}
