package screeenshot_selenium;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Full_screenshotclass {
	static LocalDateTime currentdatetime = LocalDateTime.now();
	static String savetime = currentdatetime.toString().replace('-', ' ').replace(':', ' ');
	static WebDriver setbrowser;
	static String get_url = "https://nxtgenaiacademy.com/alertandpopup/";

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

	public static void take_fullscreenshot() throws IOException {

		String screenshot_path = "C:\\Selenium_Coding_Ducat\\Ducat\\Screenshots\\" + savetime + "file1.jpg";
		String folder_path = "C:\\Selenium_Coding_Ducat\\Ducat\\Screenshots";
		File create_folder = new File(folder_path);
		boolean validate_folder = create_folder.mkdir();
		System.out.println(validate_folder);
		WebElement logoscreenshot = setbrowser.findElement(By.xpath("//*[@id='site-navigation']"));
		Screenshot take_full_screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(setbrowser);
		ImageIO.write(take_full_screenshot.getImage(), "jpg", new File(screenshot_path));
	}

	public static void main(String args[]) throws IOException {
		get_driver();
		validate_URL();
	}
}