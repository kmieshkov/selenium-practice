import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}
				return null;
			}
		});
		System.out.println(element.getText());
		driver.close();
	}
}
