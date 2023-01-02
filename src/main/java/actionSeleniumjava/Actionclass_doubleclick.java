package actionSeleniumjava;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actionclass_doubleclick {
	static WebDriver setbrowser;
	static String get_url = "https://www.flipkart.com/";
	static String doubleclick_xpath = "//*[text()='Best of Electronics']";
	static String cloths_xpath = "//*[text()='Fashion']";

	public static void get_driver() {
		WebDriverManager.chromedriver().setup();
		setbrowser = new ChromeDriver();
		setbrowser.manage().deleteAllCookies();
		setbrowser.manage().window().maximize();
		System.out.println(setbrowser);
	}

	public static void validate_URL() {
		setbrowser.get(get_url);
		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String get_title = setbrowser.getTitle();
		System.out.println(get_title);
	}
    public static void navigate_webpage() {
		setbrowser.navigate().refresh();
		String refresh_title = setbrowser.getCurrentUrl();
		System.out.println(refresh_title);
	}

	public static void navigate_hover_doubleclick() throws InterruptedException {
		WebElement fashionhover = setbrowser.findElement(By.xpath(cloths_xpath));
		Actions fashion_hover = new Actions(setbrowser);
		fashion_hover.moveToElement(fashionhover).build().perform();
		Thread.sleep(5000);

		WebElement hover = setbrowser.findElement(By.xpath(doubleclick_xpath));
		Actions onhover = new Actions(setbrowser);
		onhover.moveToElement(hover).doubleClick().perform();
		Thread.sleep(5000);
	}

	public static void main(String args[]) throws InterruptedException {

		get_driver();
		validate_URL();
		navigate_webpage();
		navigate_hover_doubleclick();
		Thread.sleep(5000);
		setbrowser.close();
	}
}
