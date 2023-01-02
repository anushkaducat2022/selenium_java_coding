package selenium_maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class locator_class {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver setbrowser = new ChromeDriver();
		System.out.println(setbrowser);

		String launch_url = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Ftag%3Daceredge-ubpl-pczz-pzz-in-21%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
		setbrowser.get(launch_url);

		setbrowser.manage().deleteAllCookies();
		System.out.println(setbrowser);

		setbrowser.manage().window().maximize();
		System.out.println(setbrowser);

		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);

		Thread.sleep(5000);

		WebElement launch_url3 = setbrowser.findElement(By.id("continue")); // use continue for browser id open
																			// launch_url3.click();

		WebElement launch_url4 = setbrowser.findElement(By.name("email")); // use continue for browser id open
																			// launch_url4.click();

		WebElement launch_url5 = setbrowser.findElement(By.tagName("span")); // usecontinue for browser id open bcz
																				// continue tagname is span.
		launch_url5.click();

		String title_check = setbrowser.getTitle();
		System.out.println(title_check);
		setbrowser.close();

	}
}