package selenium_maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // text = we take full name of x_path= //*[text()="see more"]
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//one elements multiple times we can handle use this path= (//*[text()="see more"])[4]
import io.github.bonigarcia.wdm.WebDriverManager;

public class x_path_selenium { // contains= we can take full and partial data and find x_path
								// =//*[contains(@text("see")],//*[contains(text()]
	static WebDriver setbrowser;
	static String search_path = "//input[@aria-label=\'Search\']";
	static String search_value = "Mobiles";
	static String search_value1 = "Sell";
	static String search_btn = " //input[@type='submit']";
	static String validate_title = "https://www.amazon.in/electronics/b/?ie=UTF8&node=976419031&ref_=nav_cs_electronics";
	static String btn_value = " //*[text()=\'Sign in securely\']";

	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		setbrowser = new ChromeDriver();
		System.out.println(setbrowser);

		setbrowser.manage().deleteAllCookies();
		System.out.println(setbrowser);

		setbrowser.manage().window().maximize();
		System.out.println(setbrowser);

		String launch_url = "https://www.amazon.in/";

		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);

		setbrowser.get(launch_url);

		String url_Webtitle = setbrowser.getTitle();
		System.out.println(url_Webtitle);

		String url_String = setbrowser.getTitle();
		System.out.println(url_String);

		WebElement search_btn_val = setbrowser.findElement(By.xpath(btn_value));
		String btn = search_btn_val.getText();
		System.out.println(btn);

		WebElement search_box_ele = setbrowser.findElement(By.xpath(search_path));
		search_box_ele.click();

		search_box_ele.sendKeys(search_value);
		Thread.sleep(5000);
		search_box_ele.clear();
		search_box_ele.sendKeys(search_value1);
		Thread.sleep(5000);

		WebElement search_box_click = setbrowser.findElement(By.xpath(search_btn));
		search_box_click.click();
		Thread.sleep(5000);

		if (validate_title
				.equals("https://www.amazon.in/electronics/b/?ie=UTF8&node=976419031&ref_=nav_cs_electronics")) {
			String new_title = setbrowser.getTitle();
			System.out.println(new_title);
		} else {
			System.out.println("button not click");
		}
		setbrowser.close();

	}

}
