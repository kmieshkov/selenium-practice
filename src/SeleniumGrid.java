import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/*
Set up Selenium grid for local network

1. Download Selenium Grid selenium-server-<version>.jar
2. Run the hub: java -jar selenium-server-4.1.3.jar hub
3. Install java jdk and download chromedriver to the node machine
4. Configure PATH (for Windows)
5. Run the node: java -jar -Dwebdriver.chrome.driver="<path-to-webdriver>" jar selenium-server-4.1.3.jar node --hub <ip-address>/grid/register --port 5566
	** -Dwebdriver.chrome.driver="<path-to-chromedriver>" -> for example C:\chromedriver_win32\chromedriver.exe
	** <ip-address> -> for example:  http://192.168.0.115:4444/
6. Go to http://localhost:4444/ to verify that node is connected successfully
*/

public class SeleniumGrid {

	public static void main(String[] args) throws MalformedURLException {
		// Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome"); // or firefox if using geckodriver
		capabilities.setPlatform(Platform.MAC);

		// hub ip address
		URL server = new URL("http://localhost:4444/wd/hub");
		// set up WebDriver for remote machine
		WebDriver driver = new RemoteWebDriver(server, capabilities);

		String url = "http://google.com";
		driver.get(url);

		System.out.println(driver.getCurrentUrl());

		driver.close();
	}
}
