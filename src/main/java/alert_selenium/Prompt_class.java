package alert_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prompt_class {
	static WebDriver setbrowser;
	static String get_url = "https://nxtgenaiacademy.com/alertandpopup/";
	static String prompt_xpath="//*[@name='promptalertbox1234']";
	static String accept_xpath = "//p[@id='demoone']";
	
	public static void get_driver() {
		WebDriverManager.chromedriver().setup();
		setbrowser = new ChromeDriver();
		System.out.println(setbrowser);
		setbrowser.manage().deleteAllCookies();
		setbrowser.manage().window().maximize();
	}
    public static void validate_URL()  {
		setbrowser.get(get_url);
		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String title = setbrowser.getTitle();
		System.out.println(title);
   }
    public static void promptalert_validate() throws InterruptedException {
    	
    	WebElement promptalert_box = setbrowser.findElement(By.xpath( prompt_xpath)); // use the method accept or decline option.
		promptalert_box.click();
		Thread.sleep(5000);
		Alert validate = setbrowser.switchTo().alert();
		//validate.sendKeys("yes");
		//validate.accept();
    	
    	WebElement ok_button=setbrowser.findElement(By.xpath(accept_xpath)); // use the method ok option.
		String accept_click = ok_button.getText();
		System.out.println(accept_click);
		Thread.sleep(5000);
    }
    
    public static void main(String args[]) throws InterruptedException 
   {
    	 get_driver();
    	 validate_URL();
    	 promptalert_validate();
	   
   }
}
