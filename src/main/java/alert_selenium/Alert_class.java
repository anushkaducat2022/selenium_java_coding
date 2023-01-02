package alert_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_class {
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

		//WebElement alert_box = setbrowser.findElement(By.xpath(alert_xpath)); // use the method accept or decline option.
		//alert_box.click();
		// Thread.sleep(5000);
		// setbrowser.switchTo().alert().accept(); // accept means ok the button.
		// Thread.sleep(5000);
		// setbrowser.switchTo().alert().dismiss(); // dismiss means cancle the button
		// Thread.sleep(5000);
         WebElement confirm_button = setbrowser.findElement(By.xpath(alert_confirmbox_xpath)); // use the method confirm option.
		 confirm_button.click();
		setbrowser.switchTo().alert().dismiss();

		 WebElement ok_button=setbrowser.findElement(By.xpath(ok_xpath)); // use the method ok option.
		 String ok_click = ok_button.getText();
		 System.out.println(ok_click);
		 Thread.sleep(5000);
		// WebElement cancel_button=setbrowser.findElement(By.xpath(cancle_xpath)); // use the method cancle option.
		 //String cancel = cancel_button.getText();
		 //System.out.println(cancel);
		
	}

	public static void main(String args[]) throws InterruptedException {

		get_driver();
		validate_URL();
		alert_validate();

	}

}


