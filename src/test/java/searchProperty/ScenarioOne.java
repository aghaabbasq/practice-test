package searchProperty;

import java.awt.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioOne {
	
	WebDriver driver;

	@Given("^Open chrome browser and go to homepage$")
	public void open_chrome_browser_and_go_to_homepage() {
	    
		System.setProperty("webdriver.chrome.driver", "/Users/aghaabbasqazvini/Documents/abbas/seleniumJava/chromedriver");
		driver=new ChromeDriver();
		driver.get("https://www.rightmove.co.uk/");
		
	}
	
	@When("^User input and choose an option from dropdown$")
	public void user_input_and_choose_an_option_from_dropdown() {
	    
		driver.findElement(By.cssSelector("#searchLocation")).sendKeys("York");
		
	}
	
	@Then("^Perform a sale search$")
	public void perform_a_sale_search() {
	    
		driver.findElement(By.id("buy")).click();
		
	}
	
	@When("^User filter by selecting options from dropdowns$")
	public void user_filter_by_selecting_options_from_dropdowns() {
	    
		Select location = new Select(driver.findElement(By.id("locationIdentifier")));
		location.selectByIndex(1);
		
		Select radius = new Select(driver.findElement(By.id("radius")));
		radius.selectByIndex(1);
		
		Select priceMin = new Select(driver.findElement(By.id("minPrice")));
		priceMin.selectByIndex(1);
		
		Select priceMax = new Select(driver.findElement(By.id("maxPrice")));
		priceMax.selectByIndex(10);
		
		Select roomMin = new Select(driver.findElement(By.id("minBedrooms")));
		roomMin.selectByIndex(1);
		
		Select roomMax = new Select(driver.findElement(By.id("maxBedrooms")));
		roomMax.selectByIndex(4);
		
		Select PropertyType = new Select(driver.findElement(By.id("displayPropertyType")));
		priceMax.selectByIndex(1);
		
		Select daysAdded = new Select(driver.findElement(By.id("maxDaysSinceAdded")));
		daysAdded.selectByIndex(3);
		
	}
	
	@Then("^Find propertie$")
	public void find_propertie() {
	   
		driver.findElement(By.cssSelector("#submit")).click();
		//driver.get("button:contains('Find properties')");
	   
	}

	@When("^User can sort by$")
	public void user_can_sort_by() {
		
		Select sortType = new Select(driver.findElement(By.id("sortType")));
		sortType.selectByIndex(2);
 
	}

	@Then("^Click on first non-featured property to view description$")
	public void click_on_first_non_featured_property_to_view_description() {
    
		
		Object webElement = driver.findElement(By.cssSelector("div[data-test=propertyCard-1] a[data-test='property-img']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
		
		
	}
}
