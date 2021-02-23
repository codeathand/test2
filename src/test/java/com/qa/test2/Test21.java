package com.qa.test2;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test21 {
	
	protected static WebDriver driver;
	Selectors selectors = new Selectors(driver);
	
	@Given("Load Chrome driver and open page")
	public void load_driver() {
		selectors.loadDriver();
		selectors.openPage();
	}
 
	@When("Click on Filters button")
	public void something_is_done() {
	    System.out.println("Click on Filters button");
	    selectors.clickOnFilters();
	    selectors.validateFilterText();
	}
 
	@Then("Verify that 100 results are displayed")
	public void something_is_expected() {
	    System.out.println("Verify that 100 results are displayed");
	    selectors.validateShowRows();
	}
}