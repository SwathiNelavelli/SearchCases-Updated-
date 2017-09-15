package easytox.apptest.stepdefinitions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.pages.AbstractPage;
import easytox.apptest.pages.InsuranceCompanyPage;
import easytox.apptest.pages.LablistPage;
import easytox.apptest.pages.LoginPage;
import easytox.apptest.pages.SearchCasesPage;
import easytox.apptest.utils.WebConnector;
import junit.framework.Assert;

public class SearchCasesStepDefinition {
	
	WebDriver driver = null;	
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	InsuranceCompanyPage insurancecompany = null;
	SearchCasesPage searchcase = null;
	
	@Given("^user enter easytox url for Search Cases$")
	public void user_enter_easytox_url_for_Search_Cases() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		searchcase = new SearchCasesPage(driver);
		insurancecompany = new InsuranceCompanyPage(driver);
	
	//	Assert.assertEquals(forgotpwd, "Click here");
		//System.out.println(forgotpwd);
	}

	@Given("^enter username as \"([^\"]*)\" for Search Cases$")
	public void enter_username_as_for_Search_Cases(String arg1) throws Throwable {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Username"));
	}

	@Given("^enter password as \"([^\"]*)\" for Search Cases$")
	public void enter_password_as_for_Search_Cases(String arg1) throws Throwable {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Password"));
	}

	@Given("^user click on \"([^\"]*)\" button for Search Cases$")
	public void user_click_on_button_for_Search_Cases(String arg1) throws Throwable {
		loginpage.Loginbuttonclick();;
	}
	
	@Then("^Close the Search Cases browser$")
	public void close_the_Search_Cases_browser() throws Throwable {
		loginpage.closeDriver();
	}
	
	@When("^Enter a valid first name in the \"([^\"]*)\" field and click 'Search'$")
	public void enter_a_valid_first_name_in_the_field_and_click_Search(String fname) throws Throwable {
        Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "FirstNameForSearchCase_xpath")).sendKeys(fname);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	
	@Then("^All the cases with matching entered first name \"([^\"]*)\" should be displayed in the Search Results$")
	public void all_the_cases_with_matching_entered_first_name_should_be_displayed_in_the_Search_Results(String fname) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='myTable']/tr")).size();
		for(int i=2;i>=rowCount;i++){
		     String FirstNameInfo = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[1]")).getText();
		     Assert.assertTrue(FirstNameInfo.contains(fname));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "FirstNameForSearchCase_xpath")).clear();
	}
	
	@When("^Enter a valid last name in the \"([^\"]*)\" field and click 'Search'$")
	public void enter_a_valid_last_name_in_the_field_and_click_Search(String lname) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "LastNameForSearchCase_xpath")).sendKeys(lname);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	
	@Then("^All the cases with matching entered last name \"([^\"]*)\" should be displayed in the Search Results$")
	public void all_the_cases_with_matching_entered_last_name_should_be_displayed_in_the_Search_Results(String lname) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='myTable']/tr")).size();
		for(int i=2;i>=rowCount;i++){
		     String FirstNameInfo = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[1]")).getText();
		     Assert.assertTrue(FirstNameInfo.contains(lname));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "LastNameForSearchCase_xpath")).clear();
	}

	@When("^Enter a valid DOB in the \"([^\"]*)\" field in MM/DD/YYYY format and click 'Search'$")
	public void enter_a_valid_DOB_in_the_field_in_MM_DD_YYYY_format_and_click_Search(String dob) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForSearchCase_xpath")).sendKeys(dob);
		
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForSearchCase_xpath")).sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	

   @Then("^All the cases with matching DOB \"([^\"]*)\" should be displayed in the Search Results$")
   public void all_the_cases_with_matching_DOB_should_be_displayed_in_the_Search_Results(String dob) throws Throwable {
	   Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='myTable']/tr")).size();
