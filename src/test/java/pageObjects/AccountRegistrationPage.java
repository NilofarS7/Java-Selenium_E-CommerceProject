package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(css="#input-firstname") WebElement txtFirstname;
	@FindBy(css = "#input-lastname") WebElement txtLastname;
	@FindBy(css = "#input-email") WebElement txtEmail;
	@FindBy(css = "#input-telephone") WebElement txtPhone;
	@FindBy(css = "#input-password") WebElement txtPwd;
	@FindBy(css = "#input-confirm") WebElement txtConfirmpwd;
	@FindBy(xpath = "//input[@name='agree']") WebElement chkPolicy;
	@FindBy(xpath = "//input[@type='submit']") WebElement btncontinue;
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']") WebElement confirmationMsg;
	
	
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String mail)
	{
		txtEmail.sendKeys(mail);
	}
	
	public void setTelephone(String phn)
	{
		txtPhone.sendKeys(phn);
	}
	
	public void setPassword(String password)
	{
		txtPwd.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmpass)
	{
		txtConfirmpwd.sendKeys(confirmpass);
	}
	
	public void clickChkBox()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		btncontinue.click();
	}
	
	public String getconfirmMsg()
	{
		try 
		{
			return (confirmationMsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}

}
