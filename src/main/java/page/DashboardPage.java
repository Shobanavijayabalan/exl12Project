package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class DashboardPage extends BasePage{
    WebDriver driver;
public DashboardPage(WebDriver driver) {
	this.driver=driver;
}
    
	@FindBy(how=How.XPATH,using ="//*[@id=\"page-wrapper\"]/div[2]/div/h2")WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how=How.XPATH,using ="//*[@id=\"side-menu\"]/li[3]/a/span[1]")WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how=How.XPATH,using ="//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")WebElement ADD_CUSTOMER_MENU_ELEMENT;
	@FindBy(how=How.XPATH,using ="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")WebElement LIST_CUSTOMER_MENU_ELEMENT;
 
	public void verifyDashboardPage(String dashboard){
	  Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(),dashboard,"Dashboard page not displayed");
		}

	public void clickOnCustomerMenuButton() {
		CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickOnAddCustomerMenuButton() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
	public void clickOnListCustomerMenuButton() throws InterruptedException {
		Thread.sleep(1000);
		LIST_CUSTOMER_MENU_ELEMENT.click(); 
}
}