package org.iit.mmp.adminmodule.tests;


import java.util.ArrayList;
import java.util.List;

import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.adminmodule.pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateReportAdminTest extends TestBase {

	HelperClass helperObj;


	@Test(description="US_006 Creation of Report",groups={"US_006","regression","sanity","adminmodule"})
	public void createReport() throws Exception {

		helperObj = new HelperClass(driver);
		helperObj.launchApplicationURL("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/admin/login.php");
		helperObj.login("Thomas_444","Edison_444");
		helperObj.moduleNavigation("Patients");
		CreateReportAdminPage createRepo = new CreateReportAdminPage(driver);
		createRepo.patientSearchName("Ria");
		createRepo.searchRecord("Ria","462379048");
		//createRepo.searchRecord("Anya","210911222");
		//createRepo.patientSearchSSN("462379048");
		createRepo.patientDetails("462379048");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(createRepo.reportDetails("XRAY-General report","This is general XRAY report","C:\\Users\\vikib\\Desktop\\Team Wales - SELENIUM PROJECT\\Project Work\\lung-article-703x441.jpg"));
		sa.assertAll();

	}
}
