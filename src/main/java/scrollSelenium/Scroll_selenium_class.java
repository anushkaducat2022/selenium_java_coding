package scrollSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_selenium_class {

	static WebDriver setbrowser;
	static String get_url = "https://www.flipkart.com/";
	static String scroll_text = "//*[text()='EMI on Debit Cards']";

	public static void get_driver() {
		WebDriverManager.chromedriver().setup();
		setbrowser = new ChromeDriver();
		System.out.println(setbrowser);
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

	public static void scroll_webpage() throws InterruptedException {
		JavascriptExecutor scroll_window = (JavascriptExecutor) (setbrowser);      // use this method page scrolll
		/*
		 * scroll_window.executeScript("window.scrollBy(0,1800)"); // downward
		 * Thread.sleep(5000);
		 * scroll_window.executeScript("window.scrollBy(0,-1200)"); // upward
		 *  Thread.sleep(5000);
		 * Thread.sleep(5000); scroll_window.executeScript("window.scrollBy(1100,0)");
		 * // left scroll 
		 * Thread.sleep(5000);
		 * scroll_window.executeScript("window.scrollBy(-1100,0)"); // right scroll
		 * Thread.sleep(5000);
		 */

		WebElement text_scroll = setbrowser.findElement(By.xpath(scroll_text));
		Thread.sleep(5000);
		scroll_window.executeScript("arguments[0].scrollIntoView(true)", text_scroll);        //scroll_window.executeScript("arguments[0].scrollIntoview(true)", text_scroll);

	}

	public static void main(String args[]) throws InterruptedException {
		get_driver();
		validate_URL();
		navigate_webpage();
		scroll_webpage();

	}

}