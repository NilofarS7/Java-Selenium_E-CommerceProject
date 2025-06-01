package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass
{
	@Test(groups = {"regression", "Master"})
	public void verifyUserLogin()
	{
		logger.info("***TC002_AccountLoginTest***");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		AccountLoginPage lp = new AccountLoginPage(driver);
		lp.enterEmail(p.getProperty("Email"));
		lp.enterPassword(p.getProperty("Password"));
		lp.clkLogin();
		
		MyAccountPage mAcct = new MyAccountPage(driver);
		boolean actTitleDisplay = mAcct.getPageTitle();
		System.out.println(actTitleDisplay);
		Assert.assertEquals(actTitleDisplay, true, "Login Failed...");
		
	}
}
