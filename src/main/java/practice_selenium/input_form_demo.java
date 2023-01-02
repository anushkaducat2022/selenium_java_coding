package practice_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class input_form_demo {
	static  WebDriver setbrowser;
	static String get_url = "http://demo.seleniumeasy.com/";   
	static String input_xpath =  "(//*[@class='dropdown-toggle'])[1]";
	static String main_input_xpath = "//a[text()='Simple Form Demo']";
    static String input_form ="//*[@placeholder='Please enter your Message']";
    static String btn_click_xpath ="//button[text()='Show Message']";
    static String final_text ="//*[@id='display']";
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
public static void validate_ele() throws InterruptedException 
{
	WebElement input_click = setbrowser.findElement(By.xpath(input_xpath));
	input_click.click();
	String get_title_new = setbrowser.getTitle(); 
	System.out.println(get_title_new);
	
	Thread.sleep(5000);
	
	WebElement maininput_click= setbrowser.findElement(By.xpath(main_input_xpath));
	maininput_click.click();
	Thread.sleep(5000);
	 
	get_title_new = setbrowser.getTitle(); 
	System.out.println(get_title_new);

	WebElement input_form_box = setbrowser.findElement(By.xpath(input_form));
	input_form_box.click();
	input_form_box.sendKeys("My name is Anu");
	Thread.sleep(5000);
	
	WebElement btn_click = setbrowser.findElement(By.xpath(btn_click_xpath));
   btn_click.click();
    Thread.sleep(5000);
	
    WebElement final_text_ele = setbrowser.findElement(By.xpath(final_text));
     String print_text = final_text_ele.getText();
     System.out.println(print_text);
}
public static void main(String[]args) throws InterruptedException {
	 get_driver();
	 validate_URL();
	 navigate_webpage();
	 validate_ele();

   setbrowser.close();
}
}
//Seleniumeasy.com
//Selenium.com Easy. - Best Demo website to practice Selenium Webdriver Online

//Don't waste your time in finding a demo website to practice Selenium Webdriver. Selenium Easy demo site has great examples like Ajax, JQuery, Bootstrap etc which are used...



