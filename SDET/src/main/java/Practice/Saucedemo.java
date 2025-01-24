package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Saucedemo {
    @Test
    public void test1() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        WebElement web = driver.findElement(By.className("form_input"));
        web.sendKeys("standard_user");
        web = driver.findElement(By.name("password"));
        web.sendKeys("secret_sauce");
        driver.findElement(By.className("btn_action")).click();
        boolean isInventoryDisplayed = driver.findElement(By.className("inventory_item_name")).isDisplayed();
        Assert.assertTrue(isInventoryDisplayed, "Inventory page is not displayed. Login failed.");
        driver.findElement(By.className("inventory_item_name")).click();
        driver.findElement(By.xpath("//button[.='ADD TO CART'][1]")).click();
        
        String cartText = driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).getText();
        Assert.assertTrue(cartText.contains("1"), "Item was not added to the cart.");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]")).click();
        driver.findElement(By.xpath("//a[.='CHECKOUT']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Pragya");
        String expectedName = "Pragya";
        String actualName = driver.findElement(By.id("first-name")).getAttribute("value");
        Assert.assertEquals(actualName, expectedName, "First name does not match.");
        driver.findElement(By.id("last-name")).sendKeys("Banga");
        driver.findElement(By.id("postal-code")).sendKeys("201018");
        driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
        driver.findElement(By.xpath("//a[.='FINISH']")).click();

        boolean isOrderComplete = driver.findElement(By.xpath("//h2[.='THANK YOU FOR YOUR ORDER']")).isDisplayed();
        Assert.assertTrue(isOrderComplete, "Order completion page was not displayed.");

        driver.quit();
    }
}