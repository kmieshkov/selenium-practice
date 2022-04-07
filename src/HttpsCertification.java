import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HttpsCertification {

	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions options = new ChromeOptions();
		options.merge(capabilities);

		System.setProperty("webdriver.chrome.driver", "/Users/kmieshkov/ProgramFiles/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		String url = "";
		driver.get(url);
	}
}
