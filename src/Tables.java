import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.cricbuzz.com/live-cricket-scorecard/40586/nz-vs-ned-3rd-odi-netherlands-tour-of-new-zealand-2022";
		driver.get(url);

		WebElement table = driver.findElement(By.cssSelector("div.cb-col.cb-col-100.cb-ltst-wgt-hdr"));
		int rowCount = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms")).size();
		int columnCount = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-ltst-wgt-hdr div:nth-child(3) div")).size();

		// print table
		int flag = 0;
		for (int i = 0; i < rowCount; i++) {
			WebElement row = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms")).get(i);
			for (int j = 0; j < columnCount; j++) {
				String column = row.findElements(By.tagName("div")).get(j).getText();
				if (column.contains("Extras")) {
					flag = 1;
					break;
				}
				int space = column.length() < 7 ? 7 : 30;
				System.out.printf("| %" + space + "s", column);
			}
			if (flag == 1) break;
			System.out.println("|");
		}

		// print two rows after table
		String extras = driver.findElement(By.xpath("//div[text()='Extras']")).getText();
		String extrasNumber = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		String total = driver.findElement(By.xpath("//div[text()='Total']")).getText();
		String totalNumber = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		System.out.println(extras + ": " + extrasNumber);
		System.out.println(total + ": " + totalNumber);

		driver.close();
	}
}
