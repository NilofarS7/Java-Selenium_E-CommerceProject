package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DataDrivenLoginTest extends BaseClass
{
	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class, groups = "DataDriven")
	public void verify_DDTLogin(String email, String pwd, String expResult)
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		AccountLoginPage lp = new AccountLoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pwd);
		lp.clkLogin();
		
		MyAccountPage mAcct = new MyAccountPage(driver);
		boolean actTitleDisplay = mAcct.getPageTitle();
		
		if(expResult.equalsIgnoreCase("valid"))
		{
			if(actTitleDisplay==true)
			{
				mAcct.clkLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(expResult.equalsIgnoreCase("invalid"))
		{
			if(actTitleDisplay==true)
			{
				mAcct.clkLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}
}
