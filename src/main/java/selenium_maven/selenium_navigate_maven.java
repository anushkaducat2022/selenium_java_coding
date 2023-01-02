package selenium_maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium_navigate_maven {

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();

		WebDriver setbrowser = new ChromeDriver();
		System.out.println(setbrowser);

		String launch_url = "https://www.amazon.in/";
		setbrowser.get(launch_url);

		setbrowser.navigate().refresh(); // refresh the browser. [this all methods come to the intrface webdriver]
		System.out.println(launch_url);

		String launch_url2 = "https://www.flipkart.com/"; // 1st amazon browser open then open flipcart.
		setbrowser.get(launch_url2);

		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);

		setbrowser.navigate().back(); // browser back
		String url_Webtitle2 = setbrowser.getTitle();
		System.out.println(url_Webtitle2);

		setbrowser.navigate().forward(); // then browser forward
		String url_Webtitle1 = setbrowser.getTitle();
		System.out.println(url_Webtitle1);

		setbrowser.navigate().to("https://www.youtube.com/"); //

		setbrowser.close();

	}

}
