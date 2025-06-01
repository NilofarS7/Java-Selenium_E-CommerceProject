package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass 
{
	@Test(groups = {"sanity", "Master"})
	public void verifyAccountRegistration() throws InterruptedException 
	{
		logger.info("***Staring TC001_AccountRegistrationTest***");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");

			hp.clickRegister();
			logger.info("Clicked on Registration Link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing Customer Details");
			regpage.setFirstname(generateRandomString().toUpperCase());
			regpage.setLastName(generateRandomString().toUpperCase());
			regpage.setEmail(generateRandomString() + "@gmail.com");
			regpage.setTelephone(generateRandomNumber());

			String pwd = generateRandomAlphaNumeric();
			regpage.setPassword(pwd);
			regpage.setConfirmPassword(pwd);

			regpage.clickChkBox();
			regpage.clickContinue();

			
			String actualMsg = regpage.getconfirmMsg();
			logger.info("Validating Expected message with Actual message");
			if(actualMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}
		} 
		catch (Exception e) 
		{
			
			Assert.fail();
		}
		logger.info("***Completed TC001_AccountRegistrationTest***");

	}

}
