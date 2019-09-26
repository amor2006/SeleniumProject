package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static WebDriver driver;

	private Driver() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (ConfigurationReader.getProperty("browser")) {
			case "chrome":
//				System.setProperty("webdriver.chrome.driver",
//						"C:\\Users\\Owner\\Desktop\\WebDrivers\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				return driver;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\Desktop\\WebDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				return driver;
			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}
}
