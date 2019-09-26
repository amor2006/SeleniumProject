package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.SearchForAudi;
import utils.ConfigurationReader;
import utils.Driver;

public class SearchForAudiStepDefinitions {
	WebDriver driver;
	SearchForAudi sfa = new SearchForAudi();

	@Given("I am on Autopapa.ge home page")
	public void i_am_on_Autopapa_ge_home_page() {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(ConfigurationReader.getProperty("url"));
	}

	@Then("I select all mandatory fields {string},{string},{string} and {string}")
	public void i_select_all_mandatory_fields_and(String make, String model, String yearFrom, String yearTo)
			throws InterruptedException {
		sfa.selectDropDown(make, sfa.make);

		sfa.selectDropDown(model, sfa.model);

		sfa.selectDropDown(yearFrom, sfa.yearFrom);

		sfa.selectDropDown(yearTo, sfa.yearTo);
	}

	@Then("I click on Search button and assert that there is only one car with exact {string}")
	public void i_click_on_Search_button_and_assert_that_there_is_only_one_car_with_exact(String expectedPrice) {
		sfa.searchButton.click();
		WebElement element = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='priceCatalog price']")));
		String actual = ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].lastChild.textContent;", element).toString();
		actual = actual.replaceAll("[^a-zA-Z0-9 ]", "");
		actual = actual.replaceAll("\\s", "");
		System.out.println("$" + actual + " vs " + "$" + expectedPrice);

		Assert.assertEquals(expectedPrice, actual);
	}

}
