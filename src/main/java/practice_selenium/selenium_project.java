package practice_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium_project {
	static  WebDriver setbrowser;
	static String get_url = "https://www.amazon.in/";   
	static String search_path = "//*[@class='nav-search-submit nav-sprite']";
	static String text_path = "//*[@type='text']";
    static String btn_value="//*[@value='Go']";
    static String mble_path="//*[@class='a-size-medium a-color-base a-text-normal']";
    static String add_to_cartpath ="//*[@id=\"add-to-cart-button\"]";
public static void get_driver() 
{
    WebDriverManager.chromedriver().setup();
	  setbrowser = new ChromeDriver(); 
	setbrowser.manage().deleteAllCookies();
	setbrowser.manage().window().maximize();System.out.println(setbrowser);	
 }
public static void validate_URL() {  
	 setbrowser.get(get_url); 
	 setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 String get_title = setbrowser.getTitle();
	 System.out.println(get_title); 
}
public static void navigate_webpage()
{
	 setbrowser.navigate().refresh();
	 String refresh_title= setbrowser.getCurrentUrl(); 
	 System.out.println(refresh_title); 
}
	
public static void searchelement() throws InterruptedException {
	

	WebElement search_box_ele = setbrowser.findElement(By.xpath(search_path));
	search_box_ele.click();

	WebElement type_box = setbrowser.findElement(By.xpath(text_path));
	type_box.click();
	
	type_box.sendKeys("redmi note 11");
	Thread.sleep(5000);
	type_box.click();
	
   WebElement btn_click = setbrowser.findElement(By.xpath(btn_value));
   btn_click.click();
   Thread.sleep(5000);
	
   
   WebElement mobile = setbrowser.findElement(By.xpath(mble_path));
   mobile.click();
   Thread.sleep(5000);
   
   JavascriptExecutor scroll_window = (JavascriptExecutor) (setbrowser); 
   scroll_window.executeScript("window.scrollBy(0,500)");
   
  // WebElement add_cart = setbrowser.findElement(By.xpath(add_to_cartpath ));
  //add_cart.click();
   
   
   Thread.sleep(5000);
   }
	
	
	
	
public static void main(String args[]) throws InterruptedException {
	get_driver();
	validate_URL();
	navigate_webpage();
	searchelement() ;
    setbrowser.close();
}
}