//		System.out.println(rowCount);
		for(int i=2;i<=rowCount;i++){
		     String DOBInfo = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[1]/a")).getAttribute("title");
//		     System.out.println(DOBInfo);
		     Assert.assertTrue(DOBInfo.contains(dob));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForSearchCase_xpath")).clear();
		
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForSearchCase_xpath")).sendKeys(Keys.TAB);
   }
	
	@When("^Select a Status from the \"([^\"]*)\" drop down and click 'Search'$")
	public void select_a_Status_from_the_drop_down_and_click_Search(String status) throws Throwable {
		Thread.sleep(2000);
		new Select(connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "SelectStatusOption_xpath"))).selectByVisibleText(status);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	
	@When("^Select a Physician from the \"([^\"]*)\" drop down and click 'Search'$")
	public void select_a_Physician_from_the_drop_down_and_click_Search(String physician) throws Throwable {
		Thread.sleep(2000);
		new Select(connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "SelectPhysicianOption_xpath"))).selectByVisibleText(physician);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}

	@When("^Enter a valid Case Number in \"([^\"]*)\" and click 'Search'$")
	public void enter_a_valid_Case_Number_in_and_click_Search(String caseno) throws Throwable {
	    Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "CaseAccessionForSearchCase_xpath")).sendKeys(caseno);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	
	@Then("^Matching Case Number \"([^\"]*)\" should be displayed in the  Search Results$")
	public void matching_Case_Number_should_be_displayed_in_the_Search_Results(String caseno) throws Throwable {
		 Thread.sleep(2000);
			int rowCount=driver.findElements(By.xpath("//*[@id='myTable']/tr")).size();
//			System.out.println(rowCount);
			for(int i=2;i<=rowCount;i++){
			     String CaseAccessionInfo = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[1]/a")).getText();
//			     System.out.println(CaseAccessionInfo);
			     Assert.assertEquals(caseno, CaseAccessionInfo);
			}
			Thread.sleep(2000);
			connector.getWebElement(driver, WebConnector.Identifier.xpath, 
					connector.getstring(WebConnector.myUrl.URL_OR, "CaseAccessionForSearchCase_xpath")).clear();
	}

	@When("^Enter a valid Medical Record Number in \"([^\"]*)\" and click 'Search'$")
	public void enter_a_valid_Medical_Record_Number_in_and_click_Search(String medicalrecord) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "MedicalRecordForSearchCase_xpath")).sendKeys(medicalrecord);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	
	@Then("^Matching case \"([^\"]*)\" should be displayed in the Search Results$")
	public void matching_case_should_be_displayed_in_the_Search_Results(String medicalrecord) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='myTable']/tr")).size();
		System.out.println(rowCount);
		for(int i=2;i<=rowCount;i++){
		     String MedicalReocordInfo = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[1]/a")).getAttribute("title");
		     System.out.println(MedicalReocordInfo);
		     Assert.assertTrue(MedicalReocordInfo.contains(medicalrecord));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "MedicalRecordForSearchCase_xpath")).clear();
	}
	
	@When("^Enter values in multiple fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and click 'Search'$")
	public void enter_values_in_multiple_fields_and_click_Search(String fname, String caseno, String medicalrecord) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "FirstNameForSearchCase_xpath")).sendKeys(fname);
		
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "CaseAccessionForSearchCase_xpath")).sendKeys(caseno);
		
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "MedicalRecordForSearchCase_xpath")).sendKeys(medicalrecord);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	
	@Then("^Cases matching all the entered conditions \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" should be displayed in the Search Results$")
	public void cases_matching_all_the_entered_conditions_should_be_displayed_in_the_Search_Results(String fname, String caseno, String medicalrecord) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='myTable']/tr")).size();
		for(int i=2;i<=rowCount;i++){
		     String SearchInfo = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[1]/a")).getAttribute("title");
		     String CaseAccessionInfo = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[1]/a")).getText();
		     Assert.assertTrue(SearchInfo.contains(fname));
		     Assert.assertTrue(SearchInfo.contains(medicalrecord));
		     Assert.assertEquals(caseno, CaseAccessionInfo);
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "FirstNameForSearchCase_xpath")).clear();
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "CaseAccessionForSearchCase_xpath")).clear();
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "MedicalRecordForSearchCase_xpath")).clear();
	}

	@When("^Click Search without entering values in any field$")
	public void click_Search_without_entering_values_in_any_field() throws Throwable {
		Thread.sleep(2000);
		searchcase.ClickSearchButtonToSearchAnyCase();
	}
	
	@When("^Enter any search criteria \"([^\"]*)\" in search box of Case List page$")
	public void enter_any_search_criteria_in_search_box_of_Case_List_page(String search) throws Throwable {
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"CaseListSearchBox_xpath")).sendKeys(search);
	}

	@Then("^Matching case with entered search criteria \"([^\"]*)\" should be populated in the case list$")
	public void matching_case_with_entered_search_criteria_should_be_populated_in_the_case_list(String search) throws Throwable {
		boolean search_column = driver.findElement(By.xpath("//table[@id='caseorder']/tbody[contains(., "+search+")]")).isDisplayed();
		Assert.assertEquals(search_column,true); 
	}
	
	@When("^Click on Case Accession number for matching search criteria \"([^\"]*)\"$")
	public void click_on_Case_Accession_number_for_matching_search_criteria(String search) throws Throwable {
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath("//*[@id='caseorder_length']/label/select"))).selectByVisibleText("100");
		int rowCount=driver.findElements(By.xpath("//*[@id='caseorder']/tbody/tr")).size(); //*[@id="casetable"]/tbody/tr/td[2]
			for(int i=1;i<=rowCount;i++){
				for(int j=1;j<=10;j++){
			String SearchCriteriaNameInfo = driver.findElement(By.xpath("//*[@id='caseorder']/tbody/tr["+i+"]/td["+j+"]")).getText();
			Thread.sleep(2000);
			 if(search.equals(SearchCriteriaNameInfo)){
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@id='editlink']")).click(); 
				break; 
				}
			} 
		}
	}
	
	@Then("^Update Case screen should be displayed for editing$")
	public void update_Case_screen_should_be_displayed_for_editing() throws Throwable {
		Thread.sleep(2000);
		String UpdateCaseScreenInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"UpdateCaseScreenInfo_xpath")).getText();
		System.out.println(UpdateCaseScreenInfo);
