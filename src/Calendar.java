import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.path2usa.com/travel-companions";
		driver.get(url);

		// open calendar
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();

		// Select month
		String needleMonth = "August";
		while(!driver.findElement(By.xpath("//*[@class='datepicker-days'] //*[@class='datepicker-switch']")).getText().contains(needleMonth)) {
			driver.findElement(By.xpath("//*[@class='datepicker-days'] //th[@class='next']")).click();
		}

		// Select date
		String neededDate = "23";
		List<WebElement> dates = driver.findElements(By.cssSelector("day"));
		for (int i = 0; i < dates.size(); i++) {
			String date = dates.get(i).getText();
			if (date.equals(neededDate)) {
				dates.get(i).click();
				break;
			}
		}
		driver.quit();
	}

}
