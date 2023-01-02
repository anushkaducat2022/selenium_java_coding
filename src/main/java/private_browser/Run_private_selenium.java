package private_browser;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Run_private_selenium {
public static WebDriver setbrowser;
static String app_url ="https://www.amazon.in/";
private static final Logger LOG= Logger.getLogger(Run_private_selenium.class.getName());
	
public static void main(String[]args) {
WebDriverManager.chromedriver().setup();
ChromeOptions launchprivate = new ChromeOptions();
launchprivate.addArguments("INCOGNITO");                          // incognito browser use the option for private search...in incorgnito search anything we can not not store data.
//launchprivate.addArguments("headless");                          // we use headless method dont show run application only result show on console 
DesiredCapabilities launch_browser = new DesiredCapabilities();
launch_browser.setCapability(ChromeOptions.CAPABILITY,launch_browser);	
setbrowser=new ChromeDriver(launchprivate);	
setbrowser.get(app_url);

System.out.println(setbrowser.getTitle());
System.out.println(setbrowser.getCurrentUrl());
System.out.println(setbrowser.getPageSource());

}
}
