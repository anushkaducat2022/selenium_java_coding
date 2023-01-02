package selenium_maven;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver; // webDriver= interface
import org.openqa.selenium.chrome.ChromeDriver; // 4 method of navigate = forward,back,refresh,to.
import io.github.bonigarcia.wdm.WebDriverManager;

public class Run_selenium_maven {
	static WebDriver setbrowser;
	
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        setbrowser = new ChromeDriver();
		System.out.println(setbrowser);

		String launch_url = "https://www.amazon.in/";
		setbrowser.get(launch_url);
		// Thread.sleep(100000); // use the thread.sleep application waiting
		// thetime.(maximum time waste)
		// setbrowser.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS ); //
		// weopen application only 30 second time limit

		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES); // use the implicityWait application wait
																				// until your pageload extend the tim
		setbrowser.get(launch_url);																		// application was open.(best method) to
																				// use this.

		setbrowser.manage().deleteAllCookies(); // delete all cookies in browser
		System.out.println(setbrowser);

		setbrowser.manage().window().maximize(); // show the browser fullscreen we use Maximize.
		System.out.println(setbrowser);

		String url_Webtitle = setbrowser.getTitle(); // show the title of browser
		System.out.println(url_Webtitle);

		String url_source = setbrowser.getPageSource(); // ctrl+u = open the browser in source code
		System.out.println(url_source);

		setbrowser.navigate().refresh(); // refresh the browser. [this all methodscome to the intrface webdriver]
		System.out.println(url_source);

		String launch_url2 = "https://www.flipkart.com/"; // 1st amazon browser open the open flipcart.
		setbrowser.get(launch_url2);

		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);

		setbrowser.navigate().back(); // browser back String url_Webtitle2 =setbrowser.getTitle();
		System.out.println(url_Webtitle);

		Thread.sleep(5000);

		setbrowser.navigate().forward(); // then browser forward String url_Webtitle1= setbrowser.getTitle();
		System.out.println(url_Webtitle);

		setbrowser.navigate().to("https://www.youtube.com/"); //

		setbrowser.close();

	}
}
