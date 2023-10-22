package Guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Guru99.pages.LoginPage;
import Guru99.Guru99Hook.*;
import Guru99.Guru99Utils.Util;

public class TestLogin extends Hook {
	LoginPage login;

	public TestLogin() {
		this.url = "https://www.demo.guru99.com/V4/";
	}

	@Test(priority = 0)
	public void testHomePageAppearCorrect() {
		login = new LoginPage(_driver);
		String loginPageTitle = login.getTitle();

		Assert.assertEquals(loginPageTitle, Util.LOGIN_TITLE);

		login.loginToGuru99(Util.USER_NAME, Util.PWD);
	}

	@Test(priority = 1)
	public void testLoginCorrect() {
		login = new LoginPage(_driver);
		String homePageTitle = login.getTitle();

		Assert.assertEquals(homePageTitle, Util.HOME_TITLE);
	}
}
