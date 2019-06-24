package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class EnvironmentManager {
	public static void initWebDriver() {
		System.setProperty("webdriver.chrome.driver", findFile("chromedriver"));
//		System.setProperty("webdriver.chrome.driver", "test/resources/linux64Driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		RunEnvironment.setWebDriver(driver);
	}
	public static void shutDownDriver() {
		RunEnvironment.getWebDriver().quit();
	}

	static private String findFile(String filename) {
		String paths[] = {"", "bin/", "test/resources/linux64Driver"};
		for (String path : paths) {
			if (new File(path + filename).exists())
				return path + filename;
		}
		return "";
	}
}
