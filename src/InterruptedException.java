import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class InterruptedException {

    public static void addItems(WebDriver driver, ArrayList<String> itemsNeeded) {
        String pattern = "translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')";
        for (String item : itemsNeeded) {
            driver.findElement(By.xpath("//h4[contains("+pattern+",'"+item+"')]/following-sibling::div[@class='product-action']/button")).click();
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
        WebDriver driver = new ChromeDriver();
        // implicit wait
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // implicit and explicit wait
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("cucumber");
        arr.add("tomato");
        arr.add("carrot");
        arr.add("banana");
        arr.add("corn");
        addItems(driver, arr);
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        // explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        // explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        String couponMessage = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        System.out.println(couponMessage);
        driver.close();
    }
}