//	Assert.assertEquals("Update Case", UpdateCaseScreenInfo);
	}
	
	@When("^Case Status is \"([^\"]*)\", \"([^\"]*)\" button should be displayed against the case$")
	public void case_Status_is_button_should_be_displayed_against_the_case(String arg1, String arg2) throws Throwable {
	    boolean StatusInProcessingInfo = driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/div[4]/div/div/div[1]/label/input")).isSelected();
	    boolean StatusInReadyInfo = driver.findElement(By.xpath("//*[@id='testStatusType']/div/label/input")).isSelected();
	    if(StatusInProcessingInfo || StatusInReadyInfo ){
	    	 boolean DeleteOrderInfo = driver.findElement(By.xpath("//*[@id='deleteOrder']")).isDisplayed();
	    }
	}
	
	@Then("^Click \"([^\"]*)\" button,Case gets deleted after receiving confirmation from the user$")
	public void click_button_Case_gets_deleted_after_receiving_confirmation_from_the_user(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id='deleteOrder']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='confirmyes']")).click();
	}
	
	@When("^Case Status is \"([^\"]*)\", \"([^\"]*)\" should be displayed for the case$")
	public void case_Status_is_should_be_displayed_for_the_case(String arg1, String arg2) throws Throwable {
		 boolean StatusFinalizedInfo = driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/div[4]/div/div/div[4]/label/span")).isSelected();
		 System.out.println(StatusFinalizedInfo);
		    if(StatusFinalizedInfo){
		    	System.out.println("x");
		    	 boolean EditIconInfo = driver.findElement(By.xpath("//*[@id='maincontentdiv']/div[16]/div[2]/div[1]/div/li/a")).isDisplayed();
		    }
	}

	@Then("^Click \"([^\"]*)\", Two options are displayed: \"([^\"]*)\"$")
	public void click_Two_options_are_displayed(String arg1, String arg2) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='maincontentdiv']/div[16]/div[2]/div[1]/div/li/a")).click();
		Thread.sleep(2000);
		boolean CorrectionInfo = driver.findElement(By.xpath("//*[@id='correctionOrder']/span")).isDisplayed();
		boolean RevisionInfo = driver.findElement(By.xpath("//*[@id='revisionOrder']/span")).isDisplayed();
	}
	
	@When("^Select \"([^\"]*)\" option$")
	public void select_option(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id='correctionOrder']/span")).click();
		Thread.sleep(2000);
	}

	@Then("^Case screen \"([^\"]*)\" should be displayed for editing$")
	public void case_screen_should_be_displayed_for_editing(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id='reasonForAmendment']")).isDisplayed();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='amendmentOk']")).click();
	}
	
	@When("^Select 'Case Revision' option$")
	public void select_Case_Revision_option() throws Throwable {
		driver.findElement(By.xpath("//*[@id='revisionOrder']/span")).click();
		Thread.sleep(2000);
	}

	@Then("^Case screen 'Reason for Amendment' should be displayed for editing$")
	public void case_screen_Reason_for_Amendment_should_be_displayed_for_editing() throws Throwable {
		driver.findElement(By.xpath("//*[@id='reasonForAmendment']")).isDisplayed();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='amendmentOk']")).click();
	}
	
	@When("^Click 'Detail Search' button in the 'Find Case' section$")
	public void click_Detail_Search_button_in_the_Find_Case_section() throws Throwable {
		Thread.sleep(2000);
		searchcase.ClickDetailSearchButton();
	}

	@Then("^'Detail Search' page with additional search options along with all cases is displayed$")
	public void detail_Search_page_with_additional_search_options_along_with_all_cases_is_displayed() throws Throwable {
		Thread.sleep(2000);
		String DetailSearchScreenInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"DetailSearchScreenInfo_xpath")).getText();
	    Assert.assertEquals("Case List", DetailSearchScreenInfo);
	}
	
	@When("^Enter a valid patient last name in the \"([^\"]*)\" field and click 'Search' in 'Detail Search' page table$")
	public void enter_a_valid_patient_last_name_in_the_field_and_click_Search_in_Detail_Search_page_table(String lname) throws Throwable {
	    Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "LastNameInDetailSearch_xpath")).sendKeys(lname);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonInDetailSearch();
	}

	@Then("^Matching cases with entered patient last name \"([^\"]*)\" should be displayed in 'Detail Search' page table$")
	public void matching_cases_with_entered_patient_last_name_should_be_displayed_in_Detail_Search_page_table(String lname) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='casetable']/tr")).size();
		for(int i=1;i>=rowCount;i++){
		     String LastNameInfo = driver.findElement(By.xpath("//*[@id='casetable']/tr["+i+"]/td[4]")).getText(); 
		     Assert.assertTrue(LastNameInfo.contains(lname));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "LastNameInDetailSearch_xpath")).clear();
	}

	@When("^Enter a valid patient first name in the \"([^\"]*)\" field and click 'Search' in 'Detail Search' page table$")
	public void enter_a_valid_patient_first_name_in_the_field_and_click_Search_in_Detail_Search_page_table(String fname) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "FirstNameInDetailSearch_xpath")).sendKeys(fname);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonInDetailSearch();
	}

	@Then("^Matching cases with entered patient first name \"([^\"]*)\" should be displayed in 'Detail Search' page table$")
	public void matching_cases_with_entered_patient_first_name_should_be_displayed_in_Detail_Search_page_table(String fname) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='casetable']/tr")).size();
		for(int i=1;i>=rowCount;i++){
		     String FirstNameInfo = driver.findElement(By.xpath("//*[@id='casetable']/tr["+i+"]/td[3]")).getText(); 
		     Assert.assertTrue(FirstNameInfo.contains(fname));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "FirstNameInDetailSearch_xpath")).clear();
	}
	
	@When("^Enter a valid patient Accession in the \"([^\"]*)\" field and click 'Search' in 'Detail Search' page table$")
	public void enter_a_valid_patient_Accession_in_the_field_and_click_Search_in_Detail_Search_page_table(String accession) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "AccessionInDetailSearch_xpath")).sendKeys(accession);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonInDetailSearch();
	}

	@Then("^Matching cases with entered patient Accession \"([^\"]*)\" should be displayed in 'Detail Search' page table$")
	public void matching_cases_with_entered_patient_Accession_should_be_displayed_in_Detail_Search_page_table(String accession) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='casetable']/tr")).size();
		for(int i=1;i>=rowCount;i++){
		     String AccessionInfo = driver.findElement(By.xpath("//*[@id='casetable']/tr["+i+"]/td[2]")).getText(); 
		     Assert.assertTrue(AccessionInfo.contains(accession));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "AccessionInDetailSearch_xpath")).clear();
	}

	@When("^Enter a valid patient medical record in the \"([^\"]*)\" field and click 'Search' in 'Detail Search' page table$")
	public void enter_a_valid_patient_medical_record_in_the_field_and_click_Search_in_Detail_Search_page_table(String medrecord) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "MedRecordInDetailSearch_xpath")).sendKeys(medrecord);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonInDetailSearch();
	}

	@Then("^Matching cases with entered patient medical record \"([^\"]*)\" should be displayed in 'Detail Search' page table$")
	public void matching_cases_with_entered_patient_medical_record_should_be_displayed_in_Detail_Search_page_table(String medrecord) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='casetable']/tr")).size();
		for(int i=1;i>=rowCount;i++){
		     String MedRecordInfo = driver.findElement(By.xpath("//*[@id='casetable']/tr["+i+"]/td[7]")).getText(); 
		     Assert.assertTrue(MedRecordInfo.contains(medrecord));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "MedRecordInDetailSearch_xpath")).clear();
	}
	
	@When("^Enter a valid patient date of birth in the \"([^\"]*)\" field and click 'Search' in 'Detail Search' page table$")
	public void enter_a_valid_patient_date_of_birth_in_the_field_and_click_Search_in_Detail_Search_page_table(String dob) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForDetailSearch_xpath")).sendKeys(dob);
		
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForDetailSearch_xpath")).sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonInDetailSearch();
	}

	@Then("^Matching cases with entered patient date of birth \"([^\"]*)\" should be displayed in 'Detail Search' page table$")
	public void matching_cases_with_entered_patient_date_of_birth_should_be_displayed_in_Detail_Search_page_table(String dob) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='casetable']/tr")).size();
		for(int i=1;i<=rowCount;i++){
		     String DOBInfo = driver.findElement(By.xpath("//*[@id='casetable']/tr["+i+"]/td[5]/a")).getAttribute("title");
		     Assert.assertTrue(DOBInfo.contains(dob));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForDetailSearch_xpath")).clear();
		
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "DateOfBirthForDetailSearch_xpath")).sendKeys(Keys.TAB);
	}
	
	@When("^Enter a valid patient status in the \"([^\"]*)\" field and click 'Search' in 'Detail Search' page table$")
	public void enter_a_valid_patient_status_in_the_field_and_click_Search_in_Detail_Search_page_table(String status) throws Throwable {
		Thread.sleep(2000);
		new Select(connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "SelectStatusOptionInDetailSearch_xpath"))).selectByVisibleText(status);
		
		Thread.sleep(2000);
		searchcase.ClickSearchButtonInDetailSearch();
	}

	@Then("^Matching cases with entered patient status \"([^\"]*)\" should be displayed in 'Detail Search' page table$")
	public void matching_cases_with_entered_patient_status_should_be_displayed_in_Detail_Search_page_table(String status) throws Throwable {
		Thread.sleep(2000);
		int rowCount=driver.findElements(By.xpath("//*[@id='casetable']/tr")).size();
		for(int i=1;i>=rowCount;i++){
		     String StatusInfo = driver.findElement(By.xpath("//*[@id='casetable']/tr["+i+"]/td[8]")).getText(); 
		     Assert.assertTrue(StatusInfo.contains(status));
		}
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "AccessionInDetailSearch_xpath")).clear();
	}
	
	@When("^Enter any search criteria \"([^\"]*)\" in 'Detail Search' page search box$")
	public void enter_any_search_criteria_in_Detail_Search_page_search_box(String search) throws Throwable {
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"DetailSearchBox_xpath")).sendKeys(search);
	}
	
	@Then("^Matching cases with entered search criteria \"([^\"]*)\" should be populated in the 'Detail Search' page table$")
	public void matching_cases_with_entered_search_criteria_should_be_populated_in_the_Detail_Search_page_table(String search) throws Throwable {
		boolean search_column = driver.findElement(By.xpath("//table[@id='casetable']/tbody[contains(., "+search+")]")).isDisplayed();
		Assert.assertEquals(search_column,true);
	}
	
	@When("^Click Case Accession number for matching search criteria \"([^\"]*)\" in the 'Detail Search' page$")
	public void click_Case_Accession_number_for_matching_search_criteria_in_the_Detail_Search_page(String search) throws Throwable {
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath("//*[@id='casetable_length']/label/select"))).selectByVisibleText("100");
		int rowCount=driver.findElements(By.xpath("//*[@id='casetable']/tbody/tr")).size(); 
			for(int i=1;i<=rowCount;i++){
				for(int j=1;j<=10;j++){
			String DetailSearchCriteriaNameInfo = driver.findElement(By.xpath("//*[@id='casetable']/tbody/tr["+i+"]/td["+j+"]")).getText();
			Thread.sleep(2000);
			 if(search.equals(DetailSearchCriteriaNameInfo)){
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@id='editlink']")).click(); 
				break;  
				}
			} 
		}
	}
	
	@When("^Click 'Create New Case' icon on the top$")
	public void click_Create_New_Case_icon_on_the_top() throws Throwable {
		Thread.sleep(2000);
		searchcase.ClickOnCreateNewCase();
	}

	@When("^User navigates to 'Create New Case' screen$")
	public void user_navigates_to_Create_New_Case_screen() throws Throwable {
		Thread.sleep(2000);
		String CreateNewCaseScreenInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"CreateNewCaseScreenInfo_xpath")).getText();
	     Assert.assertEquals("Create New Case", CreateNewCaseScreenInfo);
	}
	


	
}