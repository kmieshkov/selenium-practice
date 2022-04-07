import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdowns {

	public static void main(String[] args) throws java.lang.InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://ksrtc.in/oprs-web/";
		driver.get(url);

		WebElement search = driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
		search.sendKeys("BENG");

		Thread.sleep(2000);

		// Selenium cannot identify hidden elements due to AJAX
		// Use JavaScript Executor to extract hidden elements
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById('fromPlaceName').value;";
		String text = js.executeScript(script).toString();
		int i = 0;
		while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
			if (i > 10) break;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text = js.executeScript(script).toString();
			i++;
		}

		if (i > 10) {
			System.out.println("Error: Element not found");
		} else {
			search.sendKeys(Keys.ENTER);
			System.out.println("Success: " + text);
		}

		driver.close();
	}
}
