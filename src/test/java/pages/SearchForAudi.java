package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Driver;

public class SearchForAudi {
	private WebDriver driver;

	public SearchForAudi() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "brand_id")
	public WebElement make;

	@FindBy(id = "model_id")
	public WebElement model;

	@FindBy(id = "year_from")
	public WebElement yearFrom;

	@FindBy(id = "year_to")
	public WebElement yearTo;

	@FindBy(xpath = "//select[@name='s[engine_type]'")

	public WebElement engine;

	@FindBy(xpath = "//select[@name='s[gearbox]'")
	public WebElement gearbox;

	@FindBy(id = "search_count")
	public WebElement searchButton;

	@FindBy(xpath = "//div[@class='priceCatalog price']")
	public WebElement price;

	public void selectDropDown(String visibleText, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

}
