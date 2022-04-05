import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class actionsFrame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://jqueryui.com/droppable";
		driver.get(url);

		System.out.println("Amount of frames on the page: " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		Actions a = new Actions(driver);
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
		a.dragAndDrop(draggable, droppable).build().perform();
		driver.switchTo().defaultContent();
		driver.quit();
	}
}
