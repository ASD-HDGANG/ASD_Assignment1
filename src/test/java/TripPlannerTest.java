
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daohuxia
 */
public class TripPlannerTest {
@Given("^user navigates to SOFTWARETETINGHELP.COM$")
public void navigatePage() {
System.out.println("Cucumber executed Given statement");
}
@When("^trip logs in using Departure as \"(.*)\" and Destination \"(.*)\"$")
public void search(String departure,String destination) {
System.out.println("Departure is:"+ departure);
System.out.println("Destination is:"+ destination);
}
@When("^click the Search button$")
public void clickTheSearchButton() {
System.out.println("Executing When statement");
}
@Then("^Google page should be displayed$")
public void validatePage() {
System.out.println("Executing Then statement");
}
@Then("^Google should be successful$")
public void validateSearchSuccess() {
System.out.println("Executing 2<sup>nd</sup> Then statement");
}
}
    

