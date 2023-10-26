package Guru99.Guru99Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Guru99.Guru99Utils.Util;

//import Guru99.pages.Guru99Login;

import java.io.File;
import java.time.Duration;

/*
 * Contendrá los métodos antes y después de cada test, 
 * que deberán ejecutarse para el correcto funcionamiento
 * 
 * */

public class Hook {
	public WebDriver _driver;
	public String url;

	@BeforeTest
	public void setUp() {
		File file = new File(Util.FIREFOX_PATH);

		FirefoxProfile myprofile = new FirefoxProfile(file);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(myprofile);

		_driver = new FirefoxDriver(options);
		_driver.get(url);
		_driver.manage().window().maximize();
		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.WAIT_TIME));
	}
	
	@AfterTest
	public void close() {
		_driver.close();
	}
}
