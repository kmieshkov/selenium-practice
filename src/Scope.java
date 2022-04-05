import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {

	public static void main(String[] args) throws java.lang.InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);

		countLinks(driver);
		countFooterLinks(driver);
		countFirstColulmnFooterLinks(driver);
		clickOnFirstColulmnFooterLinks(driver);

		driver.quit();
	}

	private static void clickOnFirstColulmnFooterLinks(WebDriver driver) throws java.lang.InterruptedException {
		System.out.println("Click On First Colulmn Footer Links:");
		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> links = column.findElements(By.tagName("a"));

		// open every tab
		for (int i = 1; i < links.size(); i++) {
			WebElement link = links.get(i);
			String clickOnLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			link.sendKeys(clickOnLink);
		}

		Thread.sleep(5000L);

		// go to each tab and print title
		Set<String> list = driver.getWindowHandles();
		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			WebDriver window = driver.switchTo().window(iterator.next());
			System.out.println(window.getTitle());
		}
		System.out.println("----------------------------------------");
	}

	private static void countFirstColulmnFooterLinks(WebDriver driver) {
		System.out.println("The count of links in the first column of footer:");
		// Limiting webdriver section
		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		// or
		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul //a")).size());
		System.out.println("----------------------------------------");
	}

	private static void countFooterLinks(WebDriver driver) {
		System.out.println("The count of links on the footer section:");
		// Limiting webdriver section
		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		// or
		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG'] //a")).size());
		System.out.println("----------------------------------------");
	}

	public static void countLinks(WebDriver driver) {
		System.out.println("The count of links on the page");
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println("----------------------------------------");
	}
}
