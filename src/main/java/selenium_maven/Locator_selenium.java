package selenium_maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locator_selenium {                   // 8 locators in selenium= id,name,link text,x-path,partial link text,css,tag
	static WebDriver setbrowser;                   // name,css selector,class.

	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		setbrowser = new ChromeDriver();
		System.out.println(setbrowser);

		String launch_url = "https://www.amazon.in/";
		setbrowser.get(launch_url);

		// String launch_url2
		// ="https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Ftag%3Daceredge-ubpl-pczz-pzz-in-21%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
		// setbrowser.get(launch_url2);

		setbrowser.manage().deleteAllCookies();
		System.out.println(setbrowser);

		setbrowser.manage().window().maximize();
		System.out.println(setbrowser);

		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);

		String url_Webtitle = setbrowser.getTitle();
		System.out.println(url_Webtitle);

		WebElement url_click = setbrowser.findElement(By.linkText("Customer Service")); // locator linkText(webElement
																						// interface0
		url_click.click();

		WebElement url_click1 = setbrowser.findElement(By.partialLinkText("Customer")); // locator partialLinktext
																						// (webElement interface)
		url_click1.click();

		/*
		 * Thread.sleep(5000);
		 * 
		 * WebElement launch_url3 = setbrowser.findElement(By.id("continue")); // use
		 * continue for browser id open launch_url3.click();
		 * 
		 * WebElement launch_url4 = setbrowser.findElement(By.name("email")); // use
		 * continue for browser id open launch_url4.click();
		 * 
		 * //WebElement launch_url5 = setbrowser.findElement(By.tagName("span")); // use
		 * continue for browser id open bcz continue tagname is span.
		 * //launch_url5.click();
		 * 
		 * String title_check = setbrowser.getTitle(); System.out.println(title_check);
		 * 
		 * 
		 * 
		 */
		setbrowser.close();
	}

}
