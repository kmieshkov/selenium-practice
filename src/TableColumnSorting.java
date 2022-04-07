import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableColumnSorting {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(url);

		Select select = new Select(driver.findElement(By.xpath("//select[@id='page-menu']")));
		select.selectByValue("20");

		// click sort and check if sorted
		recursiveFunction(driver);

		driver.close();
	}

	private static void recursiveFunction(WebDriver driver) {
		if (isSorted(driver)) {
			// check if array is sorted
			System.out.println("Array is sorted");
		} else {
			// if not - click button and check again
			WebElement firstColumnHeader = driver.findElement(By.xpath("//span[contains(text(), 'Veg/fruit name')]"));
			if (!driver.findElement(By.xpath("//span[contains(text(), 'Veg/fruit name')]/parent::th")).getAttribute("aria-sort").equals("ascending")) {
				firstColumnHeader.click();
			}
			recursiveFunction(driver);
		}
	}

	private static boolean isSorted(WebDriver driver) {
		ArrayList<String> originalList = new ArrayList<>();
		List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));

		for (WebElement name : names) {
			originalList.add(name.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>(originalList);
		Collections.sort(sortedList);
		return originalList.equals(sortedList);
	}
}
