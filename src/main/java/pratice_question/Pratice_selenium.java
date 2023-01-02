package pratice_question;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pratice_selenium {
	static WebDriver browser;
	static String get_url = "https://www.godaddy.com/";
static String search_xpath="//*[@type='text']";
static String domains_xpath=" //*[text()='Domains']";
static String buy_xpath ="//*[@type='button']";
static String cart_xpath="//*[@class='icon icon-cart-v2']";

	public static void get_driver() {
		WebDriverManager.chromedriver().setup();
		browser = new ChromeDriver();
		System.out.println(browser);
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
	}
    public static void validate_URL() {
		browser.get(get_url);                               
	}

	public static void validate_title() throws InterruptedException {
		String get_title = browser.getTitle();
		System.out.println(get_title);
		
	}
	public static void validate_source_code() {
	String url_source = browser.getPageSource();                      // ctrl+u = open the browser in source code
	System.out.println(url_source);
	}
	public static void validate_ele() throws InterruptedException 
	{
		WebElement input_click = browser.findElement(By.id("id-d6f9deab-d554-45df-a52c-8a9ab53948b5"));
		input_click.click();
		WebElement click_search = browser.findElement(By.id("id-3a34578f-40f3-4d2f-aaa4-0a1320f3fe6a"));
		click_search.click();
		Thread.sleep(5000);
		
	}
	public static void validate_inspect() throws InterruptedException {
		Actions action = new Actions(browser);
		WebElement rightclick = browser.findElement(By.xpath(domains_xpath));
		action.contextClick(rightclick).perform();
		Thread.sleep(2000);
	}
	public static void search() throws InterruptedException {

	WebElement search_box= browser.findElement(By.xpath(search_xpath));
     search_box.click();
     search_box.sendKeys("mydomain.club");
     WebElement buy_it = browser.findElement(By.xpath(buy_xpath));
     buy_it.click();
     //WebElement cart_option = browser.findElement(By.xpath(cart_xpath));
     //cart_option.click();
     //Thread.sleep(5000);
	}

	/*
	 * public static void validate_titleURL() {
	 * 
	 * } public static void validate_security() throws InterruptedException {
	 * WebElement security_click =
	 * browser.findElement(By.id("id-6601c18b-052d-4400-b2fc-4ba38667a59f"));
	 * security_click.click(); WebElement ssl_certificate_click =
	 * browser.findElement(By.id("id-7ad6a47f-7a78-4821-8e5e-0f93dfed539d"));
	 * ssl_certificate_click.click();
	 * 
	 * Thread.sleep(5000); } public static void validate_Email_Marketing() throws
	 * InterruptedException { WebElement Email_Marketing_click =
	 * browser.findElement(By.id("id-0e3db3ca-f205-4a6d-8404-424f4af1d162"));
	 * Email_Marketing_click .click(); WebElement email_and_office_click =
	 * browser.findElement(By.id("id-ffb39aa5-2e22-4003-9e4a-6aaae607478f"));
	 * email_and_office_click.click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * } public static void validate_web() throws InterruptedException { WebElement
	 * web_option_click =
	 * browser.findElement(By.id("id-261a403f-f6be-4a7e-b813-786437bf5589"));
	 * web_option_click .click(); WebElement godaddy_pro_site_click =
	 * browser.findElement(By.id("id-897493ae-b03b-4e54-99f8-06280d0088a0"));
	 * godaddy_pro_site_click .click(); Thread.sleep(5000);
	 * 
	 * }
	 */
	
	
	
	
	
public static void main(String[] args) throws InterruptedException {
		get_driver();
		validate_URL();
		validate_title();
		validate_source_code();
		 validate_ele();
		 validate_inspect();
		 search() ;
		 //validate_security();
		 //validate_Email_Marketing();
		 //validate_web();
		//browser.close();

	}
}