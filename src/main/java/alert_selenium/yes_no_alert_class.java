package alert_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class yes_no_alert_class {
	static WebDriver setbrowser;
	static String get_url = "https://nxtgenaiacademy.com/alertandpopup/";
	static String alert_xpath = "//*[@name='alertbox']";
	static String alert_confirmbox_xpath = "//button[@name='confirmalertbox']";
	static String ok_xpath = "//p[@id='demo']";
	static String cancle_xpath = "//p[@id='demo']";
	
	public static void get_driver() {
		WebDriverManager.chromedriver().setup();
		setbrowser = new ChromeDriver();
		System.out.println(setbrowser);
		setbrowser.manage().deleteAllCookies();
		setbrowser.manage().window().maximize();
	}
    public static void validate_URL() {
		setbrowser.get(get_url);
		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String title = setbrowser.getTitle();
		System.out.println(title);
	}
    public static void alert_validate() throws InterruptedException {

		WebElement alert_box = setbrowser.findElement(By.xpath(alert_xpath)); // use the method accept or decline option.
		alert_box.click();
		 Thread.sleep(5000);
		 setbrowser.switchTo().alert().accept(); // accept means click ok/yes button.
		 Thread.sleep(5000);
		// setbrowser.switchTo().alert().dismiss(); // dismiss means click no button.
		// Thread.sleep(5000);
         
		
	}

	public static void main(String args[]) throws InterruptedException {

		get_driver();
		validate_URL();
		alert_validate();

	}

}
