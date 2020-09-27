
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author daohuxia
// */
//public class Tester {
//    
//    WebDriver dirver;
//    
//    @Given("^I have open browser$")
//    public void givenStatement()throws InstantiationException, IllegalAccessException{
//        Class<? extends WebDriver> driverClass=FirefoxDriver.class;
//        WebDriverManager.getInstance(driverClass).setup();
//        WebDriver driver = driverClass.newInstance();
//        driver.get("https://www.sina.com.cn/");
//        
//        System.out.println("Given statement executed successfully!");
//    }
//    
//    @When("^I visit website$")
//    public void whenStatement(){
//        driver.get("");
//    }
//    
//}
