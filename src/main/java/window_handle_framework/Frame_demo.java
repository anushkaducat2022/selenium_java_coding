package window_handle_framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_demo {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver setbrowser = new ChromeDriver();
		System.out.println(setbrowser);

		String launch_url = "https://www.hyrtutorials.com/p/frames-practice.html";
		setbrowser.get(launch_url);

		setbrowser.manage().deleteAllCookies();
		System.out.println(setbrowser);

		setbrowser.manage().window().maximize();
		System.out.println(setbrowser);
		JavascriptExecutor scroll_window = (JavascriptExecutor) (setbrowser);
		scroll_window.executeScript("window.scrollBy(0,400)"); // downward
		Thread.sleep(5000);

		setbrowser.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
		setbrowser.findElement(By.id("name")).sendKeys("Hello");

		JavascriptExecutor scroll_window1 = (JavascriptExecutor) (setbrowser);
		scroll_window1.executeScript("window.scrollBy(0,400)"); // downward
		Thread.sleep(5000);
		setbrowser.switchTo().frame(setbrowser.findElement(By.id("frm1")));

		Select courseID = new Select(setbrowser.findElement(By.id("course")));
		courseID.selectByVisibleText("Java");
		Thread.sleep(5000);

		JavascriptExecutor scroll_window2 = (JavascriptExecutor) (setbrowser);
		scroll_window1.executeScript("window.scrollBy(800,0)"); // upward
		setbrowser.switchTo().defaultContent();
		setbrowser.findElement(By.id("name")).sendKeys(" " + "Anushka");
		Thread.sleep(5000);
		JavascriptExecutor scroll_window3 = (JavascriptExecutor) (setbrowser);
		scroll_window1.executeScript("window.scrollBy(0,1200)"); // downward

		setbrowser.switchTo().frame(setbrowser.findElement(By.id("frm2"))); // go to the frame 2 page
		Select Basic_cntrl = new Select(setbrowser.findElement(By.id("selectnav1")));
		Basic_cntrl.selectByIndex(30);
		;
		Thread.sleep(5000);

		setbrowser.switchTo().defaultContent();
		setbrowser.findElement(By.id("name")).sendKeys(" " + "Ranjan");
		Thread.sleep(5000);

		JavascriptExecutor scroll_window4 = (JavascriptExecutor) (setbrowser); 
		scroll_window1.executeScript("window.scrollBy(0,3200)"); // downward

		setbrowser.switchTo().frame(setbrowser.findElement(By.id("frm3"))); // go to the frame 3 page

		setbrowser.findElement(By.id("name")).sendKeys("Hello world");
		Thread.sleep(5000);
		Select practice_sel = new Select(setbrowser.findElement(By.id("selectnav1")));
		practice_sel.selectByIndex(5);
		;

	}

}
