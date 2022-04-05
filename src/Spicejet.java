import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Spicejet {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.spicejet.com/";
        driver.get(url);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // From
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-p1pxzi r-qi0n3 r-1otgn73']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/div/div/div/div[contains(text(), 'Kiev')]")).click();
        //  To
        driver.findElement(By.cssSelector("div[data-testid='to-testID-destination']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-p1pxzi r-qi0n3 r-1otgn73']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/div/div/div/div[contains(text(), 'Bangkok')]")).click();
        // Departure date
//        driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
        // select april 18
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-April-2022'] //div[@data-testid='undefined-calendar-day-18']")).click();
        // Return date
        driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).click();
        // select may 10
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-May-2022'] //div[@data-testid='undefined-calendar-day-10']")).click();
        // Passengers
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-19h5ruw r-184en5c']/div[@class='css-1dbjc4n']")).click();
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        }
        // Currency
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-19h5ruw r-184en5c']/div/following-sibling::div")).click();
        // choose USD
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-8fdsdq']/div/div/div/div[text()='USD']")).click();
        // Search
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
        driver.quit();
    }
}
