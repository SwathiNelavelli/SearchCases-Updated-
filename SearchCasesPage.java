package easytox.apptest.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


















import com.sun.tools.javac.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.utils.WebConnector;

public class SearchCasesPage extends AbstractPage {
	//WebDriver driver;
	
	public SearchCasesPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickSearchButtonToSearchAnyCase()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"SearchButtonForSearchCase_xpath")).click();
		}
	
	public void ClickDetailSearchButton()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"DetailSearchButton_xpath")).click();
		}
	
	public void ClickSearchButtonInDetailSearch()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"SearchButtonInDetailSearch_xpath")).click();
		}
	
	public void ClickOnCreateNewCase()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"CreateNewCaseIcon_xpath")).click();
		}
}
	