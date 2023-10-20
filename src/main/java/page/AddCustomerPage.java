package page;

import java.nio.channels.SelectableChannel;
import java.sql.Driver;

import javax.annotation.processing.Generated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")
	WebElement ADD_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIPCODE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELEMENT;

	public void verifyAddCustomerPage(String AddCustomer) {
		verifyElement(ADD_CUSTOMER_HEADER_ELEMENT, AddCustomer, "AddCustomer page not found");
	}

	String insertedName;

	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandom(9999);
		FULLNAME_ELEMENT.sendKeys(insertedName);
	}

	public void insertCompany(String company) {
		selectFromDropdown(COMPANY_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandom(999) + email);
	}

	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandom(9999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(generateRandom(999) + address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(generateRandom(9999) + city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		PHONE_ELEMENT.sendKeys(zip);
	}

	public void insertCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}

	public void clickOnSaveButton() {
		SAVE_BUTTON_ELEMENT.click();

	}

//tbody/tr[1]/td[3]/a
//tbody/tr[2]/td[3]/a
//tbody/tr[2]/td[3]/a
//tbody/tr[3]/td[3]/a
	//tbody/tr[1]/td[7]/a[2]
	//tbody/tr[2]/td[7]/a[2]
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete="]/td[7]/a[2]";
	

	public void validateInsertedNameAndDelete() {
		for (int i = 1; i <= 10; i++) {
			// driver.findElement(By.xpath("//tbody/tr[i]/td[3]/a"));
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(actualName);
			//Assert.assertEquals(actualName, insertedName, "Inserted name doesnt exist");
			driver.findElement(By.xpath(before_xpath+i+after_xpath_delete)).click();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]")).click();
			break;
		}
		
	}
}
