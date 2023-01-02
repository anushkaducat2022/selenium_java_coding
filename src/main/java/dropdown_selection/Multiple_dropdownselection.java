package dropdown_selection;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_dropdownselection {
	static WebDriver browser;
	static String selenium_url = "http://demo.seleniumeasy.com/";
	static String input_xpath = "(//*[@class='dropdown-toggle'])[1]";
	static String dropdownxpath = "(//*[text()='Select Dropdown List'])[1]";
	static String get_dropdown_values = "//select[@id='select-demo']";
	
	static String get_dropdown_multiplevalues = "//select[@id='multi-select']";

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
	
    public static void multi_dropdownselection() throws InterruptedException {
		WebElement input_click = browser.findElement(By.xpath(input_xpath)); // first inputfrom
		input_click.click();

		WebElement dropdown_click = browser.findElement(By.xpath(dropdownxpath));
		dropdown_click.click();

		String get_title_new = browser.getTitle();
		System.out.println(get_title_new);

		List<WebElement> multi_dropdown_values = browser.findElements(By.xpath(get_dropdown_multiplevalues));
		for (WebElement multidropdown_list : multi_dropdown_values) {
			String print_multidropdown_list = multidropdown_list.getText();
			System.out.println(print_multidropdown_list);

			Select multiplevalues = new Select(multidropdown_list);
			multiplevalues.selectByIndex(2);
			multiplevalues.selectByValue("Ohio");
			multiplevalues.selectByVisibleText("New York");
            Thread.sleep(5000);
			multiplevalues.deselectByIndex(2);
			multiplevalues.deselectByValue("Ohio");
			multiplevalues.deselectByVisibleText("New York");
			   Thread.sleep(5000);

			multiplevalues.selectByIndex(2);
			multiplevalues.selectByValue("Ohio");
			multiplevalues.selectByVisibleText("New York");
			Thread.sleep(5000);
			   Thread.sleep(5000);
			multiplevalues.deselectAll();
		}
	}

	public static void main(String args[]) throws InterruptedException {

		get_driver();
		validate_URL();
		multi_dropdownselection();
		browser.close();

	}
}
