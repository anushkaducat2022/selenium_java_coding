package dropdown_selection;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_classs2 {

	static WebDriver set_browser;
	static String get_url = "http://demo.seleniumeasy.com/";
	static String input_xpath = "(//*[@class='dropdown-toggle'])[1]";
	static String dropdown_xpath = " //*[text()='Select Dropdown List']";
	static String get_dropdown_values = "//select[@id='select-demo']";
	static String dropdown_values = "//*[contains(text(),'Day')]";
	static String get_multipledropdown_values = "//select[@id='multi-select']";

	public static void get_driver() {
		WebDriverManager.chromedriver().setup();
		set_browser = new ChromeDriver();
		System.out.println(set_browser);
		set_browser.manage().deleteAllCookies();
		set_browser.manage().window().maximize();
	}

	public static void validate_url() {
		set_browser.get(get_url);
		set_browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String get_title = set_browser.getTitle();
		System.out.println(get_title);

	}

	public static void Multi_Dropdown_validation() throws InterruptedException {
		WebElement input_click = set_browser.findElement(By.xpath(input_xpath));
		input_click.click();
		String get_title_new = set_browser.getTitle();
		System.out.println(get_title_new);

		Thread.sleep(3000);
		WebElement dropdown_click = set_browser.findElement(By.xpath(dropdown_xpath));
		dropdown_click.click();
		String get_element = set_browser.getTitle();
		System.out.println(get_element);
		Thread.sleep(3000);

		WebElement dropdown_values = set_browser.findElement(By.xpath(get_dropdown_values));
		dropdown_values.click();
		Thread.sleep(3000);
		String print_values = dropdown_values.getText();
		System.out.println(print_values);

		List<WebElement> multi_dropdown_values = set_browser.findElements(By.xpath(get_multipledropdown_values));

		for (WebElement multidropdown_list : multi_dropdown_values) {
			String print_multidrp_values = multidropdown_list.getText();
			System.out.println(print_multidrp_values);

			Select mult_values = new Select(multidropdown_list);
			mult_values.selectByIndex(2);
			mult_values.selectByValue("Texas");
			mult_values.selectByVisibleText("ohio");

			mult_values.deselectByIndex(2);
			mult_values.deselectByValue("Texas");
			mult_values.deselectByVisibleText("ohio");

		

			mult_values.deselectAll();
		}
	}

	public static void main(String args[]) throws InterruptedException {

		get_driver();
		validate_url();
		Multi_Dropdown_validation();

	}
}
