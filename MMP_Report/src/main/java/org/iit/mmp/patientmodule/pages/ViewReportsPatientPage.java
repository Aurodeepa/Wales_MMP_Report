package org.iit.mmp.patientmodule.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.utility.Utility;
import org.openqa.selenium.WebDriver;

public class ViewReportsPatientPage {
	
	WebDriver driver;
	HelperClass helperObj;
	
	String reportsBtn = "//a/button[contains(text(),'Reports')]" ;
	
	public ViewReportsPatientPage(WebDriver driver) {
		
		this.driver = driver ;
	}
	
	
	public void viewReports() throws Exception{

		String expectedHeader = "View Reports";
		String header ;

		driver.findElement(By.xpath(reportsBtn)).click();

		WebElement we3 = driver.findElement(By.xpath("(//h3)[2]"));
		header = we3.getText();
		System.out.println(header);
		if(expectedHeader.equalsIgnoreCase(header)) {

			String result = "matched";
			System.out.println(result);
		}
		else {
			System.out.println("Not matched");
		}
		
		//String viewRep = "(//tr/td)[2]//li";
        //driver.findElement(By.xpath(viewRep)).click();
		
		/*Checking the number of tds and trs*/
		
		List<WebElement> list = driver.findElements(By.xpath("//tbody//tr//td"));
		System.out.println(list.size());
		
		
 
	for(int i=1;i<=list.size();i++) {
	
			String viewRep = "(//tr/td)['"+ i +"']//li";
			System.out.println(viewRep);
			driver.findElement(By.xpath(viewRep)).click();
           driver.findElement(By.xpath("//div[contains(@class,'mfp-container')]")).click();
            
           
		}
		

	}

}
