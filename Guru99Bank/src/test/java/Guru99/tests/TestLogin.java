package Guru99.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Guru99.pages.LoginPage;
import Guru99.Guru99Hook.*;
import Guru99.Guru99Utils.Util;

public class TestLogin extends Hook {
	LoginPage login;

	public TestLogin() {
		this.url = "https://www.demo.guru99.com/V4/";
	}

	@Test(priority = 1)
	public void testHomePageAppearCorrect() {
		login = new LoginPage(_driver);

		String loginPageTitle = login.getTitle();

		Assert.assertEquals(loginPageTitle, Util.LOGIN_TITLE);
	}

	@Test(priority = 0, dataProvider = "Data login")
	public void testLoginCorrect(String user, String pwd, String estado) {
		login = new LoginPage(_driver);

		login.loginToGuru99(user, pwd);
		// setUp();

		if (estado.equalsIgnoreCase("i")) {
			Alert alt = _driver.switchTo().alert();
			String actualBoxTxt = alt.getText();

			Assert.assertEquals(Util.ALERT_ERROR_LOGIN, actualBoxTxt);
			alt.accept();
			
			System.out.println("caso 1");
		} else {
			String homePageTitle = login.getTitle();

			Assert.assertEquals(homePageTitle, Util.HOME_TITLE);
			
			login.clicLogOut();
			//Alert
			Alert alt = _driver.switchTo().alert();
			String logOut = alt.getText();
			
			Assert.assertEquals(Util.ALERT_LOGOUT_LOGIN, logOut);
			alt.accept();
			
			System.out.println("caso 2");
		}
		// _driver.close();
	}

	@Test(priority = 2)
	public void testHomeCorrect() {
		login = new LoginPage(_driver);
		String homePageTitle = login.getTitle();

		Assert.assertEquals(homePageTitle, Util.HOME_TITLE);

	}

	@DataProvider(name = "Data login")
	public Object[][] getInformation() throws Exception {
		return Util.leerExcel(Util.FILE_PATH + Util.FILE_NAME, Util.SHEET_NAME);
	}
}
