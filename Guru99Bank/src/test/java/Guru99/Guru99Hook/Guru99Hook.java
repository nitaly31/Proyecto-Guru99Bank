package Guru99.Guru99Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//import Guru99.pages.Guru99Login;

import java.io.File;

import javax.swing.text.Utilities;

/*
 * Contendrá los métodos antes y después de cada test, 
 * que deberán ejecutarse para el correcto funcionamiento
 * 
 * */

public class Guru99Hook {
	public WebDriver _driver;
	//public Guru99.pages.Guru99HomePage Guru99HomePage;
	public Utilities util;
	public String url;

	@BeforeTest
	public void setUp() {
		File file = new File("C:\\Users\\geral\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\5a6l2h23.Guru99Bank");

		FirefoxProfile myprofile = new FirefoxProfile(file);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(myprofile);

		_driver = new FirefoxDriver(options);
		_driver.get(url);
		_driver.manage().window().maximize();
		//Guru99Login login = new Guru99Login(_driver);
	}
	
	@AfterTest
	public void close() {
//		_driver.close();
	}
}
