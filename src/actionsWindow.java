import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class actionsWindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://accounts.google.com/signup";
		driver.get(url);

		driver.findElement(By.linkText("Help")).click();
		System.out.println("Before switching");
		System.out.println(driver.getTitle());
		System.out.println("--------------------");

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> iterator = ids.iterator();

		String parentId = iterator.next();
		String childId = iterator.next();

		driver.switchTo().window(childId);
		System.out.println("Switching to child");
		System.out.println(driver.getTitle());

		System.out.println("--------------------");

		driver.switchTo().window(parentId);
		System.out.println("Switching back to parent");
		System.out.println(driver.getTitle());

		driver.quit();
	}
}
