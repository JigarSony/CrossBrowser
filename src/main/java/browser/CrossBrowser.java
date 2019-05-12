package browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {

	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) {
		loadpprop();
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox browser");
		} else if (browserName.equals("safari")) {
			// safari - wait
			driver = new SafariDriver();
			System.out.println("safari browser");
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("edge browser");
		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("ie browser");
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			System.out.println("opera browser");
		} else if (browserName.equals("phantomjs")) {
			WebDriverManager.phantomjs().setup();
			driver = (WebDriver) new PhantomJsDriverManager();
			System.out.println("opera browser");
		} else if (browserName.equals("seleniumserverstandalone")) {
			WebDriverManager.seleniumServerStandalone().setup();
			driver = (WebDriver) new SeleniumServerStandaloneManager();
			System.out.println("seleniumserverstandalone browser");
		}

		driver.get(prop.getProperty("url"));
		System.out.println("Done");
	}

	public static void loadpprop() {
		prop = new Properties();
		String path = System.getProperty("user.dir");
		try {
			FileInputStream ipop = new FileInputStream(path + "/config.properties");
			try {
				prop.load(ipop);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
