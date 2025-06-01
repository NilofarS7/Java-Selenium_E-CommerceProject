package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage
{

	public AccountLoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(css= "#input-email") WebElement txtEmail;
	@FindBy(css = "#input-password") WebElement txtPassword;
	@FindBy(xpath = "//input[@type='submit']") WebElement btnLogin;
	
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clkLogin()
	{
		btnLogin.click();
	}
	

}
