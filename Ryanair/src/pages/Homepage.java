package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



public class Homepage {
	WebDriver driver;
	String homepageURL = "https://www.ryanair.com/ie/en/";
	By oneWay_radio = By.id("flight-search-type-option-one-way");
	By from_textbox = By.cssSelector("input[placeholder='Departure airport']");	
	By to_texbox = By.cssSelector("input[placeholder='Destination airport']");	
	By flyOutDate_textbox = By.cssSelector("input[name='startDate']");	
	By dateDD_textbox = By.name("dateInput0");
	By dateMM_textbox = By.name("dateInput1");
	By dateYYYY_textbox = By.name("dateInput2");	
	By searchFlights_button = By.cssSelector("button[ng-click='searchFlights()']");
				
	public Homepage(WebDriver driver){
		this.driver = driver;
	}	
	
	public Homepage open() {
		driver.get(homepageURL);
		return this;
	}	
	
	public void setOneWay(){
		driver.findElement(oneWay_radio).click();
	}
	
	public void setFrom(String place){
		driver.findElement(from_textbox).clear();
		driver.findElement(from_textbox).sendKeys(place);		
		driver.findElement(from_textbox).sendKeys(Keys.TAB);
	}
	
	public void setTo(String place) {
		driver.findElement(to_texbox).clear();
		driver.findElement(to_texbox).sendKeys(place);		
		driver.findElement(to_texbox).sendKeys(Keys.TAB);
	}
		
	public void setFlyOutDate(String DD, String MM, String YYYY){
		driver.findElement(dateDD_textbox).clear();
		driver.findElement(dateDD_textbox).sendKeys(DD);
		driver.findElement(dateMM_textbox).clear();
		driver.findElement(dateMM_textbox).sendKeys(MM);
		driver.findElement(dateYYYY_textbox).clear();
		driver.findElement(dateYYYY_textbox).sendKeys(YYYY);
	}
		
	public void clickSearchButton(){
		driver.findElement(searchFlights_button).click();
	}
		
}
