package com.qa.test2;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selectors {
	
	/** Timeout for waiting element **/
	int timeoutInSeconds = 3;
	
	protected static WebDriver driver;
	
	List<String> watchlistItems = new ArrayList<String>();
	
	/** Locators **/
	private By filtersButton = By.className("table-control-filter");
	private By allCryptocurrencies = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[1]/div/span/div/button");
	private By showRows = By.className("table-control-page-sizer");
	private By table = By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr[not(contains(@class, 'fENxkl'))]");
	
	private By logIn = By.xpath("//button[contains(text(), 'Log In')]");
	private By email = By.xpath("//*[@id=\"__next\"]/main/form/div[2]/input");
	private By password = By.xpath("//*[@id=\"__next\"]/main/form/div[5]/input");
	private By submitCredentials = By.xpath("//*[@id=\"__next\"]/main/form/button");
	private By price = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[3]/span/div/button");
	private By priceFrom = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div/div/div/div[1]/input[1]");
	private By priceTo = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div/div/div/div[1]/input[2]");
	private By applyPrice = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div/div/div/div[3]/div/button[2]");
	private By volume = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[5]/span/div/button");
	private By volumeFrom = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[5]/div/div/div[1]/div/div/div/div[1]/input[1]");
	private By volumeTo = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[5]/div/div/div[1]/div/div/div/div[1]/input[2]");
	private By applyVolume = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[5]/div/div/div[1]/div/div/div/div[3]/div/button[2]");
	private By checkItOut = By.xpath("/html/body/div[3]/div/div[2]/button");
	private By addToWatchList = By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr[1]/td/span/span");
	private By watchlistLink = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/a[1]/button/span[2]");
	private By watchlistLabel = By.xpath("//div[contains(text(), 'My First Watchlist')]");
	private By watchlistTable = By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr");
	
	public Selectors(WebDriver driver) {
		this.driver = driver;
	}
	
	/** load Chrome web driver **/
	public WebDriver loadDriver() {
//		System.out.println("Working Directory is " + System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver_win32_88.0.4324.96\\chromedriver.exe");
		System.out.println("Web driver is loaded");
		return driver = new ChromeDriver();
	}
	
	/** open page and maximize it **/
	public void openPage() {
		driver.get("https://coinmarketcap.com/");
		driver.manage().window().maximize();
		System.out.println("Page is opened and maximized");
		driver.navigate().refresh();
		
		WebDriverWait waitLogin = new WebDriverWait(driver, timeoutInSeconds);
		waitLogin.until(ExpectedConditions.visibilityOfElementLocated(logIn));
		
		driver.findElement(logIn).click();
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		
		driver.findElement(email).sendKeys("kekac34316@geeky83.com");
		driver.findElement(password).sendKeys("Bc231");
		driver.findElement(submitCredentials).click();
	}
	
	/** click on the Filters button **/
	public void clickOnFilters() {
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(filtersButton));
		
		// validate that Filters button is displayed
		Assert.assertTrue(driver.findElement(filtersButton).isDisplayed());
		
		// click on the Filters button
		if (driver.findElement(filtersButton).isDisplayed()) {
			System.out.println("Filters button is displayed");
			driver.findElement(filtersButton).click();
		}
	}
	
	/** validate that filter is set to Cryptocurrencies **/
	public void validateFilterText() {
		
		// validate that All Cryptocurrencies is selected
		Assert.assertEquals(driver.findElement(allCryptocurrencies).getText(), "All Cryptocurrencies");

	}
	
	/** click on the Filters button **/
	public void validateShowRows() {
		
		// validate that Show rows is select to 100
		Assert.assertTrue(driver.findElement(showRows).getText().contains("100"));
		
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows: " + rowCount.size());
		Assert.assertEquals(rowCount.size(), 100);
	}
	
	/** click on the Price **/
	public void selectPrice() {
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(price));
		
		// validate that price tab is displayed
		Assert.assertTrue(driver.findElement(price).isDisplayed());
		
		// click on the Price filter
		if (driver.findElement(price).isDisplayed()) {
			System.out.println("Price filter is displayed");
			driver.findElement(price).click();
		}
	}
	
	/** select price range **/
	public void selectPriceRange() {
		
		// wait for the price window to be displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceFrom));
		
		// validate that inputs and button are displayed
		Assert.assertTrue(driver.findElement(priceFrom).isDisplayed());
		Assert.assertTrue(driver.findElement(priceTo).isDisplayed());
		Assert.assertTrue(driver.findElement(applyPrice).isDisplayed());
		
		// enter price ranges and submit
		driver.findElement(priceFrom).sendKeys("10000");
		driver.findElement(priceTo).sendKeys("40000");
		driver.findElement(applyPrice).click();
		
		// validate that filtered table has less than 10 rows
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows: " + rowCount.size());
		Assert.assertTrue(rowCount.size() < 10);
	}
	
	/** click on the Volume **/
	public void selectVolume() {
		
		// validate that volume tab is displayed
		Assert.assertTrue(driver.findElement(volume).isDisplayed());
		
		// click on the Volume filter
		if (driver.findElement(volume).isDisplayed()) {
			System.out.println("Volume filter is displayed");
			driver.findElement(volume).click();
		}
	}
	
	/** select volume range **/
	public void selectVolumeRange() {
		
		// validate that inputs and submit button are displayed
		Assert.assertTrue(driver.findElement(volumeFrom).isDisplayed());
		Assert.assertTrue(driver.findElement(volumeTo).isDisplayed());
		Assert.assertTrue(driver.findElement(applyVolume).isDisplayed());
		
		// enter volume range and submit
		driver.findElement(volumeFrom).sendKeys("1");
		driver.findElement(volumeTo).sendKeys("1700000");
		driver.findElement(applyVolume).click();
		
		// validate that filtered table has less than 5 rows
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows: " + rowCount.size());
		Assert.assertTrue(rowCount.size() < 5);
	}
	
	/** Add filtered data to Watchlist 
	 * @throws InterruptedException **/
	public void addToWatchlist() throws InterruptedException {
		
		// get count of filtered rows
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows filtered: " + rowCount.size());
		
		// add id of items to the list
		for (int i=1; i<=rowCount.size(); i++) {
			System.out.println(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[3]/table/tbody/tr["+i+"]/td[2]/p")).getText());
//			Thread.sleep(500);
			watchlistItems.add(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[3]/table/tbody/tr["+i+"]/td[2]/p")).getText());
		}
		
		System.out.println(watchlistItems);
		
		// when click on the star to add to watch list, check whether is modal window is displayed
		driver.findElement(addToWatchList).click();
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkItOut));
		
		// if modal window is displayed, click on the button in the window
		if (driver.findElement(checkItOut).isDisplayed()) {
			driver.findElement(checkItOut).click();
			driver.findElement(addToWatchList).click();
		}
		
		// check all filtered items for adding to the watchlist by clicking the star
		for (int i=1; i<=rowCount.size(); i++) {
			driver.findElement(By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr["+i+"]/td/span/span")).click();
			Thread.sleep(1000);
		}
	}
	
	/** open watchlist 
	 * @throws InterruptedException **/
	public void openWatchlist() throws InterruptedException {
		
		// wait until Watchlist tab is displayed, and click on it
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(watchlistLink));
		driver.findElement(watchlistLink).click();
		
		// wait for the Wathlist page to be displayed
		WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(watchlistLabel));
		
		// get numbers of rows in the table
		List<WebElement> rowCount = driver.findElements(watchlistTable);
		
		for (int i=1; i<=rowCount.size(); i++) {

			// get values of id, price and volume
			String id = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[2]/p")).getText();
			float price = Float.parseFloat(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[4]/div/a")).getText().replaceAll("[$,]", ""));
			float volume = Float.parseFloat(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[8]/div/a/p")).getText().replaceAll("[$,]", ""));
			Thread.sleep(500);
			
			// validate that items in the watchlist table are previously added
			Assert.assertEquals(id, watchlistItems.get(i-1));
			
			// validate that prices in the watchlist table meet the criteria
			Assert.assertTrue(price >= 10000 && price <= 40000);
			
			// validate that volumes in the watchlist table meet the criteria
			Assert.assertTrue(volume >= 1 && volume <= 1700000);
		}
		
	}
	
}