package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Vatrina {

@Test	
	public void test1() {
		
		
   ChromeDriver driver= new ChromeDriver();
   driver.get("https://vatrinawebplatform-638132-react.b440331.dev.eastus.az.svc.builder.cafe/EmailAccountRegistration");
   driver.manage().window().maximize();
   WebElement signup= driver.findElement(By.id("fullName"));
   signup.sendKeys("pragya");
   driver.findElement(By.id("username")).sendKeys("pragya_1");
  // signup;
   signup=driver.findElement(By.id("dateOfBirth"));
   signup.sendKeys("22-08-1998");
   signup=driver.findElement(By.id("email"));
   signup.sendKeys("pragya@yopmail.com");
   signup=driver.findElement(By.id("password"));
   signup.sendKeys("Pragya@123");
   WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='Female']"));
   femaleRadioButton.click();
   WebElement termsCheckbox = driver.findElement(By.name("agreeToTerms"));
   termsCheckbox.click();
   
   WebElement button= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/form/button"));
   button.click();
   
   driver.get("https://yopmail.com/");
   signup=driver.findElement(By.xpath("//input[@class='ycptinput']"));
   signup.sendKeys("kimi");
   signup.sendKeys(Keys.ENTER);
}

}
