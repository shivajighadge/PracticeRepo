package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	private WebElement signInButton;

	@FindBy(xpath = ".//*[@id='email_create']")
	private WebElement createAccountEmailTextbox;

	@FindBy(xpath = ".//*[@id='SubmitCreate']")
	private WebElement createAccountSubmitButton;

	@FindBy(id = "email")
	private WebElement emaiID;

	@FindBy(id = "passwd")
	private WebElement pass;

	@FindBy(id = "SubmitLogin")
	private WebElement submitlogin;

	@FindBy(xpath = ".//*[@id='email']")
	private WebElement registeredUserEmailID;

	@FindBy(xpath = ".//*[@id='passwd']")
	private WebElement registeredUserPassword;

	@FindBy(id = "customer_firstname")
	WebElement customer_firstname;

	@FindBy(id = "customer_lastname")
	WebElement customer_lastname;

	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement state;

	@FindBy(id = "phone_mobile")
	WebElement phone_mobile;

	@FindBy(id = "postcode")
	WebElement postcode;

	@FindBy(id = "submitAccount")
	WebElement submitAccount;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
	WebElement successUser;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void register(String email, String fname, String lname, String pass, String add, String cityName,
			String stateName, String pinCode, String mobile) throws InterruptedException {

		Thread.sleep(4000);
		signInButton.click();
		this.createAccountEmailTextbox.clear();
		createAccountEmailTextbox.sendKeys(email);

		createAccountSubmitButton.click();

		this.customer_firstname.clear();
		customer_firstname.sendKeys(fname);

		this.customer_lastname.clear();
		customer_lastname.sendKeys(lname);

		this.password.clear();
		password.sendKeys(pass);

		this.address.clear();
		address.sendKeys(add);

		this.city.clear();
		city.sendKeys(cityName);

		Select State = new Select((state));
		State.selectByVisibleText(stateName);

		this.postcode.clear();
		postcode.sendKeys(pinCode);

		this.phone_mobile.clear();
		phone_mobile.sendKeys(mobile);

		submitAccount.click();

	}

	public void login(String email, String Password) throws InterruptedException {

		logout.click();
		Thread.sleep(3000);

		this.emaiID.clear();
		emaiID.sendKeys(email);
		this.pass.clear();
		pass.sendKeys(Password);
		submitlogin.click();
	}

	public String sucessfulUser() {
		return successUser.getText();
	}

}
