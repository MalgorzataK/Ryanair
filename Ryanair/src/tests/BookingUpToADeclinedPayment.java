package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.Homepage;
import pages.BookingHome;
import pages.BookingExtras;
import pages.BookingPayment;

public class BookingUpToADeclinedPayment {
	WebDriver driver;
	Homepage homepage;
	BookingHome bookingHome;
	BookingExtras bookingExtras;
	BookingPayment bookingPayment;
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}	
	
	
	@Test(priority=0)
	public void VerifyErrorMessage() {
		homepage = new Homepage(driver).open();		
		homepage.setOneWay();		
		homepage.setFrom("Dublin");
		homepage.setTo("Gdansk");		
		homepage.setFlyOutDate("14","08","2016");
		homepage.clickSearchButton();
		
		bookingHome = new BookingHome(driver);
		bookingHome.selectStandardFare();
		bookingHome.clickContinueButton();
		
		bookingExtras = new BookingExtras(driver);
		bookingExtras.closeDialog();
		bookingExtras.clickCheckOutButton();		
		
		bookingPayment = new BookingPayment(driver);
		bookingPayment.setPassengerDetails("Mr", "John", "Snow");
		bookingPayment.setContactDetails("mail@mail.com", "Poland", "123456789");
		bookingPayment.setPaymentMethod("5555555555555557", 1, 2, 2, "265", "John Snow");
		bookingPayment.setBillingAddress("New Street", "Dublin", "0000", "Ireland");
		bookingPayment.acceptTerms();
		bookingPayment.submitForm();
		
		Assert.assertTrue(bookingPayment.getTextMessage().contains("As your payment was not authorised we could not complete your reservation. Please ensure that the information was correct or use a new payment to try again"));		
	}
}
