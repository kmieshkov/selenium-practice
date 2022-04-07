import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class CookiesAndScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://google.com";

		// maximize browser window
		driver.manage().window().maximize();

		// delete all the cookies
		driver.manage().deleteAllCookies();

		// delete the specified cookie, for example to verify session was ended and user was logged out
		driver.manage().deleteCookieNamed("sessionKey");

		driver.get(url);

		// take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/kmieshkov/Desktop/screenshot.png"));

		driver.close();
	}
}
