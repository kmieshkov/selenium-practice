import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.amazon.com/";
		driver.get(url);
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.LEFT_SHIFT).sendKeys("hello").build().perform();
		// moves to specific element
		a.moveToElement(move).contextClick().perform();

		driver.close();
	}
}
