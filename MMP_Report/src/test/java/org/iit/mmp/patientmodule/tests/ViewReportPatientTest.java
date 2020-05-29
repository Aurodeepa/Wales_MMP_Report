package org.iit.mmp.patientmodule.tests;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewReportPatientTest extends TestBase{

	HelperClass helperObj;


	@Test(description="US_006 Creation of Report",groups={"US_006","regression","sanity","patientmodule"})
	public void patientView() throws Exception {


		helperObj = new HelperClass(driver);
		helperObj.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		helperObj.captureScreenshot("US_006_LaunchApplication");
		helperObj.login("ria1","Ria12345");
		helperObj.captureScreenshot("US_006_Login");
		helperObj.moduleNavigation("Profile");
		helperObj.captureScreenshot("US_006_Profile");
		ViewReportsPatientPage viewRep = new ViewReportsPatientPage(driver);
		viewRep.viewReports();
		SoftAssert sa = new SoftAssert();
		sa.assertAll();


	}

	
	


}
