package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BookingHome {
	WebDriver driver;	
	By standardFare = By.cssSelector("span[class='price ng-binding']");
	By continue_button = By.id("continue");
	
	public BookingHome(WebDriver driver){
		this.driver = driver;
	}	
	
	public void selectStandardFare(){
		driver.findElement(standardFare).click();
	}
	
	public void clickContinueButton(){
		driver.findElement(continue_button).click();
	}
}
