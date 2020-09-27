/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *
 * @author yike8
 */
public class Tester {
    WebDriver driver;

    @Given("^I have opened the Firefox browser$")
    public void givenStatement() throws Throwable {
        Class<? extends WebDriver> driverClass = FirefoxDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        driver.get("https://asd-demo-opal.herokuapp.com/");
        //driver.navigate().to(driver.getCurrentUrl());
    }
    
    @When("^I visit the smart card management page$")
    public void whenStatement() throws Throwable {
        driver.get("https://asd-demo-opal.herokuapp.com/login.jsp");
        driver.navigate().to(driver.getCurrentUrl());
        
    }
 
    @Then("^I visit the smart card management page$")
     public void login_button_enabled() throws Throwable {
     driver.findElement(By.name("email")).sendKeys("jimmy@gmail.com");
     driver.findElement(By.name("password")).sendKeys("1234");
     driver.findElement(By.name("login")).click();
    
}
     @Then("^Activated button enabled$")
     public void Activated_button_enabled() throws Throwable {

     driver.findElement(By.name("activated")).click();
     
}
}
