import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Disabled {

    public static void isEnabled(WebElement element) {
        String styles = element.getAttribute("style");
        if (styles.contains("opacity: 0.5")) {
            System.out.println("disabled");
        } else if (styles.contains("opacity: 1")) {
            System.out.println("enabled");
        }
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.spicejet.com/";
        driver.get(url);
        WebElement returnDate = driver.findElement(By.xpath("//div[text()='Select Date']"));
        isEnabled(returnDate);
        returnDate.click();
        isEnabled(returnDate);
        driver.quit();
    }
}
