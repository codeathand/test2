package com.qa.test2;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test22 {
	
	protected static WebDriver driver;
	Selectors selectors = new Selectors(driver);
	
	@Given("Load Chrome driver and open page2")
	public void load_driver() {
		System.out.println("Load Chrome driver and open page2");
		selectors.loadDriver();
		selectors.openPage();
	}
 
	@When("Filter no more than 10 results by price range")
	public void filter_by_price() {
	    System.out.println("Filter no more than 10 results by price range");
	    selectors.clickOnFilters();
	    selectors.selectPrice();
	    selectors.selectPriceRange();
	}
	
	@And("Filter no more than 5 results by volume range")
	public void filter_by_volumes() {
	    System.out.println("Filter no more than 5 results by volume range");
	    selectors.selectVolume();
	    selectors.selectVolumeRange();
	}
 
	@Then("Add to Watchlist and open Watchlist page")
	public void something_is_expected() throws InterruptedException {
	    System.out.println("Add to Watchlist and open Watchlist page");
	    selectors.addToWatchlist();
	}
	
	@And("Verify that filtered items are in the Watchlist")
	public void validate_watchlist() throws InterruptedException {
	    System.out.println("Verify that filtered items are in the Watchlis");
	    selectors.openWatchlist();
	}
}