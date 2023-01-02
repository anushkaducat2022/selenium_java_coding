package screeenshot_selenium;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot_class {
	
	static LocalDateTime currentdatetime = LocalDateTime.now();
	static String savetime = currentdatetime.toString().replace('-', ' ').replace(':', ' ');
	static WebDriver setbrowser;
	static String get_url = "https://nxtgenaiacademy.com/alertandpopup/";
	static String alert_xpath = "//*[@name='alertbox']";
	static String alert_confirmbox_xpath = "//button[@name='confirmalertbox']";
	static String cancle_xpath = "//p[@id='demo']";

	public static void get_driver(){
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
	public static void take_screenshot() throws IOException {

		String screenshot_path = "C:\\Selenium_Coding_Ducat\\Ducat\\Screenshots\\case.jpg";
		String folder_path = "C:\\Selenium_Coding_Ducat\\Ducat\\Screenshots";
		File create_folder1 = new File(folder_path);
		boolean validate_folder = create_folder1.mkdir();
		System.out.println(validate_folder);
	    WebElement logoscreenshot=setbrowser.findElement(By.xpath("//*[@class='text-wrap']"));
		
		JavascriptExecutor take_screenshot = (JavascriptExecutor)setbrowser;
		File create_screenshot= ((TakesScreenshot)logoscreenshot).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(create_screenshot, new File(screenshot_path));
   }

	public static void main(String args[]) throws IOException {
        get_driver();
		validate_URL();
		take_screenshot();

	}
}
