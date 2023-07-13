package Revision;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class revday1 {
	WebDriver driver;
@Test(dataProvider = "dp",priority = 1)
  public void f(String username,String password) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver.exe"); 
	  driver = new ChromeDriver();
	  driver.get("http://10.82.180.36/Common/Login.aspx");
	  		
	  driver.manage().window().maximize();
	driver.findElement(By.id("body_txtUserID")).sendKeys(username);
	driver.findElement(By.id("body_txtPassword")).sendKeys(password);
	driver.findElement(By.id("body_btnLogin")).click();
	Thread.sleep(1000);
	
  }



@DataProvider
public Object[][] dp(){
	Object d[][] = new Object[2][2];
	d[0][0]= "Donhere";
	d[0][1]="dom";
	d[1][0]= "Donhere";
	d[1][1]="don@123";
	return d;
}
  /**
@Test(priority = 3)
public void datatable() throws InterruptedException {
	Thread.sleep(1000);
	WebElement table = driver.findElement(By.id("body_cph_MyAccount_gvAccountDetails"));
	List<WebElement> rows = table.findElements(By.tagName("tr")); 
	for(WebElement r:rows) {
		List<WebElement> cols = r.findElements(By.tagName("td"));
		for(WebElement c:cols) {
			if(cols.get(3).getText().equals("FD")) {
				System.out.println(cols.get(0).getText()+" "+cols.get(1).getText() );
				break;
			}
		}
	
	}
}
  **/

@Test(priority = 4)
public void accounts() throws InterruptedException {
	driver.findElement(By.linkText("Open New Account")).click();
	Thread.sleep(1000);
	Select Drop = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlAccountType")));
	Drop.selectByVisibleText("Current Account");
	Thread.sleep(1000);
	Select Drop1 = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlState")));
	Drop1.selectByVisibleText("Karnataka");
	Thread.sleep(3000);
	Select Drop2 = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlCity")));
	Drop2.selectByVisibleText("Mysore");
	Thread.sleep(2000);
	Select Drop3 = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlBranch")));
	Drop3.selectByVisibleText("IEBI - INFOSYS TECHNOLOGIES LTD");
	Thread.sleep(1000);
	driver.findElement(By.id("body_cph_MyAccount_btnUpdate")).click();
	
	
} 
@Test(priority = 7)
public void accntreqstatus() throws InterruptedException {
	
	driver.findElement(By.linkText("Account Request Status")).click();
	
	Select Drop4 = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlStatusType")));
	Drop4.selectByVisibleText("Pending");
	
	Thread.sleep(3000);
	
	WebElement table = driver.findElement(By.id("body_cph_MyAccount_gvViewAccountRequestStatus"));
	
	List<WebElement> row = table.findElements(By.tagName("tr"));
	Thread.sleep(2000);
	
	for(WebElement r:row) {
		List<WebElement> col = r.findElements(By.tagName("td"));
		for(WebElement c:col) {
			if(col.get(1).getText().contains("23/02/2013")) {
				System.out.println(col.get(3).getText());
				break;
			}
		}
		
		
		
	}
	
}

@Test(priority = 9)
public void Deposit() throws IOException, InterruptedException {
	
	driver.findElement(By.id("GeneralTabMenu_Deposit_li_Cust")).click();
	driver.findElement(By.linkText("Open new FD/RD")).click();
	File f = new File("C:\\Users\\faraz.ahmed02\\Documents\\Revesion_Deposit.xlsx");
	
	Thread.sleep(1000);
	FileInputStream fin = new FileInputStream(f);
	XSSFWorkbook book = new XSSFWorkbook(fin);
	XSSFSheet sheet = book.getSheet("Sheet1");
	Thread.sleep(3000);
	for(int i =sheet.getFirstRowNum()+1 ;i<=sheet.getLastRowNum();i++) {
		String State = sheet.getRow(i).getCell(0).getStringCellValue();
		String City = sheet.getRow(i).getCell(1).getStringCellValue();
		String Branch = sheet.getRow(i).getCell(2).getStringCellValue();
		String Type = sheet.getRow(i).getCell(3).getStringCellValue();
		String Amount = sheet.getRow(i).getCell(4).getRawValue();
		String Period = sheet.getRow(i).getCell(5).getRawValue();
		String Mode = sheet.getRow(i).getCell(6).getStringCellValue();
		
		Select Drop5 = new Select(driver.findElement(By.id("body_cph_Deposit_ddlState")));
		Drop5.selectByVisibleText(State);
		Thread.sleep(1500);
		Select Drop6 = new Select(driver.findElement(By.id("body_cph_Deposit_ddlCity")));
		Drop6.selectByVisibleText(City);
		Thread.sleep(1000);
		Select Drop7 = new Select(driver.findElement(By.id("body_cph_Deposit_ddlBranch")));
		Drop7.selectByVisibleText(Branch);
		Thread.sleep(1000);
		Select Drop8 = new Select(driver.findElement(By.id("body_cph_Deposit_ddlDepositType")));
		Drop8.selectByVisibleText(Type);
		Thread.sleep(1000);
		driver.findElement(By.id("body_cph_Deposit_txtAmount")).sendKeys(Amount);
		Thread.sleep(1000);
		driver.findElement(By.id("body_cph_Deposit_txtMaturityPeriod")).sendKeys(Period);
		Thread.sleep(1000);
		Select Drop9 = new Select(driver.findElement(By.id("body_cph_Deposit_ddlDepositMode")));
		Drop9.selectByVisibleText(Mode);
		Thread.sleep(1000);
		
		driver.findElement(By.id("body_cph_Deposit_btnSubmit")).click();
		driver.findElement(By.id("body_cph_Deposit_btnReset")).click();
		Thread.sleep(1000);
		
		File Screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File("C:\\Users\\faraz.ahmed02\\Documents\\New folder\\Selenium practise"));
	}
	
	
}

  @AfterClass
  public void afterMethod() {
	  //driver.close();
  }

}
