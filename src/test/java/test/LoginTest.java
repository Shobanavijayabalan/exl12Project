package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
  WebDriver driver;
  ExcelReader exlRead=new ExcelReader("src\\main\\java\\testData\\TestData12.xlsx");
  
  
  String username= exlRead.getCellData("LoginInfo","UserName" , 2);
  String password=exlRead.getCellData("LoginInfo", "Password", 2);
  String dashboard=exlRead.getCellData("DashboardInfo", "DashboardHeader",2);
//  String addcontact="Add Contact";
//  String fullName="selenium";
//  String company="Amazon";
//  String email="fdfdf";
@Test	
public void validUserShouldBeAbleToLogin() throws InterruptedException {
	driver=BrowserFactory.setup();
    
	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
    loginPage.InsertUserName(username);
    loginPage.InsertPassword(password);
    loginPage.clickSigninButton();
    
    DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
    dashboardPage.verifyDashboardPage(dashboard);
    Thread.sleep(1000);
    dashboardPage.clickOnCustomerMenuButton();
    dashboardPage.clickOnAddCustomerMenuButton();
   
    AddCustomerPage addCustomer=PageFactory.initElements(driver, AddCustomerPage.class);
//    addCustomer.verifyAddCustomerPage(addcontact);
//    addCustomer.insertFullName(fullName);
//    Thread.sleep(1000);
//    addCustomer.insertCompany(company);
//    addCustomer.insertEmail(email);
   // BrowserFactory.tearDown();
}
	
}
 