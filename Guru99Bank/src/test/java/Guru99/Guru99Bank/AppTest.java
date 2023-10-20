package Guru99.Guru99Bank;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest 
{
    @Test
    public void Login()
    {
    	WebDriver driver = new FirefoxDriver();
    	driver.get("https://www.demo.guru99.com/V4/");
    	
    	WebElement txtUserName = driver.findElement(By.name("uid"));
    	txtUserName.sendKeys("mngr533450");
    	WebElement txtPassword = driver.findElement(By.name("password"));
    	txtPassword.sendKeys("arunAja");
    	WebElement btn = driver.findElement(By.name("btnLogin"));
    	btn.click();
    }
}
