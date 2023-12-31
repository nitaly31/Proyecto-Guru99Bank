package Guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By titleText = By.tagName("title");
	By txtUserName = By.name("uid");
	By txtPassword = By.name("password");
	By btn = By.name("btnLogin");
	By btnLogOut = By.linkText("Log out");

	//Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}

	// Establecer nombre de usuario y password
	// en el cuadro de texto

	public void setUserName(String strUserName) {
	//	wait.until(ExpectedConditions.presenceOfElementLocated(txtUserName));
		driver.findElement(txtUserName).clear();
		driver.findElement(txtUserName).sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
	//	wait.until(ExpectedConditions.presenceOfElementLocated(txtPassword));
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(strPassword);
	}

	// Haga clic en el botón de inicio de sesión

	public void clickLogin() {
		driver.findElement(btn).click();
	}
	// Obtenga el título de página de inicio de sesión

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clicLogOut() {
		driver.findElement(btnLogOut).click();
	}
	
	/**
     * Este método POM se expondrá en el caso de prueba para iniciar sesión en la aplicación.
     * @param strUserName
     * @param strPasword
     * @return
     */
	
	public void loginToGuru99(String strUserName, String strPassword ) { //
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}
}
