package dropdown_selection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_class {

	static WebDriver browser;
	static String selenium_url = "http://demo.seleniumeasy.com/";
	static String input_xpath = "(//*[@class='dropdown-toggle'])[1]";
	static String dropdownxpath = "(//*[text()='Select Dropdown List'])[1]";
	static String get_dropdown_values = "//select[@id='select-demo']";
	static String dropdown_values = "//*[contains(text(),'Day')]";

	public static void get_driver() {
		WebDriverManager.chromedriver().setup();
		 browser = new ChromeDriver();
		System.out.println(browser);
		browser.manage().deleteAllCookies();
		browser.manage().window().maximize();
	}

	public static void validate_URL() {
		browser.get(selenium_url);
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String title = browser.getTitle();
		System.out.println(title);
	}

	public static void navigate_webpage() {
		browser.navigate().refresh();
		String refresh_title = browser.getCurrentUrl();
		System.out.println(refresh_title);
	}

	public static void dropdownvalidation() throws InterruptedException {
		WebElement input_click = browser.findElement(By.xpath(input_xpath)); // first inputfrom
		input_click.click();
		Thread.sleep(5000);

		WebElement dropdown_click = browser.findElement(By.xpath(dropdownxpath));
		dropdown_click.click();

		String get_title_new = browser.getTitle();
		System.out.println(get_title_new);
		Thread.sleep(5000);

		WebElement dropdown_value = browser.findElement(By.xpath(get_dropdown_values));
         Thread.sleep(5000);
		dropdown_value.click();

		String print_values = dropdown_value.getText();
		System.out.println(print_values);
	}

	public static void dropdown_selection() {
		WebElement dropdown_value = browser.findElement(By.xpath(get_dropdown_values));
		Select drpdown_list = new Select(dropdown_value);
		// drpdown_list.selectByInde(1); // we use this method select the index no
		// drpdown_list.selectByValue("Monday"); // we use this method select the index
		// value.
		drpdown_list.selectByVisibleText("Tuesday"); // we use this method select the value visible on screen.

}

	public static void main(String args[]) throws InterruptedException {

		get_driver();
		validate_URL();
		Thread.sleep(5000);
		dropdownvalidation();
		dropdown_selection();
		Thread.sleep(5000);
		browser.close();

	}
}
